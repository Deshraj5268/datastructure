package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_I {

    /*
    * https://leetcode.com/problems/next-greater-element-i/
    *
    * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
        Output: [-1,3,-1]
     */
    public static void main(String[] args) {
        int [][] mat = {{4,1,2, 5}};
        int [][] mat2 = {{1,3,4,2}};
        for(int i=0;i<mat.length;i++){
            System.out.println("original arrays "+ Arrays.toString(mat[i]) +" "+Arrays.toString(mat2[i]));
            int [] result = nextGreaterElement(mat[i],mat2[i]);
            System.out.println("output using stack "+Arrays.toString(result));
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map =  getNextGreaterElementOfNum2(nums2);
        int [] result = new int[nums1.length];
        for(int i=0; i<nums1.length;i++){
            result[i] = map.getOrDefault(nums1[i], -1); // map val is not present then -1
        }

        return result;

    }

    public static Map<Integer,Integer> getNextGreaterElementOfNum2(int [] arr){
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<arr.length;i++){
            while(!stack.isEmpty() && stack.peek() < arr[i]){
                map.put(stack.pop(),arr[i]);
            }
            stack.push(arr[i]);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        return map;
    }
}

