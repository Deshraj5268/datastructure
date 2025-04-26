package arrays.others;

import java.util.HashMap;
import java.util.Map;

/*
* https://www.geeksforgeeks.org/count-pairs-difference-equal-k/#expected-approachusing-hash-map-or-dictionary-on-time-and-on-space
* https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/
* */
public class CountPairWithAbsDiff {

    public static void main(String[] args) {
        int [][] mat = {{1, 4, 1, 4, 5},
                {8, 16, 12, 16, 4, 0}
        };
        int [] k = {3, 4};
        int [] expectedResult = {4, 5};
        int result;
        for(int i=0;i<mat.length;i++){
            result = countPairs(mat[i], k[i]);
            //System.out.println("result : "+result);
            if(expectedResult[i] == result){
                System.out.println("result : "+result);
            }else {
                System.out.println("not found");
            }
        }
    }
    public static int countPairs(int[] arr, int k) {
        // code here
        int countPair = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){

            if(freqMap.containsKey(arr[i]+k)){
                countPair += freqMap.get(arr[i]+k);
            }
            if(freqMap.containsKey(arr[i]-k)){
                countPair += freqMap.get(arr[i]-k);
            }
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0)+1);
        }
        return countPair;
    }

}
