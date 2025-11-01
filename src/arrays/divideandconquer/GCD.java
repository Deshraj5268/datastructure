package arrays.divideandconquer;

import java.util.Arrays;

public class GCD {

    public static void main(String[] args) {
        int [][] gcds = {{2,3}, {10 , 100}, {5, 25}};
        for(int i=0;i<gcds.length;i++){
            System.out.println("gcd of two number :"+ Arrays.toString(gcds[i])+" :"+gcd(gcds[i][0], gcds[i][1]));
        }
    }

    public static int gcd(int m , int n){
        if(m == 0 && n == 0){
            return -1;
        }
        if(n == 0){
            return m;
        }
        return gcd(n , m%n);
    }
}
