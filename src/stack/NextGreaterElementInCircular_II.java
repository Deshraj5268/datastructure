package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementInCircular_II {

    public static void main(String[] args) {
        int [][] mat = {{4,1,2},
                {1,2,3,4,3},
                {4,3,2,1}};
        for(int i=0;i<mat.length;i++){
            System.out.println("original arrays "+ Arrays.toString(mat[i]));
            int [] result = nextGreaterElementII(mat[i]);
            System.out.println("using stack "+Arrays.toString(result));
        }
    }

    public static int[] nextGreaterElementII(int[] nums) {
        int [] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        Integer value;
        int n = nums.length;
        int i = 0;
        int idx = 0;
        for(;idx<2*n;idx++){
            i = idx%n;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                map.put(stack.pop(),nums[i]);
            }
            value = map.get(i);
            if(value !=null){
                continue;
            }
            stack.push(i);
        }
        i = 0;
        for(;i<n;i++){
            value = map.get(i);
            result[i] =  value == null ? -1:value;
        }
        return result;
    }
}

