package strings;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;


/*
* https://www.geeksforgeeks.org/reduce-the-string-to-minimum-length-with-the-given-operation/
* https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
*
* */
public class ReduceString {

    // even number of adjacent element removal
    public static int reduceStringUptoMinLength(String str){
        if(str == null || str.isEmpty()){
            return 0;
        }
        Deque<Character> satck = new ArrayDeque();
        satck.push(str.charAt(0));
        char out;
        for(int i =1;i<str.length();i++){
            out = Character.toUpperCase(str.charAt(i));
            if(!satck.isEmpty() && out == Character.toUpperCase((Character)satck.peek())){
                satck.pop();
            }else{
                satck.push(out);
            }
        }
        return satck.size();
    }

    public static void main(String[] args) {
        String str = "AsSaDda";
        System.out.println(reduceStringUptoMinLength(str));

    }
}
