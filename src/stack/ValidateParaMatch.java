package stack;

import java.util.Stack;

public class ValidateParaMatch {

    public static void main(String[] args) {
        String str = "{[()]}";
        boolean isValid = validatePara(str);
        System.out.println("isValid :"+isValid);
    }

    public static boolean validatePara(String str){
        Stack<Character> stack = new Stack<>();
        char ch;
        for(int i=0;i<str.length();i++){
            ch = str.charAt(i);
            if(isLeftPara(ch)){
                stack.push(ch);
            }else if(stack.isEmpty() || !isParaMatch(stack.pop(), ch)){
               return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isParaMatch(Character left, char right) {
        return (left == '(' && right == ')') ||
                (left == '[' && right == ']') ||
                (left == '{' && right == '}') ;
    }

    public static boolean isLeftPara(char ch){
        return (ch == '(' || ch == '[' || ch == '{');
    }
}
