package arrays.subarray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SubArrTargetSum {


    /*
    * adding element until sum>target if so reduce this some by first element of this sub array
    * */
    public static void subArraySumUsingSlidingWindow(int [] arr, int l, int r, int targetSum){

        int currentSum = arr[l];
        int start = l;
        for(int i=l+1;i<=r;i++){
            while (currentSum > targetSum && start < i-1){
                currentSum = currentSum - arr[start];
                start++;
            }
            if(currentSum == targetSum){
                System.out.println((start+1) +" "+i);
                return;
            }
            if(i < r){
                currentSum += arr[i];
            }
        }
        System.out.println(-1);
        return;
    }

    public static void subArraySumWithGivenTarget2(int [] arr,int l,int r,int sum) {
        int curr_sum, i, j;

        // Pick a starting point
        for (i = 0; i < r + 1; i++) {
            curr_sum = arr[i];

            // try all subarrays starting with 'i'
            for (j = i + 1; j <= r + 1; j++) {
                if (curr_sum == sum) {
                    System.out.println((i+1)+" "+j);
                    return;
                }
                if (curr_sum > sum || j == r + 1)
                    break;
                curr_sum = curr_sum + arr[j];
            }
        }
        System.out.println(-1);
        return;
    }

    /*
    * Calculate current with Curr element S , and story this currentSum in Map
    * check if(curr-sum == 0) then take 0 to ith subarray
    * if(currSum-Sum == calculatedPreviousSum) then return the subarray
    *
    * */
    public static void subArrSumToTargetWithNegNumber(int [] arr,int l, int r,int target){
        int s = l; //l =0
        int e = -1;
        Map<Integer,Integer> map = new HashMap<>();
        int currSum = 0;
        for(int i=l;i<r;l++){
            currSum += arr[i];

            if(currSum-target == 0){
                s = l;
                e = i;
                break;
            }
            if(map.containsKey(currSum-target)){
                s = map.get(currSum-target)+1; // Sum(0,i) so exclude that ith index
                e = i;
                break;
            }
            map.put(currSum,i); // sum(l,i)
        }
        if(e == -1){
            System.out.println(-1);
        }else {
            System.out.println("start :"+s+" end :"+e);
        }
    }



    /*
    * Find the smallest negative element in the array and increment every value in the array by the absolute value of the smallest negative element found.
    * Every time while adding elements to the window, increment the target sum by the absolute value of the minimum element and similarly while removing elements from the current window, decrement the target sum by the absolute value of the minimum element so that for every subarray of length say K, the updated target sum will be:
    * targetSum = sum + K*abs(minimum element)
    * */
    public static void subArraySumUsingSlidingWindowForNegNum(int [] arr, int l, int r,int defaultMinEle, int targetSum){

        defaultMinEle = Arrays.stream(arr).min().getAsInt();
        defaultMinEle = Math.abs(defaultMinEle);
        int currentSum = arr[l]+defaultMinEle;
        int start = l;
        for(int i=l+1;i<=r;i++){
            while (currentSum - (i-start)*defaultMinEle > targetSum && start < i-1){
                currentSum = currentSum - arr[start] - defaultMinEle;
                start++;
            }
            if(currentSum - (i-start)*defaultMinEle == targetSum){
                System.out.println((start+1) +" "+i);
                return;
            }
            if(i < r){
                currentSum += arr[i]+defaultMinEle;
            }
        }
        System.out.println(-1);
        return;
    }

    public static void main(String[] args) {
        /*int [] arr = {1, 2, 3, 7, 5};
        int targetSum = 12;
        subArraySumWithGivenTarget1(arr,0,arr.length-1,targetSum);
        */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0){
            int n = sc.nextInt();
            int targetSum = sc.nextInt();
            int [] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            subArraySumWithGivenTarget2(arr,0,arr.length-1,targetSum);
            System.out.println();
            t--;
        }
    }
}
