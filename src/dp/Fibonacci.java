package dp;

public class Fibonacci {
    public static int [] fibMemoizationArr;

    public static int fib(int n){
        /*
        * always handle the base condition ex initial two value a = 0 , b = 2
        * f(0) = 0
        * f(1) = ?
        * f(2) = 2
        * so in this case we can say f(1) = 1
        * if(n == 0 || n == 1 || n ==2 ){ return n;}
        *
        * */
        if(n == 0 || n == 1){
            return n;
        }
        int fib =  fib(n-1)+fib(n-2);
        return fib;
    }

    public static int fibTabulation(int n){
        int [] fibArr = new int[n+1];
        fibArr[0] = 0;
        fibArr[1] = 1;
        for(int i=2;i<=n;i++){
            fibArr[i] = fibArr[i-1]+fibArr[i-2];
        }
        return fibArr[n];
    }

    public static int fibMemoization(int n){
        if(n == 0 || n == 1){
            return n;
        }
        if(fibMemoizationArr[n] != 0){
            return fibMemoizationArr[n];
        }
        fibMemoizationArr[n] = fibMemoization(n-1)+fibMemoization(n-2);
        return fibMemoizationArr[n];
    }

    public static int fibNumWithPreCal(int n){
        int f = 0;
        int s= 1;
        int nthNum=0;
        if(n == f || n == s){
            return n;
        }
        for(int i=2;i<=n;i++){
            nthNum = f + s;
            f = s;
            s = nthNum;
        }
        return nthNum;
    }

    public static void main(String[] args) {
        int n = 9;//nth fib num
        System.out.println("nth number : "+n);
        System.out.println("initial values: "+ 0 +" "+1);
        System.out.println("recursive : "+fib(n));

        //tabulation
        System.out.println("tabulation : "+fibTabulation(n));

        //memoization
        fibMemoizationArr = new int[n+1];
        System.out.println("memoization : "+fibMemoization(n));

        //pre-calculation
        System.out.println("pre-calculation :"+fibNumWithPreCal(n));
    }
}
