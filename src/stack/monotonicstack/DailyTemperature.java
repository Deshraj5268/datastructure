package stack.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/description/
public class DailyTemperature {


    public static void main(String[] args) {

        int [][] mat = {{73,74,75,71,69,72,76,73},
                {30,40,50,60},
                {30,60,90}};

        // output
        /*[1,1,4,2,1,1,0,0]
        [1,1,1,0]
        [1,1,0]
        * */
        for(int [] arr :mat){
            System.out.println("original array "+ Arrays.toString(arr));
            int [] result = dailyTemperatures(arr);
            System.out.println("using stack "+Arrays.toString(result));
        }
    }
    public static int[] dailyTemperatures(int[] arr) {
        if(arr == null){
            return arr;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int [] result = new int[arr.length];
        for(int i = 1;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                result[stack.peek()] = (i-stack.peek());
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            result[stack.pop()] = 0;
        }
        return result;
    }
}
