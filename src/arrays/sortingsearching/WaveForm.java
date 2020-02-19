package arrays.sortingsearching;

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
    * */
    public static void sortInWaveFormOpt(int [] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        int i = 0;

    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,0};
        sortInWaveForm(arr);
        System.out.println(Arrays.toString(arr));
    }
}
