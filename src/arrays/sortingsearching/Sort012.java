package arrays.sortingsearching;

import java.util.Arrays;

import static arrays.Utility.swap;

public class Sort012 {



    public static void sort012(int [] arr,int l,int r){
        int low=l;
        int mid = l;
        int high=r;
        while (mid<=high){
            switch (arr[mid]){
                case 0:
                    swap(arr,mid,low);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                default: //for 2
                    swap(arr,mid,high);
                    high--;
            }
        }
    }

    public static void main(String[] args) {

        int [] arr = {0,1,2,0,0,0,0,0,1,1,1,2,2,1,1,2,0,1,1,0,2};
        sort012(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
