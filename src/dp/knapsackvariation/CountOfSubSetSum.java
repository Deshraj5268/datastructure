package src.dp.knapsackvariation;

import java.util.Arrays;

public class CountOfSubSetSum {

    public static void main(String[] args) {
        int sum =1;//6
        int [] arr =  {1, 1, 1, 1};// {1, 2, 3, 3};
        System.out.println("input array : "+ Arrays.toString(arr)+" sum : "+sum);
        int result = countSubSetSum(arr,arr.length,sum);
        System.out.println("count of subset sum "+result);
    }

    public static int countSubSetSum(int [] arr,int n,int sum){
        int [][] tabSum = new int[n+1][sum+1];
        for(int j=0;j<=sum;j++){
            tabSum[0][j] = 0;//sum is not zero
        }
        for(int i=0;i<=n;i++){
            tabSum[i][0] = 1;//sum is  zero
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j) {
                    tabSum[i][j] = tabSum[i-1][j];
                }
                if(j>=arr[i-1]){
                    tabSum[i][j] = tabSum[i-1][j] + tabSum[i-1][j-arr[i-1]];
                }
            }
        }
        return tabSum[n][sum];
    }
}
