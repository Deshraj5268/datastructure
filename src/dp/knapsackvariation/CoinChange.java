package dp.knapsackvariation;

import java.util.Arrays;

/*
* https://www.geeksforgeeks.org/coin-change-dp-7/
*
* number of ways to change the coin
* */
public class CoinChange {

    private static int [][] coinChangeArr;

    //divide solution in two sub set , that include coin when at least one solution exist or exclude
    public static int coinChange(int [] arr,int n,int sum){
        //sum == 0 include in solution
        if(sum == 0){
            return 1;
        }
        //sum < 0 do not have amount Or (n <= 0 &&  sum >=1 amount exist but do not have coin
        if(sum < 0 || (sum >=1 && n <=0)){
            return 0;
        }
        return coinChange(arr,n-1,sum)
                + coinChange(arr,n,sum-arr[n-1]);
    }

    public static int coinChangeTab(int [] arr,int n,int sum){
        coinChangeArr = new int[sum+1][n];
        int x;
        int y;
        for(int j=0;j<n;j++){
            coinChangeArr[0][j] = 1;
        }
        for(int i=1;i<=sum;i++){
            for(int j=0;j<n;j++){
                //include solution
               x = (i-arr[j] >=0)? coinChangeArr[i-arr[j]][j]: 0;
               y = (j >=1)?coinChangeArr[i][j-1]:0;
               coinChangeArr[i][j] = x + y;
            }
        }
        return coinChangeArr[sum][n-1];
    }

    public static int coinChangeUn01Variation(int [] arr,int n,int sum){
        coinChangeArr = new int[n+1][sum+1];

        for(int j=0;j<=n;j++){
            coinChangeArr[0][j] = 0;
        }
        for(int i=0;i<=n;i++){
            coinChangeArr[i][0] = 1; // empty set
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    coinChangeArr[i][j] = coinChangeArr[i-1][j] + coinChangeArr[i][j-arr[i-1]];
                }else{
                    coinChangeArr[i][j] = coinChangeArr[i-1][j];
                }
            }
        }
        return coinChangeArr[n][sum];
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3};
        int sum = 4;
        System.out.println(coinChange(arr,arr.length,sum));

        System.out.println("coin change using tabulation : "+coinChangeTab(arr,arr.length,sum));
        for(int i=0;i<coinChangeArr.length;i++){
            System.out.println(Arrays.toString(coinChangeArr[i]));
        }

        System.out.println("coin change using 01 unbounded knapsack  : "+coinChangeUn01Variation(arr,arr.length,sum));
        for(int i=0;i<coinChangeArr.length;i++){
            System.out.println(Arrays.toString(coinChangeArr[i]));
        }
    }
}