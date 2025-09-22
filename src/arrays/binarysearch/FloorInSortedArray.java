package arrays.binarysearch;

import java.util.Scanner;

public class FloorInSortedArray {

    public static int binarySearch(int [] arr,int l,int r,int data){
        int m;
        if(data < arr[l]){
            return -1;
        }
        if(data >= arr[r]){
            return r;
        }
        while ((r-l)>1){
            m = l + (r-l)/2;
            if(arr[m] <= data){
                l = m;
            }else{
                r = m;
            }
        }
       /*if(arr[l] <= data){
            return l;
       }*/
       return l;
    }

    public static int floorValueUsingStandardBinarySearch(int [] arr,int l, int r, int floor){ // r is inclusive
        // base condition
        if(arr[l] > floor){ // 1 2 3 4 , ceil = 0
            return -1;
        }
        int m;
        int result = -1;
        while (l <= r){
            m = l+ (r-l)/2;
            if(arr[m] == floor){
                return m; // exact match
            }else if(arr[m] < floor){
                result = m; // //  potential floor
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,8,10,11,12,19};
        int floor = 5;
        int index = binarySearch(arr,0,arr.length-1,floor);
        if(index != -1) {
            System.out.println("value for "+floor  + " floor is present at index : " + index);
        }else{
            System.out.println("floor  is not present in array for "+floor);
        }

        index = floorValueUsingStandardBinarySearch(arr, 0, arr.length-1, floor);
        System.out.println("value for "+floor + " floor is present at index : " + index + " and value is "+arr[index]);
     /*  Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       while (t-->0){
           int n = sc.nextInt();
           int data = sc.nextInt();
           int [] arr = new int[n];
           for(int i=0;i<n;i++){
               arr[i] = sc.nextInt();
           }
           int result = binarySearch(arr,0,arr.length-1,data);
           System.out.println(result);
       }*/
    }
}
