package dp;

import java.util.Arrays;

public class UnboundedKnapsack {

    public static int unboundedKnapsack(int [] wt,int [] val, int n, int W){
        if(n <= 0 || W <= 0){
            return 0;
        }
        if(wt[n-1] > W){
            return unboundedKnapsack(wt,val,n-1,W);
        }
        return Math.max(unboundedKnapsack(wt,val,n,W-wt[n-1])+val[n-1],
                unboundedKnapsack(wt,val,n-1,W));
    }

    public static int unboundedKnapsackWithMemoization(int [] wt,int [] val, int n, int W,int [][] dp){
        if(n <= 0 || W <= 0){
            return 0;
        }
        if(dp[n][W] !=0){
            return dp[n][W];
        }
        if(wt[n-1] > W){
            dp[n][W] = unboundedKnapsackWithMemoization(wt,val,n-1,W,dp);
            return dp[n][W];
        }
        int a = unboundedKnapsackWithMemoization(wt,val,n,W-wt[n-1],dp)+val[n-1];// reusing the same weight
        int b = unboundedKnapsackWithMemoization(wt,val,n-1,W,dp);
        dp[n][W] = Math.max(a,b);
        return dp[n][W];
    }

    public static int unboundedKnapsackTabulation(int [] wt,int [] val,int n,int W){
        int [] tab = new int[W+1];//default value set to 0
        for(int i=0;i<=W;i++){
            for(int j=0;j<n;j++){
                if(wt[j] <= i) {
                    tab[i] = Math.max(tab[i], tab[i - wt[j]] + val[j]);
                }
            }
           // System.out.println(Arrays.toString(tab));
        }
        return tab[W];

    }

    public static void main(String[] args) {
        int W = 6;
        int val[] = {10, 20, 30};
        int wt[] = {1, 2, 3};
        int n = val.length;
        System.out.println(unboundedKnapsack(wt,val,n,W));

        int [][] dp = new int[n+1][W+1];
        System.out.println(unboundedKnapsackWithMemoization(wt,val,n,W,dp));
        /*for(int i=0;i<=n;i++){
            System.out.println(Arrays.toString(dp[i]));
        }*/
        System.out.println(unboundedKnapsackTabulation(wt,val,n,W));
    }
}
