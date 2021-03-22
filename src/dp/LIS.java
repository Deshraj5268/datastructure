package dp;

import java.util.Arrays;

/*
* https://www.youtube.com/watch?v=cjWnW0hdF1Y
* */
public class LIS {

    static int globalMax;
    static int [] LIS;
    public static void main(String[] args) {
        globalMax = 1;
        int [] arr = {8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
                // { 10, 22, 9, 33, 21, 50, 41, 60 };
        LIS lisObj = new LIS();
        System.out.println(lisObj.lis(arr,arr.length));
        System.out.println(lisObj.lisDP(arr,arr.length));
        System.out.println(lisObj.lisSubSetGeneration(arr,0,arr.length,Integer.MIN_VALUE));

        LIS = new int[arr.length];
        System.out.println(" lis Dp" +lisObj.lisSubSetGenerationDP(arr,arr.length-1,Integer.MIN_VALUE));
    }


    /*
     * include or exclude : sub set problem
     * */
    public int lisSubSetGeneration(int [] arr,int i,int n,int prev){ //prev = min
        if(n == i){
            return 0;
        }
        int exclude = lisSubSetGeneration(arr,i+1,n,prev);// exclude

        int include = 0;
        if(arr[i] > prev){
            include = 1+lisSubSetGeneration(arr,i+1,n,arr[i]);
        }
        return Math.max(exclude,include);
    }


    //giving wrong answer
    public int lisSubSetGenerationDP(int [] arr,int n,int prev){ //prev = min
        if(n == -1){
            return 0;
        }
        if(LIS[n] != 0){
            return LIS[n];
        }
        if(prev > arr[n]){
            LIS[n] = lisSubSetGenerationDP(arr,n-1,prev);
            return LIS[n];
        }
        LIS[n] = Math.max(1+lisSubSetGenerationDP(arr,n-1,arr[n]),
                lisSubSetGenerationDP(arr,n-1,prev));
        return LIS[n];
    }

    /*
    * longestIncreasingSubSequence
    *  f(m) = 1+{f(m...1) : 0<i<j<n
    *
    *
    *                     f(m)
    *
    *     f(m-1)         f(m-2)                    f(m-3) ....
    * f(m-2) f(m-3)..   f(m-3) f(m-4) f(m-5)..    f(m-4) f(m-5)..
    * */
    public int lis(int [] arr,int n){
        if(n == 1){
            return 1;
        }
        int maxResult = 1;
        int tempResult;
        for(int i=1;i<n;i++){
            tempResult = lis(arr,i);
            if(arr[i-1] < arr[n-1] && maxResult < tempResult+1){
                maxResult = tempResult+1;
            }
        }
        if(globalMax < maxResult){
            globalMax = maxResult;
        }
        return maxResult;
    }

    public int lisDP(int [] arr,int n){
        int [] LIS = new int[n];
        Arrays.fill(LIS,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i] && LIS[i] < LIS[j]+1){
                    LIS[i] = 1+LIS[j];
                }
            }
        }
        int max = Arrays.stream(LIS).max().getAsInt();
        return max;
    }
}
