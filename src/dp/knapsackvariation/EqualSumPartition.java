package src.dp.knapsackvariation;

import java.util.Arrays;

public class EqualSumPartition {

    public static void main(String[] args) {
        int n = 4;
        int [] arr =  {1, 5, 11, 5};
        System.out.println("input : "+ Arrays.toString(arr));
        boolean result = isEqualSumPartitionExist(arr,n);
        System.out.println("result " + result);

    }

    public static boolean isEqualSumPartitionExist(int [] arr,int n){
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }
        if(sum %2 == 1){ // if sum is odd so equal sum partition not possible
            return false;
        }
        sum = sum/2;
       boolean isExist =  SubSetSum.isSubSetSumUsingTab(arr,n,sum);
       return isExist;
    }

}
