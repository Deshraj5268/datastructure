package dp.mcmvariation;

import java.util.Arrays;

/*
* https://takeuforward.org/dynamic-programming/matrix-chain-multiplication-dp-48/
* https://www.youtube.com/watch?v=kMK148J9qEE&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=33
* https://www.youtube.com/watch?v=9uUVFNOT3_Y&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=35
* */
public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 3, 4};
        int n = arr.length;
        int result = mcmRecursive(arr, 1, n-1);
        int [][] dp = new int [n+1][n+1];
        int result1 = mcmMemoization(arr,1, n-1, dp);

        System.out.println("result : "+ result);
        System.out.println("result1 : "+result1);

        for(int [] dpArr : dp){
            System.out.println(Arrays.toString(dpArr));
        }
    }


    /*
    * format :
    * for(i=1 less equal to j-1)
    *  fun(arr, i, k) + fun(arr,k+1,j) + arr[i-1]*arr[k]*arr[j]
    * */
    public static int mcmRecursive(int [] arr, int i, int j){
        if(i == j){
            return 0;
        }
        int temp, ans = Integer.MAX_VALUE;
        for(int k=i;k <= j-1;k++){
            temp = mcmRecursive(arr, i, k)+
                    mcmRecursive(arr, k+1,j)
                    + arr[i-1]*arr[k]*arr[j];
            if(ans > temp){
                ans = temp;
            }
        }
        return ans;
    }

    public static int mcmMemoization(int [] arr, int i, int j, int [][] dp){

        if(i == j){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int temp, ans = Integer.MAX_VALUE;
        for(int k=i;k <= j-1;k++){
            temp = mcmMemoization(arr, i, k, dp)+
                    mcmMemoization(arr, k+1,j, dp)
                    + arr[i-1]*arr[k]*arr[j];

            if(ans > temp){
                ans = temp;
            }
        }
        dp[i][j] = ans;
        return ans;
    }
}
