package strings;

import java.util.Stack;

public class RemoveConsecutiveDuplicate {

    public static void main(String[] args) {
        String [] input = {"Apple", "AbbcccAd","AbcdDCbA","abbacac"};
        String [] expected = {"Ale","d",null, "cac"};
        for (int i=0;i<input.length;i++){
            String result = removeConsecutiveDuplicates(input[i]);
            System.out.println(input[i] + "-> "+result);
        }
    }

    public static String removeConsecutiveDuplicates(String input){
        Stack<Character> stack = new Stack<>();
        int i=0;
        int n = input.length();
        char ch;
        while(i < n){
            ch = input.charAt(i);
            if(!stack.isEmpty() && Character.toUpperCase(stack.peek()) == Character.toUpperCase(ch)){
                while (i < n && Character.toUpperCase(stack.peek()) == Character.toUpperCase(input.charAt(i))){
                    i++;
                }
                stack.pop();
            }else {
                stack.push(ch);
                i++;
            }
        }
        if(stack.isEmpty()){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
