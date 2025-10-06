package queue.slidingwindowvariation;

import java.util.HashMap;
import java.util.Map;

public class MaxSumSubArrayWinK {

    public static void main(String[] args) {
        int [] winSizes = {3};
        int [][] arrays = {{2,5,1,8,2,9,1},
                           };
        int [] outputArr = {19};
        int result;
        for(int i=0;i<arrays.length;i++){
            result = maxSumSubArrayOfSizeK(arrays[i],arrays[i].length,winSizes[i]);
            System.out.println("result : "+result+ " expected :"+outputArr[i]);
            result = maxSumSubArrayOfSizeKOpt(arrays[i],arrays[i].length,winSizes[i]);
            System.out.println("resultOpt : "+result+ " expected :"+outputArr[i]);
        }
    }

    public static int maxSumSubArrayOfSizeK(int [] arr,int n,int k){
        int maxSum = 0;
        int currentSum = 0;
        for(int i=0;i<n-k;i++){
            currentSum = 0;
            for(int j=i;j<i+k;j++){
                currentSum+= arr[j];
            }
            if(maxSum < currentSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    /*
    * start with i=0,j=0 pointers
    * sum the element
    * if j with in window size k then
    * j++;
    * else
    * store maxSum
    * currentSum-= arr[i]
    * i++;
    * j++;
    * */
    public static int maxSumSubArrayOfSizeKOpt(int [] arr,int n,int k){
        int currentSum = 0;
        int maxSubArrSum = 0;
        int i=0,j=0;
        while(j<n){
            currentSum += arr[j];
            if((j-i+1) < k){ //less than the window size k
                j++;
            }else{
                if(maxSubArrSum < currentSum){
                    maxSubArrSum = currentSum;
                }
                currentSum -= arr[i];
                i++;
                j++;
            }
        }
        return maxSubArrSum;

    }


    /*
    * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
    * */
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long max=0;
        int i=0,j=0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        while(j < n){
            sum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            if((j-i+1) < k){
                j++;
            }else {
                if(map.size() == k && max < sum){
                    max = sum;
                }
                sum -= nums[i];
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
                j++;
            }
        }
        return max;
    }

}
