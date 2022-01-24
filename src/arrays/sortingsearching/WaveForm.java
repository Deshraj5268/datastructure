package arrays.sortingsearching;

import arrays.Utility;

import java.util.Arrays;

import static arrays.Utility.swap;

public class WaveForm {

    public static void sortInWaveForm(int [] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        Arrays.sort(arr);
        int i = 0;
        while(i<arr.length){
            if(i+2 > arr.length){
                break;
            }
            swap(arr,i,i+1);
            i = i+2;
        }
    }

    /*
    * even positioned index element
    * if x is less than previous odd then swap current and previous
    * if x is greater than next odd then swap cuurent and next odd number
    * O(n)
    * */
    public static void sortInWaveFormOpt(int [] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        int n = arr.length;
        for(int i=0;i<n;i+=2){Utility.swap(arr,i-1,i);
            if(i>0 && arr[i-1] > arr[i]){

            }
            if(i<n-1 && arr[i] < arr[i+1]){
                Utility.swap(arr,i,i+1);
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,0};
        sortInWaveForm(arr);
        System.out.println(Arrays.toString(arr));
        int [] arr1 = {6907,7808,8551,8683,9205,9980};
        sortInWaveFormOpt(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
