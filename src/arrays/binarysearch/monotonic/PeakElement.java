package arrays.binarysearch.monotonic;

public class PeakElement {

    public static void main(String[] args) {

        int[][] mat = {{10, 20, 15, 2, 23, 90, 80},
        };
        for(int [] arr : mat) {
            System.out.println("using brute force index :"+findPeakElement(arr));
            System.out.println("using binary search index : "+findPeakElementBS(arr));
        }
    }

    public static int findPeakElement(int [] arr){
        int n = arr.length;
        boolean left = true;
        boolean right = true;

        for(int i=0;i<n;i++){
            left = true;
            right = true;

            if(i > 0 && arr[i-1] >= arr[i]){
                left = false;
            }
            if(i < n-1 && arr[i] <= arr[i+1]){
                right = false;
            }
            if(left && right){
                return i;
            }
        }
        return 0;
    }

    public static int findPeakElementBS(int[] arr) {
        int n = arr.length;
        if(n == 1){
            return 0;
        }
        if(arr[0] > arr[1]){// first element is peak
            return 0;
        }
        if(arr[n-2] < arr[n-1]){ // last element
            return n-1;
        }
        int l=1,h = n-2;
        int m;
        while(l <= h){
            m = l + (h-l)/2;
            if(arr[m-1] < arr[m] && arr[m] > arr[m+1]){
                return m;
            }else if(arr[m] < arr[m+1]){ // so we can find lower at right hand side
                l = m+1;
            }else {
                h = m-1;
            }
        }
        return 0;

    }
}
