package leetcode.topinterviewquestion150.arraysString;

import java.util.Arrays;

import static leetcode.topinterviewquestion150.arraysString.RemoveDuplicateInSorted_26.replaceOtherElementWithMinus1;

public class RemoveDuplicateInSortedArr_80 {

    public static void main(String[] args) {

        int [][] mat = {{1,1,2},
                {0,0,1,1,1,2,2,3,3,4},
                {1,1,1,2,2,3}};

        for(int i=0;i<mat.length;i++){
            System.out.println("input : "+ Arrays.toString(mat[i]));
            int uniqueElementCount = removeDuplicates(mat[i]);
            System.out.println("uniqueElementCount : "+uniqueElementCount);
            replaceOtherElementWithMinus1(mat[i],uniqueElementCount);
            System.out.println("modified array : "+Arrays.toString(mat[i]));
        }

    }


    /*
    *
    * https://www.youtube.com/watch?v=Zh0Lzs-ObQI
    *
    * problem 26
    * f = s =1
    * */
    public static int removeDuplicates(int[] arr) {
        int n = arr.length;
        if(n<3){
            return n;
        }
        int s=2,f=2;
        while(f<n){
            if(arr[f] != arr[s-2]){
                arr[s++] = arr[f];
            }
            f++;
        }
        return s;
    }
}
