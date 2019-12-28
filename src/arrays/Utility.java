package arrays;

public class Utility {

    private Utility(){

    }

    public static void swap(int [] arr,int l,int m){
        int temp = arr[l];
        arr[l] = arr[m];
        arr[m] = temp;
    }

    public static boolean isEmptyArr(int [] arr){
        return (arr == null || arr.length == 0);
    }
}
