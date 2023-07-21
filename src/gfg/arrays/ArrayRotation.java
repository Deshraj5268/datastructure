package gfg.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {

    //start nad end are inclusive
    public static void reversArray(int [] arr,int start,int end){
        if(arr == null || arr.length == 0){
            return;
        }
        int temp;
        while(start<end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void arrayRotationByD(int [] arr,int d,int n){
        reversArray(arr,0,d-1);
        reversArray(arr,d,n-1);
        reversArray(arr,0,n-1);
    }

    public static void arrayRotationByDUsingDoubleArr(int [] arr,int d,int n){
        if(arr == null || arr.length == 0){
            return;
        }
        int l = arr.length;
        int [] processingArr = new int[2*l];
        for(int i=0;i<2*l;i++){
            processingArr[i] = arr[i%l];
        }
        int k=0;
        for(int i=d;i<d+l;i++){
            arr[k++] = processingArr[i];
        }
    }


    public static void main(String[] args) {
       /* Scanner kb = new Scanner(System.in);
        int t=kb.nextInt();
        while(t-->0) {
            int n = kb.nextInt();
            int d = kb.nextInt();
            int [] arr = new int[n];
            for(int i = 0;i<n;i++) {
                arr[i] = kb.nextInt();
            }
            arrayRotationByD(arr,d,arr.length);
            for(int i:arr){
                System.out.print(i+" ");
            }
        }*/

        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;
        d = d%arr.length;
        System.out.println("before " +Arrays.toString(arr) +"d :"+d);
        arrayRotationByD(arr,d,arr.length);
        System.out.println("after "+Arrays.toString(arr));

        int [] arr1 = {1, 2, 3, 4, 5};
        System.out.println("before " +Arrays.toString(arr1));
        arrayRotationByDUsingDoubleArr(arr1,d,arr1.length);
        System.out.println("using doubling array  after "+Arrays.toString(arr1));

    }
}
