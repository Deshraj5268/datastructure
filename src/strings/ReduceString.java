package strings;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class ReduceString {

    public static int reduceStringUptoMinLength(String str){
        if(str == null || str.isEmpty()){
            return 0;
        }
        Deque<Character> st = new ArrayDeque();
        st.push(str.charAt(0));
        char out;
        for(int i =1;i<str.length();i++){
            out = Character.toUpperCase(str.charAt(i));
            if(!st.isEmpty() && out == Character.toUpperCase((Character)st.peek())){
                st.pop();
            }else{
                st.push(out);
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        String str = "AsSaDda";
        System.out.println(reduceStringUptoMinLength(str));

    }
}
