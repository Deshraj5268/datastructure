package dp;

public class Factorial {

    public static int factorialGen(int n){
        return factorialDp(n);
    }
    public static int factorialDp(int n){
        if(n == 1){
            return 1;
        }
        return n*factorialDp(n-1);
    }


    public static void main(String[] args) {
        int n = 9;
        for(int i=1;i<=9;i++) {
            System.out.print(factorialGen(i) + ",");
        }
    }
}
