package leetcode.patternwise;


import java.util.Arrays;

/*
* https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
* https://leetcode.com/problems/single-number-iii/description/
* */
public class TwoRepeatingElement {

    public static void main(String[] args) {

        int [][] arr = {{1,2,1,3,2,5},
                {0,1},
                {2, 3, 7, 9, 11, 2, 3, 11}};
        int [] result;
        for (int i=0;i<arr.length;i++){
            result = twoNonRepeatingElement(arr[i]);
            System.out.println("result : "+ Arrays.toString(result));
        }
    }

    public static int [] twoNonRepeatingElement(int [] arr){
        int xorAllElement = 0;
        int [] result = new int[2];
        for(int val : arr){
            xorAllElement ^= val;
        }
        ///rigjt most set bit (num AND with 2's compliment
        int  rightMostSetBit = (xorAllElement & -xorAllElement);
        for (int val : arr){
            //get left side set number
            if((rightMostSetBit & val) > 0){
                result[0] ^= val;
            }else{
                //get second element
                result[1] ^= val;
            }
        }
        return result;
    }
}
