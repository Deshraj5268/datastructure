package arrays.binarysearch;

public class BinarySearch {

    //return index otherwise -1
    public static int modifiedBinarySearch(int [] arr, int l, int r, int data){
        int m;
        //corner case
        if(arr[l] > data || arr[r] < data){
            return -1;
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
        }else if(arr[r] == data){
            return r;
        }else{
            return -1;//data not found
        }

    }

    public static int binarySearch(int [] arr,int l,int h,int target){ // l,h is inclusive
        if(target < arr[l] || arr[h] < target){
            return -1;
        }
        int m;
        while(l<=h){
            m = l+(h-l)/2; // mid to avoid overflow
            if(target == arr[m]){
                return m;
            }else if(target < arr[m]){
                h = m-1;
            }else{
                l = m+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {4,6};
        int data = 4;
        int index = modifiedBinarySearch(arr,0,arr.length-1,data);
        int index2= binarySearch(arr,0,arr.length-1,data);
        System.out.println(index2);
        if(index != -1) {
            System.out.println(data + " is present at index : " + index);
        }else{
            System.out.println(data+" is not present in array");
        }

    }
}
