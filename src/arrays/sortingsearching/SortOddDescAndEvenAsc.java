package arrays.sortingsearching;


import arrays.Utility;

import java.util.Arrays;

public class SortOddDescAndEvenAsc {


    private static boolean isEven(int x){
        return (x%2 == 0);
    }
    public static int arrangeOddFollowedByEven(int [] arr,int n){
        int l=0;
        int r = n-1;
        while (l<=r){
            if(isEven(arr[l])){
                Utility.swap(arr,l,r);
                r--;
            }else{
                l++;
            }
        }
        return l;
    }

    private static void arrangeOddDescAndEvenAsc(int [] arr,int n){
        int oddLastIndex = arrangeOddFollowedByEven(arr,n);
        Arrays.sort(arr,0,oddLastIndex);
        reverseArr(arr,0,oddLastIndex-1);
        if(oddLastIndex < n) {
            Arrays.sort(arr, oddLastIndex + 1, n);
        }
    }

    private static void reverseArr(int[] arr, int i, int oddLastIndex) {
        while (i<oddLastIndex){
            Utility.swap(arr,i,oddLastIndex);
            i++;
            oddLastIndex--;
        }
    }

    /* negate all odd number then sort*/
    private static void arrangeOddDescAndEvenAsc1(int [] arr,int n){
        flipNegativeSignOfAllOddNumbers(arr,n);
        Arrays.sort(arr);
        flipNegativeSignOfAllOddNumbers(arr,n);
    }

    /*
    * works if ,all numbers are positive
    * */
    private static void flipNegativeSignOfAllOddNumbers(int[] arr, int n) {
        for(int i=0;i<n;i++){
            if(!isEven(arr[i])){
                arr[i] =  -arr[i];
            }
        }
    }
    private static void arrangeOddDescAndEvenAsc2(Integer [] arr){
        Arrays.sort(arr,(o1,o2)->{
            boolean x = isEven(o1);
            boolean y = isEven(o2);
            if(x && y){
                return (o1>o2 ? 1:-1);
            }else if(!x && !y) {
                return (o1>o2 ? -1:1);
            }else{
                return x ? 1:-1;
            }
        });
    }

    public static void main(String[] args) {

        int [] arr = {1, 2, 3, 5, 4, 7, 10};
       // arrangeOddDescAndEvenAsc(arr,arr.length);
      //  arrangeOddDescAndEvenAsc1(arr,arr.length);

        Integer[] objArr = Arrays.stream( arr ).boxed().toArray( Integer[]::new );
        arrangeOddDescAndEvenAsc2(objArr);
        System.out.println(Arrays.toString(objArr));

    }
}
