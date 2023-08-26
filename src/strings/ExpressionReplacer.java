package strings;

import java.util.HashMap;
import java.util.Map;

public class ExpressionReplacer {

    static Map<String,String> dictionary = new HashMap<>();
    public static void main(String[] args) {

        addWords("name","deshraj thakur");
        addWords("stream","computer science");
        String input = "Hi , %name%_your branch is %stream%";
        System.out.println("input : "+input);
        String result = expressionEvl(input);
        System.out.println("result: "+ result);
    }

    public static void addWords(String key,String val){
        dictionary.put(key,val);
    }
    public static String expressionEvl(String expr){
        StringBuilder result = new StringBuilder();
        char ch;
        String dynamicPlaceHolder="%";
        int firstDelimiter=0,secondDelimiter;
       for(int i=0;i<expr.length();) {
           ch = expr.charAt(i);
           if (isDynamicPlaceholder(ch)) {
               firstDelimiter = expr.indexOf(dynamicPlaceHolder,firstDelimiter);
               secondDelimiter = expr.indexOf(dynamicPlaceHolder,firstDelimiter+1);
               if(secondDelimiter == -1){
                   throw new RuntimeException("Invalid expression");
               }
               String value = dictionary.get(expr.substring(firstDelimiter+1,secondDelimiter));
               if(value == null){
                   throw new RuntimeException("placeholder value is not present");
               }
               result.append(value);
               i = secondDelimiter+1;
               firstDelimiter = i;
           }else {
               result.append(ch);
               i++;
           }
       }
       return result.toString();
    }

    private static boolean isDynamicPlaceholder(char ch) {
        return (ch == '%');
    }
}
