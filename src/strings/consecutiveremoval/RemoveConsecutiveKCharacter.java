package strings.consecutiveremoval;

import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
public class RemoveConsecutiveKCharacter {

    public static void main(String[] args) {
        String [] inputs = {"deeedbbcccbdaa", "pbbcggttciiippooaais"};
        int [] kValueArray = {3, 2};
        String [] expectedOutput = {"aa", "ps"};
        for(int i=0;i<inputs.length;i++){
            String result = removeKConsecutiveElement(inputs[i], kValueArray[i]);
            if(result.equals(expectedOutput[i])){
                System.out.println("result is matching : "+result);
            }
        }
    }

    public static String removeKConsecutiveElement(String input, int k){
        Stack<CharCountPair> stack = new Stack<>();
        int i = 0;
        int n = input.length();
        while (i < n){
            if(!stack.isEmpty() && input.charAt(i) == stack.peek().ch){
                stack.peek().count++;
                if(stack.peek().count == k){
                    stack.pop();
                }
            }else {
                CharCountPair charCountPair = new CharCountPair();
                charCountPair.ch = input.charAt(i);
                charCountPair.count = 1;
                stack.push(charCountPair);
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            CharCountPair stackElement = stack.pop();
            for (int count=0;count<stackElement.count; count++){
                sb.append(stackElement.ch);
            }
        }
        return sb.reverse().toString();
    }

   static class CharCountPair {

        char ch;
        int count;
    }
}
