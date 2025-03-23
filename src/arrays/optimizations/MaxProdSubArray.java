package arrays.optimizations;


import java.util.Arrays;

/*
* https://www.youtube.com/watch?v=hJ_Uy2DzE08
* https://www.youtube.com/watch?v=lXVy6YWFcRM : also good
* */
public class MaxProdSubArray {
    public static void main(String[] args) {

        int [][] mat = {{1,2,3,4,5},
                {1,2,3,-4,2},
                {-1,-5,-6},
                {0,0,-20,0},
                {-2,3,4,2},
                {2,3,-2,4}
        };
        for(int i=0;i<mat.length;i++){
            System.out.println("inout array : "+ Arrays.toString(mat[i]));
           long max =  maxProductKadansWay(mat[i],mat[i].length);
            System.out.println(max);
        }
    }

    public static   long maxProductBasic(int[] arr, int n) {
        // code here
        if(arr == null || arr.length == 0){
            return 0;
        }
        if(arr.length == 1){
            return arr[0];
        }
        long maxProd = 0;
        long temp = 0;

        for(int i=0;i<n;i++){
            temp = arr[i];
            if(maxProd < temp){
                maxProd = temp;
            }
            for(int j = i+1;j<n;j++){
                temp *= arr[j];
                if(maxProd < temp){
                    maxProd = temp;
                }
            }
        }
        return maxProd;
    }

    public static long  maxProductKadansWay(int[] arr, int n) {
        // code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        long maxEndingHere;
        long minEndingHere;
        long maxSoFar;
        long temp;
        maxEndingHere = minEndingHere = maxSoFar = arr[0];
        for (int i = 1; i < n; i++) {
            temp = maxOfThree(arr[i], maxEndingHere*arr[i], minEndingHere*arr[i]);
            minEndingHere = minOfThree(arr[i],maxEndingHere*arr[i], minEndingHere*arr[i]);
            maxEndingHere = temp;
            maxSoFar = Math.max(maxEndingHere,maxSoFar);
        }
        return maxSoFar;
    }

    private static long maxOfThree(long a,long b,long c){
        return Math.max(Math.max(a,b),c);
    }

    private static long minOfThree(long a,long b,long c){
        return Math.min(Math.min(a,b),c);
    }
}
