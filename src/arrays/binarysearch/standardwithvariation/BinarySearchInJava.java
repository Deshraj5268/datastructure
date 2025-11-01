package arrays.binarysearch.standardwithvariation;

import java.util.Arrays;

public class BinarySearchInJava {

    public static void main(String[] args) {

        int [] arr = {4,8,9,10,11,12,13,14,15,17,20};
        int [] reverseArr = {20,17,15,14,13,12,10,9,8,4};
        int len = arr.length;
        int target = 9;
       // int result = Arrays.binarySearch(reverseArr,target); bs not work on decreasing order
        int result = Arrays.binarySearch(reverseArr,target);
        System.out.println("result "+result);
    }
}
