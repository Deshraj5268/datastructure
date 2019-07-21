package dp;

import java.util.Scanner;


/*
* https://www.geeksforgeeks.org/sum-numbers-can-formed-permutations-n-digits/
* */
public class NumberFormation {

    public static final int MODULO =10^9+7;

    public static long noFormationSum(int [] arr){
       // int [] fact = {1,2,6,24,120,720,5040,40320,362880};
        int sum = 0;
        for(int i:arr){
            sum += i;
        }
        int finalSum = 0;
        int n = arr.length;
        int m = 1;
        int factorial  = 1;
        for(int i=1;i<=n;i++){
            factorial = ((factorialUptok(n,i)/n)*sum)%MODULO;
            for(int k = 1;k<=n;k++) {
                finalSum +=  factorial*m; //fact(n to k)/n
                m*=10;
            }
        }
        return finalSum;
    }

    private static int factorialUptok(int n, int k) {
        int fac = 1;
        for(int i=n;i>=k;i--){
            fac*=i;
        }
        return fac;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0){
            int x = sc.nextInt();
            int y =sc.nextInt();
            int z = sc.nextInt();
            int [] arr = {x,y,z};
            System.out.println(noFormationSum(arr));
            t--;
        }
    }
}
