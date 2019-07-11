package stack;

import java.util.Stack;

public class StackMin {

    private static int minVal = Integer.MAX_VALUE;
    private static  Stack<Integer> stack = new Stack<>();

    public static void push(int val){
        if(stack.isEmpty()){
            minVal = val;
            stack.push(val);
            return;
        }
        if(val < minVal ){
            stack.push(2*val - minVal);
            minVal = val;
            return;
        }
        stack.push(val);
    }

    public static int pop(){
        if(stack.isEmpty()){
            System.out.println("stack is emplty ");
            return -1;
        }
        int val = stack.pop();
        if(val < minVal){
            minVal = 2*minVal - val;
        }
        return minVal;
    }

    public static int getMinVal(){
        if(stack.isEmpty()){
            System.out.println("stack is empty ");
            return -1;
        }
        return minVal;
    }

    public static void main(String[] args) {
        push(5);
        push(9);
        push(3);
        push(2);
        System.out.println(getMinVal());
        push(7);
        push(1);
        System.out.println(getMinVal());
        pop();
        pop();
        pop();
        System.out.println(getMinVal());



    }
}
