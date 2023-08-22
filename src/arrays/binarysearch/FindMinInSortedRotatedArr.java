package arrays.binarysearch;

public class FindMinInSortedRotatedArr {
    public static void main(String[] args) {

        int [][] nums = {{31,32,41,5,6,7,8,9,10}};
        for(int [] arr:nums) {
            int min = findMinInSortedRotatedArr(arr);
           // int max = findMaxInSortedRotatedArr(arr);
            System.out.println(min);
           // System.out.println(max);
        }

    }


    /*
    * https://www.youtube.com/watch?v=nIVW4P8b1VA
    *
    * if arr[l] <= arr[r] then array is sorted then return arr[l]
    *  m = (l+h)/2
    * if(arr[l]<= arr[m]) then l = m+1 .. move to right
    * else h = m
    * */
    public int findMin(int[] arr) {
        if(arr == null || arr.length ==0){
            return -1;
        }
        int len = arr.length;
        int l=0,h=len-1,m;
        while(l<=h){
            if(arr[l] <= arr[h]){
                return arr[l];
            }
            m=l+(h-l)/2;
            if(arr[l] <= arr[m]){//left sorted
                l = m+1;
            }else{
                h = m;
            }
        }
        return 0;
    }

    /*
    * array was in sorted increasing and elements are unique** then rotate towards right
    *
    * arr[mid-1] > arr[mid] < arr[mid+1]
    *
    * last = arr[high]
    * until low<high
    * if( arr[mid]> last) then  l = mid+1
    * else high = m;
    *
    * */
    public static int findMinInSortedRotatedArr(int [] arr){
        int l = 0;
        int h = arr.length-1;
        int m;
        int last = arr[h];
        if(arr[l] <= arr[h]) {
            return arr[l];
        }
        while(l<h){
            m = l+(h-l)/2;
            if(arr[m]>last){
                l = m+1;
            }else{
                h = m;
            }
        }
        return arr[l];

    }

    public int findMinInDuplicateArr(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        int m;
        //  int last = nums[h];
        while(l<h){
            m = l+(h-l)/2;
            if(nums[m] == nums[h]){
                h--;
            }else if(nums[m]>nums[h]){
                l = m+1;
            }else{
                h = m;
            }
        }
        return nums[h];

    }

  /*  public static int findMaxInSortedRotatedArr(int [] arr){
        int l = 0;
        int h = arr.length-1;
        int m;
        int first = arr[l];
        while(l<h){
            m = l+(h-l)/2;
            if(first <arr[m]){
                l = m;
            }else{
                h = m-1;
            }
        }
        return arr[h];

    }*/
}