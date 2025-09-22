package arrays.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourSumTarget {

    public static void main(String[] args) {
        int [][] mat = {{1,1,1,1},{1,5,7,1}};
        int [] kArr = {2,6};
        int [] output = {6,2};
        for(int i=0;i<kArr.length;i++){
            System.out.println("array input "+ Arrays.toString(mat[i]) + " k : "+kArr[i]);
            int allPairCount = getPairsCount(mat[i],mat[i].length,kArr[i]);
            System.out.println("all pair count including duplicate "+ allPairCount);
            int uniquePair = uniquePair(mat[i],mat[i].length,kArr[i]);
            System.out.println("all uniquePair pair count  "+ uniquePair);
        }
    }


    public static int uniquePair(int [] arr,int n,int k){
        int i=0,j=n-1;
        int sum=0;
        int count=0;
        Arrays.sort(arr);
        while (i<j) {

            sum = arr[i] + arr[j];
            if (sum == k) {
                count++;
                i++;
                j--;
            } else if (sum > k) {
                j--;
            } else {
                i++;
            }
            // duplicate ignoring
            if ((i + 1) < j && arr[i] == arr[i + 1]) {
                i++;
                continue;
            }
            if ((j - 1 >= 0) && arr[j] == arr[j - 1]) {
                j--;
                continue;
            }
        }
            return count;
    }


    /*
    *
    *
    * */
    public static int getPairsCount(int[] arr, int n, int k) {
        int pair=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int t=0;t<n;t++){
            Integer count = map.get(k-arr[t]);
            if(count != null){
                pair+=count;

            }
            if(map.containsKey(arr[t])){
                map.put(arr[t],map.getOrDefault(arr[t],0)+1);
            }
            else{
                map.put(arr[t],1);
            }
        }
        return pair;
    }
}
