package dp;

public class Fibonacci {
    public static int first = 0;
    public static int second = 1;
    public static int [] fibMemoizationArr;

    public static int fib(int n){
        if(first == n || second == n){
            return n;
        }
        int fib =  fib(n-1)+fib(n-2);
        return fib;
    }

    public static int fibTabulation(int n){
        int [] fibArr = new int[n+1];
        fibArr[0] = first;
        fibArr[1] = second;
        for(int i=2;i<=n;i++){
            fibArr[i] = fibArr[i-1]+fibArr[i-2];
        }
        return fibArr[n];
    }

    public static int fibMemoization(int n){
        if(first == n || second == n){
            return n;
        }
        if(fibMemoizationArr[n-1] != 0){
            return fibMemoizationArr[n-1];
        }
        if(fibMemoizationArr[n-2]!= 0){
            return fibMemoizationArr[n-2];
        }
        fibMemoizationArr[n] = fibMemoization(n-1)+fibMemoization(n-2);
        return fibMemoizationArr[n];
    }

    public static int fibNumWithPreCal(int n){
        int f = first;
        int s= second;
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
        System.out.println("initial values: "+first+" "+second);
        System.out.println("recursive : "+fib(n));

        //tabulation
        System.out.println("tabulation : "+fibTabulation(n));

        //memoization
        fibMemoizationArr = new int[n+1];
        System.out.println("memoization : "+fibTabulation(n));

        //pre-calculation
        System.out.println("pre-calculation :"+fibNumWithPreCal(n));
    }
}
