package arrays.sortingsearching.heapsort;

import java.util.Arrays;

public class HeapSort {

    public static void heapiFy(int [] arr, int i, int n){
        int left = 2*i+1; // 2*i+(1-i)
        int right = 2*i+2; // 2*i+(2-i) i=0,1,2 ..
        int max = i;
        if(left < n && arr[left]<arr[i]/*arr[max]<arr[left]*/){ // n inclusive
            max = left;
        }
        if(right < n && arr[right]<arr[max] /*arr[max]<arr[right]*/){
            max = right;
        }
        if(max != i){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapiFy(arr,max,n);
        }
        return;
    }

    public static void heapSort(int [] arr,int initial,int n){

        buildHeap(arr,initial,n);
        //heap sort // delete dat
        for(int i=n-1;i>=initial; i--){
            deletion(arr,initial,i);
        }
    }

    public static void deletion(int [] arr,int initial,int i){
        int temp = arr[i];
        arr[i] = arr[initial];
        arr[initial] = temp;
        heapiFy(arr,initial,i);
    }

    public static void buildHeap(int [] arr,int initial,int n){
        //build max heap
        for(int i = n/2-1;i>=initial;i--){ // start with n/2 second last level go to down up to end
            heapiFy(arr,i,n);
        }
    }

    public static void main(String[] args) {
        int [][] mat = {
                     {99, 49, 57, 106, 29, 88, 15, 5, 190, 88, 86, 179, 17, 7, 15,29,69,1} // so use n/2-1 instead of n/2
                    ,{12, 11, 13, 5, 6, 7}
                      };
        int initial = 0;
        for (int i=0;i<mat.length;i++) {
            heapSort(mat[i], initial, mat[i].length);
            System.out.println(Arrays.toString(mat[i]));
        }
    }
}
