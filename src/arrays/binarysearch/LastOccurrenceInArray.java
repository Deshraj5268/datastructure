package arrays.binarysearch;

import arrays.Utility;


/*
* https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
* */
public class LastOccurrenceInArray {

    public int lastFirstOccurrenceOfElement(int[] arr, int low, int high, int target){
        if(Utility.isArrayEmpty(arr)){
            return -1;
        }
        //base condition
        if(arr.length == 1 && arr[0] == target){
            return 0;
        }
        int l = low;
        int h = high;
        int m;
        if(target < arr[l] || target > arr[h]){
            return -1;
        }
        while (l<=h){
            m = l+(h-l)/2;
            if((h == m && arr[m] == target) || (arr[m] == target && arr[m] < arr[m+1])){
                return m;
            }else if(target >= arr[m]){
                l = m+1;
            }else {
                h = m-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int [][] matrix = {{2,2,2,2,2,2,2},
                {1,3,4,5,6,9,10},
                {1,3,4,5,6,9,10},
                {1,3,4,5,5,5,6,6,6,6,7},
                {1,3,4,5,5,5,5,6,6,6,6,7},
                {1,3,4,5,5,5,5,6,6,6,6,7},
                {-5,-4,-4,-4,4,6,8,9}
        };
        int [] targets = {2,6,2,5,6,7,-4};
        int [] expectedArr = {6,4,-1,5,10,11,3};
        int [] result = new int[targets.length];
        LastOccurrenceInArray lastOccurrenceInArray = new LastOccurrenceInArray();
        for(int i=0;i<result.length;i++){
            result[i] = lastOccurrenceInArray.lastFirstOccurrenceOfElement(matrix[i],0,matrix[i].length-1,targets[i]);
        }
        for(int i=0;i<result.length;i++){
            if(result[i] != expectedArr[i]){
                System.out.println(result[i]+ " "+expectedArr[i]);
            }else {
                System.out.println("result->"+result[i] +":"+expectedArr[i]+" is as expected for index matrix "+ i);
            }
        }
    }
}
