package arrays.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/*
*
* https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
* */
public class TargetThreeSum {

    public static void main(String[] args) {
        int [][] mat = {{2,3,2,3},
                {24,12,3,4,1,6,9}};
        int [] target = {6,24};
        for(int i=0;i<mat.length;i++){
            System.out.println("input Array :"+ Arrays.toString(mat[i]) + " target :"+target[i]);
            boolean result = find3Numbers(mat[i],mat[i].length,target[i]);
            System.out.println("is three number exist-> "+(result?"YES":"NO"));
        }
    }

    public static boolean find3Numbers(int [] arr, int n, int target) {

        // Your code Here
        if(n <3){
            return false;
        }


        int twoNumSum;
        Integer val;
        for(int i=0;i<n;i++){
            twoNumSum = target-arr[i];
            Map<Integer,Integer> map = new HashMap<>();
            for(int j = i+1;j<n;j++){
                val = map.get(twoNumSum - arr[j]);
                if(val == null){
                    map.put(arr[j],arr[j]);
                }else{
                    return true;
                }
            }
        }
        return false;

    }
}
