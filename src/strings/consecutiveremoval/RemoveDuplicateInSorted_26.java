package strings.consecutiveremoval;

import java.util.Arrays;

/*
* https://leetcode.com/problems/remove-duplicates-from-sorted-array/
* */
public class RemoveDuplicateInSorted_26 {

    public static void main(String[] args) {

        int [][] mat = {{1,1,2},
                {0,0,1,1,1,2,2,3,3,4}};

        for(int i=0;i<mat.length;i++){
            System.out.println("input : "+ Arrays.toString(mat[i]));
            int uniqueElementCount = removeDuplicateAppearsOnce(mat[i]);
            System.out.println("uniqueElementCount : "+uniqueElementCount);
            // System.out.println("approach2 : "+removeDuplicateAppearsOnceOpp2(mat[i]));
            replaceOtherElementWithMinus1(mat[i],uniqueElementCount);
            System.out.println("modified array : "+Arrays.toString(mat[i]));
        }

    }

    public static int removeDuplicateAppearsOnce(int [] arr){
        int uniqueCount=1;
        for(int i=1;i<arr.length;i++){
            if(arr[uniqueCount-1] == arr[i]){
                continue;
            }else{
                arr[uniqueCount] = arr[i];
                uniqueCount++;
            }
        }
        return uniqueCount;
    }


    /*
    * 2 pointer approach
    * */
    public int removeDuplicatesOpp3(int[] arr) {
        int n = arr.length;
        if(n<=1){
            return n;
        }
        int s=1,f=1;
        while(f<n){
            if(arr[f] != arr[s-1]){
                arr[s++] = arr[f];
            }
            f++;
        }
        return s;
    }

    public static int removeDuplicateAppearsOnceOpp2(int [] arr){
        int uniqueCount=1;
        for(int i=1;i<arr.length;i++){
            if(arr[uniqueCount-1] != arr[i]){
                arr[uniqueCount] = arr[i];
                uniqueCount++;
            }
        }
        return uniqueCount;
    }

    public static void replaceOtherElementWithMinus1(int [] arr,int uniqueCount){
        // at last add -1
        while (uniqueCount<arr.length){
            arr[uniqueCount] = -1;
            uniqueCount++;
        }
    }
}
