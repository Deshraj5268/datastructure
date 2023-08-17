package dp;

/*
* https://leetcode.com/problems/house-robber-ii/description/
* */
public class MaxSubArrSumWOAdjElementInCircleArr {

    public static void main(String[] args) {
        int [] nums = {2,3,2};
        System.out.println(rob(nums));
    }

    public static int rob(int[] arr) {
        int n = arr.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return arr[0];
        }
        return Math.max(robHelper(arr,0,n-2),
                robHelper(arr,1,n-1));

    }

    public static int robHelper(int [] arr,int start,int n){
        int rob1=0;
        int rob2=0;
        int temp=0;
        for(int i=start;i<=n;i++){
            temp = Math.max(rob1+arr[i],rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return temp;
    }
}
