package arrays.sortingsearching;

import java.util.Arrays;

public class CountSort {

    public static void countSort(int [] arr,int n,int k){ // k is max value of input range element
       int [] countArr = new int[k];
       int [] outputArr = new int[n];
        for(int i=0;i<n;i++){
            countArr[arr[i]]++;
        }

        for(int i=1;i<k;i++){
            countArr[i] += countArr[i-1];
        }

        for(int i=0;i<n;i++){
            outputArr[countArr[arr[i]]-1] = arr[i];
            countArr[arr[i]]--;
        }

        for(int i=0;i<n;i++){
            arr[i] = outputArr[i];
        }
    }

    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5,6,7,7,6,5,5,4};
        int k = 8;//max
        countSort(arr,arr.length,k);
        System.out.println(Arrays.toString(arr));
    }
}
