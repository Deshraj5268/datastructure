package arrays.others;

import java.util.Arrays;

public class ClosestTargetThreeSum {

    public static void main(String[] args) {

        int [][] mat = {{-1, 2, 1, -4}};
        int [] target = {1};
        for(int i=0;i<mat.length;i++) {
            System.out.println("input : " + Arrays.toString(mat[i]));
            long result = closesSumOfThreeElements(mat[i], target[i]);
            System.out.println("result "+result);
        }
    }

    public static long closesSumOfThreeElements(int [] arr,int target){
        Arrays.sort(arr);
        int closestSum = Integer.MAX_VALUE;
        int l,r,n=arr.length;
        int currentSum;
        for(int i=0;i<n-1;i++){
            l=i+1;
            r=n-1;
            while (l<r){
                currentSum = arr[i] + arr[l]+arr[r];
                if(Math.abs(target-closestSum) > Math.abs(target - currentSum)){
                    closestSum = currentSum;
                }
                if(currentSum < target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return closestSum;
    }
}
