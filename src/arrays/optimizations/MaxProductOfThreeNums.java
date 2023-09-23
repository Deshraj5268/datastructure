package arrays.optimizations;

import java.util.Arrays;

public class MaxProductOfThreeNums {

    public static void main(String[] args) {

        int [][] mat = {{-100,-98,-1,2,3,4},
                {1,2,3,4,6},
                {10,8,9,3,1}};

        for(int i=0;i<mat.length;i++){
            System.out.println("input : "+Arrays.toString(mat[i]));
            int result = maximumProduct(mat[i]);
            System.out.println("result " +result);
        }

    }


    public  static int maximumProduct(int[] arr) {
        int n= arr.length;
        Arrays.sort(arr);
        return Math.max(arr[n-3]*arr[n-2]*arr[n-1],
                arr[0]*arr[1]*arr[n-1]);

    }
}
