package stack;

import arrays.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
* another similar problem
* */
public class NextGreaterElement {

    public static void main(String[] args) {

        int [][] mat = {{2, 7, 3, 5, 4, 6, 8}};
        for(int [] arr :mat){
            System.out.println("original array "+ Arrays.toString(arr));
            int [] result = nextGreaterElement(arr);
            System.out.println(" brute force "+Arrays.toString(result));
            result = nextGreaterElementUsingStack(arr);
            System.out.println("using stack "+Arrays.toString(result));

        }
    }

    public static int [] nextGreaterElement(int [] arr){
        if(Utility.isArrayEmpty(arr)){
            return new int[0];
        }
        int n = arr.length;
        int [] result = new int[n];

        for(int i=0;i<n;i++){
            result[i] = -1;
            for(int j=i+1;j<n;j++){
                if(arr[i] < arr[j]){
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }

    /*
    * iterate array
    *
    *   until top indexed element is less than current element
    *   then set 'next greater' current element  in result array
    *
    *   push current index in stack
    * */
    public static int [] nextGreaterElementUsingStack(int [] arr){
        if(Utility.isArrayEmpty(arr)){
            return new int[0];
        }
        int n = arr.length;
        int [] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
        return result;
    }
}
