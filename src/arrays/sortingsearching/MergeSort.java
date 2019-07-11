package arrays.sortingsearching;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int [] arr,int l,int h){
        if(l<h){
            int m = l+(h-l)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,h);
            merge(arr,l,m,h);
            //return;
        }
    }
    public static void merge(int [] arr,int l,int m,int h){
        int [] leftArr = new int[m-l+1];
        int[] rightArr = new int[h-m];
        int l1 = 0;
        int i;
        int j;
        int n1 = leftArr.length;
        int n2 = rightArr.length;
        for(i=0;i<n1;i++){
            leftArr[i] = arr[l+i];
        }
        for(j=0;j<n2;j++){
            rightArr[j] = arr[j+m+1];
        }

        i=j=0;
        int k = l;
        while(i<n1 && j<n2){
            if(leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i<n1){
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j<n2){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6, 7};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
