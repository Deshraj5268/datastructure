package arrays.binarysearch;

public class CeilInsortedArray {

    public static int binarySearch(int [] arr,int l,int r,int data){
        int m;
        if(data > arr[r]){
            return -1;
        }
        if(data <= arr[l]){
            return l;
        }
        while ((r-l)>1){
            m = l + (r-l)/2;
            if(arr[m] <= data){
                l = m;
            }else{
                r = m;
            }
        }
       if(arr[l] == data){
            return l;
       }
        return r;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 8, 10, 12, 19};
        int floor = 11;
        int index = binarySearch(arr,0,arr.length-1,floor);
        if(index != -1) {
            System.out.println("value for "+floor + " floor is present at index : " + index);
        }else{
            System.out.println("floor  is not present in array for "+floor);
        }
    }
}
