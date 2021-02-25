package arrays;

import java.util.Scanner;

public class SubArrTargetSum {

    public static void subArraySumWithGivenTarget1(int [] arr,int l,int r,int targetSum){

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
