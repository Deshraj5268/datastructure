package arrays;

public class Utility {

    private Utility() {

    }

    public static void swap(int[] arr, int l, int m) {
        if(l!=m) {
            int temp = arr[l];
            arr[l] = arr[m];
            arr[m] = temp;
        }
    }

    public static void swap(char[] charArr, int l, int m) {
        char temp = charArr[l];
        charArr[l] = charArr[m];
        charArr[m] = temp;
    }

    public static boolean isArrayEmpty(int [] arr){
        return (arr == null || arr.length == 0);
    }
}
