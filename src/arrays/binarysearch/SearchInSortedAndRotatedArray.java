package arrays.binarysearch;

public class SearchInSortedAndRotatedArray {

    public static void main(String[] args) {
        int [] arr = {30, 40, 50, 10, 20};
        int target=20;
        int targetIndex = findIndexInSortedRotatedArray(arr,0,arr.length-1,target);
        if(targetIndex!= -1){
            System.out.println("targetIndex ="+targetIndex);
        }else {
            System.out.println("element not present in array ");
        }

        System.out.println("iterative approach ");
        targetIndex = findIndexInSortedRotatedArrayItr(arr,0,arr.length-1,target);
        if(targetIndex!= -1){
            System.out.println("targetIndex ="+targetIndex);
        }else {
            System.out.println("element not present in array ");
        }

    }

    private static int findIndexInSortedRotatedArray(int [] arr,int low,int high,int target){
        if(low>high){
            return -1;
        }
        int mid = low+(high-low)/2;
        //in case of duplicate
        /*if(arr[mid] == arr[low] && arr[mid] == arr[high]){
            low++;
            high--;
            return findIndexInSortedRotatedArray(arr,low,high,target);
            //if all duplicate worst case s O(N) -- linear search
        }*/
        if(arr[mid] == target){
            return mid;
        }else if(arr[low] <= arr[mid]){  //first half sorted
            if(target >= arr[low]  && target <= arr[mid]){
                return findIndexInSortedRotatedArray(arr,low,mid,target);
            }else {
                return findIndexInSortedRotatedArray(arr,mid+1,high,target);
            }
        }else {// second half sorted
            if(target >= arr[mid] && target<= arr[high]){
                return findIndexInSortedRotatedArray(arr,mid,high,target);
            }else {
                return findIndexInSortedRotatedArray(arr,low,mid-1,target);
            }
        }
    }

    private static int findIndexInSortedRotatedArrayItr(int [] arr,int low,int high,int target){
        int mid;
        while (low <= high){
            mid = low + (high - low)/2;
            if (arr[mid] == target){
                return mid;
            }else if(arr[low] <= arr[mid]){ // first half sorted

                if(target >= arr[low] && target <= arr[mid]){
                    high = mid;
                }else {
                    low = mid+1;
                }
            }else { // second half sorted
                if(target >= arr[mid] && target <= arr[high]){
                    low = mid;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
