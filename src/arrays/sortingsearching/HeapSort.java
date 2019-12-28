package arrays.sortingsearching;

import java.util.Arrays;

public class HeapSort {

    public static void heapify(int [] arr,int i,int n){
        int left = 2*i+1;
        int right = 2*i+2;
        int max = i;
        if(left < n && arr[max]<arr[left]){
            max = left;
        }
        if(right < n && arr[max]<arr[right]){
            max = right;
        }
        if(max != i){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr,max,n);
        }
        return;
    }

    public static void heapSort(int [] arr,int initial,int n){
        //build max heap
        for(int i = n/2-1;i>=initial;i--){
            heapify(arr,i,n);
        }
        //heap sort
        for(int i=n;i>=0; i--){
            int temp = arr[i];
            arr[i] = arr[initial];
            arr[initial] = temp;
            heapify(arr,initial,i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int initial = 0;
        heapSort(arr,initial,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
