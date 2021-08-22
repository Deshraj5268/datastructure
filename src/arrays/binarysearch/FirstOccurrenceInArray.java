package arrays.binarysearch;

import arrays.Utility;

public class FirstOccurrenceInArray {

    public int findFirstOccurrenceOfElement(int[] arr, int low, int high, int target){
        if(Utility.isArrayEmpty(arr)){
            return -1;
        }
        int l = low;
        int h = high;
        int m = low;
        while (l<=h){
            m = l+(h-l)/2;
            if((l == m && arr[m] == target) || (arr[m] == target && arr[m-1] < arr[m])){
                return m;
            }else if(target <= arr[m]){
                h = m-1;
            }else {
                l = m+1;
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
                {-5,-4,-4,-4,4,6,8,9},
                {1, 3, 5, 5, 5, 5, 67, 123, 125}
        };
        int [] targets = {2,6,2,5,6,7,-4,5};
        int [] expectedArr = {0,4,-1,3,7,11,1,2};
        int [] result = new int[targets.length];
        FirstOccurrenceInArray firstOccurrenceInArray = new FirstOccurrenceInArray();
        for(int i=0;i<result.length;i++){
            result[i] = firstOccurrenceInArray.findFirstOccurrenceOfElement(matrix[i],0,matrix[i].length-1,targets[i]);
        }
        for(int i=0;i<result.length;i++){
            if(result[i] != expectedArr[i]){
                System.out.println(result[i]+ " "+expectedArr[i]);
            }else {
                System.out.println("result is as expected for index matrix "+ i);
            }
        }

    }
}
