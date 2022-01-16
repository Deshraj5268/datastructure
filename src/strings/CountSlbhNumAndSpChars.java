package strings;

import java.util.ArrayList;
import java.util.List;

public class CountSlbhNumAndSpChars {

    public static void main(String[] args) {

        String str = "73857359837593adasda84759376^$%^$%^4398573hsdfhsflsdhflsdfjsdlf*^^&%^&";

        List<Character> numList = new ArrayList<>();
        List<Character> charList = new ArrayList<>();
        List<Character> spacialList = new ArrayList<>();
        char ch = '\0';
        for(int i=0 ; i< str.length();i++){
            ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z' || (ch >= 'A' && ch <= 'Z')){
                charList.add(ch);
            }else if(ch >= '0' && ch <= '9'){
                numList.add(ch);
            }else{
                spacialList.add(ch);
            }
        }
        System.out.println("charList size "+charList.size());
        System.out.println("numListt size "+numList.size());
        System.out.println("spacialList size "+spacialList.size());

        System.out.println("print charList\n "+charList.toString());
        System.out.println("print numList\n" +numList.toString());
        System.out.println("print spacialList\n" +spacialList.toString());
    }
}
