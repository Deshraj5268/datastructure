package arrays.sortingsearching;


import arrays.Utility;

import java.util.Arrays;

/*
* it can be done when element within the range
*
* https://www.geeksforgeeks.org/cycle-sort/
* */
public class CyclicSort {


    public static void main(String[] args) {
        int [] arr = {2,6,4,3,1,5};
        CyclicSort cyclicSort = new CyclicSort();
        System.out.println(" before sort : "+Arrays.toString(arr));
        cyclicSort.cyclicSort(arr,arr.length);
        System.out.println(" After sort : "+Arrays.toString(arr));
    }


    /*
    *
    * this works only on unique elements and these are with in the range[1..n]
    * */
    public void cyclicSort(int [] arr,int n){

        for(int i=1;i<=n;i++){
            while(arr[i-1] != i){
                Utility.swap(arr,arr[i-1]-1,i-1);
            }
        }
    }

}