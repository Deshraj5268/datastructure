package dp.kadansAlgo;

public class MaxSubArrSumWOAdjElement {

    public static void main(String[] args) {
        int [] nums = {2,7,9,3,1};
        System.out.println(maxSubArrSumWOAdjElement(nums));
    }

    /*
     * max(M[i-2]+a[i],M[i-1]);
     * */
    public static int maxSubArrSumWOAdjElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int l = nums.length;
        if(l == 1){
            return nums[0];
        }
        int [] m = new int[l];
        m[0] = nums[0];
        m[1] = Math.max(nums[0],nums[1]);
        if(l == 2){
            return m[1];
        }
        for(int i=2;i<l;i++){
            m[i] = Math.max((m[i-2]+nums[i]),m[i-1]);
        }
        return m[l-1];
    }
}
