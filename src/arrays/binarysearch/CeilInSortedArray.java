package arrays.binarysearch;

public class CeilInSortedArray {

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
        //exact match case [4,6] num 4
       if(arr[l] == data){
            return l;
       }
        return r;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 8, 10, 12, 19};
        int ceil = 11;
        int index = binarySearch(arr,0,arr.length-1,ceil);
        if(index != -1) {
            System.out.println("value for "+ceil + " ceil is present at index : " + index + " and value is "+arr[index]);
        }else{
            System.out.println("ceil  is not present in array for "+ceil);
        }
    }
}
