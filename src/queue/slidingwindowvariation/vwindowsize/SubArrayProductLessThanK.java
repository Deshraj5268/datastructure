package queue.slidingwindowvariation.vwindowsize;

import java.util.Arrays;


/*
 //https://leetcode.com/problems/subarray-product-less-than-k/
* Given an array of integers nums and an integer k, return the number of contiguous subarrays ( count)
* where the product of all the elements in the subarray is strictly less than k.*/
public class SubArrayProductLessThanK {


    public static void main(String[] args) {
        int [][] arr = {{10,5,2,6},
                {1,2,3},
                {1,1,1}
        };
        //int n = arr.length;
        int [] target = {100, 0, 1};
        for(int i=0;i<arr.length;i++) {
            int count = numSubarrayProductLessThanK(arr[i], target[i]);
            System.out.println("input " + Arrays.toString(arr[i]) +
                    "sum : " + target[i] + "\nLength = " + count);
        }
    }



    /*
    * Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106
    * */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        long product = 1;
        int l=0,r=0,n = nums.length;
        int ans = 0;
        while(r < n){
            product *= nums[r];
            while(product >= k){
                product /= nums[l];
                l++;
            }
            ans += (r-l+1);
            r++;
        }
        return ans;
    }
}
