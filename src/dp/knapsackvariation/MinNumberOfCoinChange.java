package dp.knapsackvariation;

import java.util.Arrays;

public class MinNumberOfCoinChange {

    public static void main(String[] args) {
        int coins[] = {25, 10, 5};
        int sum= 30;
        System.out.println("result : "+minNumberOfCoinChange(coins,coins.length,sum));
    }

    public static int minNumberOfCoinChange(int [] coins,int n,int sum){
        int [][] tab = new int[n+1][sum+1];
        //row initialization
        for(int j=0;j<=sum;j++){
            tab[0][j] = Integer.MAX_VALUE-1; // infinite way if we don't have coins
        }
        for(int i=0;i<=n;i++){
            tab[i][0] = 0; // 0 way , if we have sum ==0 , so no matter how many coins we have
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(coins[i-1] <= j){
                    tab[i][j] = Math.min((1+tab[i][j-coins[i-1]]),tab[i-1][j]);
                }else{
                    tab[i][j] = tab[i-1][j];
                }
            }
        }

        //print matrix
        for(int i=0;i<=n;i++){
            System.out.println(Arrays.toString(tab[i]));
        }
        return tab[n][sum] == Integer.MAX_VALUE-1?-1:tab[n][sum];
    }
}
