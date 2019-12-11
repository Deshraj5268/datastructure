package strings;

import java.util.HashSet;

public class Pangram {

    public static boolean isPangram(String str){
        if(str == null){
            return false;
        }
        HashSet<Character> hashSet = new HashSet<>();
        char ch;
        for(int i= 0;i<str.length();i++){
            ch = str.charAt(i);
            if(ch >='a' && ch <='z') {
                hashSet.add(str.charAt(i));
            }
        }
        return (hashSet.size() == 26);
    }

    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";
        System.out.println(isPangram(str));
    }
}
