package dp;

public class SubSetSum {

    public static boolean [][] tabSum;

    public static boolean isSubSetSum(int [] arr,int n,int sum){
        if(sum == 0){
            return true;
        }
        if(n == 0 && sum != 0){
            return false;
        }
        if(arr[n-1] > sum){
            return isSubSetSum(arr,n-1,sum);
        }
        return  (isSubSetSum(arr,n-1,sum) ||  isSubSetSum(arr,n-1,sum-arr[n-1]));
    }

    public static boolean isSubSetSumUsingTab(int [] arr,int n,int sum ){
        tabSum = new boolean[n+1][sum+1];
        for(int j=0;j<=sum;j++){
            tabSum[0][j] = false;//sum is not zero
        }
        for(int i=0;i<=n;i++){
            tabSum[i][0] = true;//sum is  zero
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j) {
                    tabSum[i][j] = tabSum[i-1][j];
                }
                if(j>=arr[i-1]){
                    tabSum[i][j] = tabSum[i-1][j] || tabSum[i-1][j-arr[i-1]];
                }
            }
        }

        //print matrix

        /*for(int i=0;i<=n;i++){
            for(int j=0;j<=)
        }*/

        return tabSum[n][sum];

    }

    public static void main(String[] args) {

        int [] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        boolean result = isSubSetSum(arr,arr.length,sum);
        if(result){
            System.out.println("sum is exist");
        }else {
            System.out.println("sum is not exist");
        }

         result = isSubSetSumUsingTab(arr,arr.length,sum);
        if(result){
            System.out.println("sum is exist");
        }else {
            System.out.println("sum is not exist");
        }
    }
}
