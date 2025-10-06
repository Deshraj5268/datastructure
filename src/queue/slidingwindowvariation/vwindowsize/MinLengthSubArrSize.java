package queue.slidingwindowvariation.vwindowsize;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinLengthSubArrSize {

    public static void main(String[] args) {
        int [][] arr = {{2,3,1,2,4,3},
                {1,4,4},
                {1,1,1,1,1,1,1,1}
        };
        //int n = arr.length;
        int [] target = {7, 4, 11};
        for(int i=0;i<arr.length;i++) {
            int[] indexResult = minSubArrayLen(arr[i], target[i]);
            System.out.println("input " + Arrays.toString(arr[i]) +
                    "sum : " + target[i] + "\nLength = " + Arrays.toString(indexResult));
        }
    }

    public static int [] minSubArrayLen( int[] nums, int target) {
        int sum = 0;
        int [] indexResult = new int[2];
        int l = 0, r = 0, n = nums.length;
        int minLength = Integer.MAX_VALUE;

        while ( r < n){
            sum += nums[r];
            while(sum >= target){
                if(minLength > (r-l+1)){
                    minLength = r-l+1;
                    indexResult[0] = l;
                    indexResult[1] = r;
                }
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return indexResult;
    }
}
