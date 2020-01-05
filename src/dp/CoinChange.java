package dp;

import java.util.Arrays;

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

    public static void main(String[] args) {
        int [] arr = {1, 2, 3};
        int sum = 4;
        System.out.println(coinChange(arr,arr.length,sum));

        System.out.println("coin change using tabulation : "+coinChangeTab(arr,arr.length,sum));
        for(int i=0;i<coinChangeArr.length;i++){
            System.out.println(Arrays.toString(coinChangeArr[i]));
        }
    }
}