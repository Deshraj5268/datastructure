package arrays.sortingsearching.mergesortapps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
* arrays are sorted
*
* https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
* */
public class IntersectionTwoArray {

    public static void main(String[] args) {
        int [][] mat1 = {{1, 2, 3, 4, 5}, {2, 4, 5, 8, 10}};
        int [][] mat2 ={{3, 5, 7, 9, 11},{1, 3, 5, 7, 9}};

        for(int i=0;i<mat1.length;i++){
            System.out.println("arr1 : "+ Arrays.toString(mat1[i]));
            System.out.println("arr2 : "+Arrays.toString(mat2[i]));
            int [] result = intersectionOfTwoArray(mat1[i],mat2[i]);
            System.out.println("result : "+Arrays.toString(result));
        }
    }

    /*
    * merge sort way
    * */
    public static int [] intersectionOfTwoArray(int [] arr1, int [] arr2){
        int i=0,j=0;
        int l1=arr1.length,l2=arr2.length;
        List<Integer> result = new ArrayList<>();
        while (i<l1 && j<l2){
            if(arr1[i] == arr2[j]){
                result.add(arr1[i]);
                i++;
                j++;
            }else if(arr1[i] < arr2[j]){
                i++;
            }else {
                j++;
            }
        }
       return result.stream().mapToInt(x -> x).toArray();
    }
}
