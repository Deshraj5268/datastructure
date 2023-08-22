package arrays.binarysearch;

public class BSOnReverseArray {

    public static void main(String[] args) {
        int [] reverseArr = {20,17,15,14,13,12,10,9,8,4};
        int len = reverseArr.length;
        int target = 9;
        boolean result  = binarySearchOnReverseArray(reverseArr,0,len,target);
        System.out.println("result : "+result);
    }

    public static boolean binarySearchOnReverseArray(int [] arr ,int l,int h,int target){
        if(arr == null || arr.length == 0){
            return false;
        }
        if(h-l == 1 && arr[l] == target){
            return true;
        }
        if(arr[l] < arr[h-1]){ // elements are in ascending order
            return false;
        }
        //boundary condition
        if(target > arr[0] || target < arr[h-1]){
            return false;
        }
        int mid;
        while (l<h){
            mid = l+(h-l)/2;
            if(mid == arr[mid]){
                return true;
            }else if(target < arr[mid]){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return false;
    }
}
