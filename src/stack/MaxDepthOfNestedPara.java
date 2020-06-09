package stack;

import java.util.Deque;
import java.util.LinkedList;

public class MaxDepthOfNestedPara {

    public static void main(String[] args) {
        String strExpr =    "( ((X)) (((Y))) )";
        int depth = maxDepthOfNestedParaUsingStack(strExpr);
        System.out.println(depth);
        System.out.println(maxDepthOfNestedPara(strExpr));
    }

    /*
    *  Traverse str
    *   if element is '(' || ')'
    *     if element = '("
    *       push element
    *       count++;
    *       maxCount = Max(current,MaxCount);
    *     else if stack empty or paraNotMatch // for balancing
    *        return false;
    *     else
    *       count--;
    *
    *   return maxCount
    *
    * */
    public static int maxDepthOfNestedParaUsingStack(String exp){
        if(exp == null || exp.isEmpty()){
            return 0;
        }
        int maxDepth = 0;
        int currentDepth = 0;
        Deque<Character> stack = new LinkedList<>(); // stack uses legacy Vector DS
        char expChar = '\0';
        for(int i=0;i<exp.length();i++) {
            expChar = exp.charAt(i);
            // ignoring operand value
            if (expChar == '(' || expChar == ')') {
                if (isLeftPara(expChar)) {
                    stack.push(expChar);
                    currentDepth++;
                    if (maxDepth < currentDepth) {
                        maxDepth = currentDepth;
                    }
                } else if (stack.isEmpty() || !isMatchedPara(stack.pop(), expChar)) {
                    return -1;
                } else {
                    currentDepth--;
                }
            }
        }
        if(currentDepth != 0){
            return -1;
        }
        return maxDepth;
    }

    /*
    * if left para
    *   then count++
    *   maxDepth = max(mac,count)
    * else
    * count <0 return -1
    * count--
    * return maxDepth
    * */
    public static int maxDepthOfNestedPara(String exp){
        if(exp == null || exp.isEmpty()){
            return 0;
        }
        int maxDepth = 0;
        int currentDepth = 0;
        char charExp = '\0';
        for(int i=0;i<exp.length();i++){
            charExp = exp.charAt(i);
            if(charExp == '(' || charExp == ')'){
                if(isLeftPara(charExp)){
                    currentDepth++;
                    if(maxDepth < currentDepth){
                        maxDepth = currentDepth;
                    }
                }else {
                    if(currentDepth < 0){
                        return -1;
                    }
                    currentDepth--;
                }
            }
        }
        if(currentDepth != 0){
            return -1;
        }
        return maxDepth;
    }

    public static boolean isMatchedPara(Character left, char right) {
        return (left == '(' && right == ')' );
    }

    public static boolean isLeftPara(char ch){
        return (ch == '(');
    }
}
