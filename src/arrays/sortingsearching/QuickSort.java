package arrays.sortingsearching;

import java.util.Scanner;

import static arrays.Utility.swap;

public class QuickSort {

    //last element as pivot lomuto partition scheem
    public static int pivot(int [] arr,int p,int q){
        int pv = arr[q];//last element as pivot
        int i = q;
        for(int j = q-1;j>=p;j--){
            if(pv <= arr[j]){
                i--;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i];
        arr[i] = arr[q];
        arr[q] = temp;
        return i;
    }

    public static int hoaresPartition(int [] arr,int p,int q){
        int left = p;
        int right = q;
        int pivot = arr[p];//first element as pivot

        while (left<=right){
            while (left<=right && arr[left]<=pivot){
                left++;
            }
            while (left<=right && arr[right] > pivot){
                right--;
            }
            if(left<=right){
                swap(arr,left,right);
            }
        }
        swap(arr,p,right);
        return right;
    }

    public static void quickSort(int [] arr,int s,int e){
        if(s<=e){
            int m = hoaresPartition(arr,s,e);
            quickSort(arr,s,m-1);
            quickSort(arr,m+1,e);
        }
    }

    public static void main(String[] args) {
        int [] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length-1;
        quickSort(arr,0,n);
        for(int i = 0;i<=n;i++){
            System.out.print(arr[i]+" ");
        }
        /*Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int [] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            quickSort(arr,0,n-1);
            for(int i = 0;i<n;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            t--;
        }*/


    }
}
