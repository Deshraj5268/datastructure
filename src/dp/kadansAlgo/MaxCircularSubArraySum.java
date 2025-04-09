package dp.kadansAlgo;

public class MaxCircularSubArraySum {

    public static void main(String[] args) {
        int [][] mat = {{1,-2,3,-2},
                {5,-3,5},
                {-3,-2,-3}
        };
        int result;
        for(int [] arr : mat){
            result = maxSubArraySumCircular(arr);
            System.out.println("result "+result);
        }
    }

    /*
    * Case 1: The subarray with the maximum sum does not include the circular part, which is the ordinary maximum subarray sum;
      Case 2: The subarray with the maximum sum includes the circular part, which can be transformed into:
      * the total sum of the array minus the minimum subarray sum.
    * */
    public static int maxSubArraySumCircular(int[] nums) {
        int n = nums.length;
        int cMaxSum, cMinSum, maxSum, minSum, totalSum;
        cMaxSum = cMinSum = maxSum = minSum = totalSum = nums[0];
        for(int i=1;i<nums.length;i++){
            totalSum += nums[i];
            cMaxSum = Math.max(cMaxSum + nums[i], nums[i]);
            cMinSum = Math.min(cMinSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum , cMaxSum);
            minSum = Math.min(minSum , cMinSum);
        }
        return maxSum < 0 ? maxSum : Math.max(maxSum, totalSum-minSum);
    }
}
