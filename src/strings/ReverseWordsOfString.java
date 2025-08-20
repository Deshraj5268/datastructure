package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/*
* input : i.like.this.program.very.much
* output : much.very.program.this.like.i
* */
public class ReverseWordsOfString {

    public static String reverseWords(String s, String separator) {
        if(s == null || s.isEmpty()){
            return "";
        }
        String [] strArr = s.split(separator);
        //  s = s.replaceAll("\\s+", " "); if multiple  space or tab there
        StringBuilder sb = new StringBuilder();
        for(int i= strArr.length -1 ; i>=0;i--){
            sb.append(strArr[i].trim());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    public static String reverseWordsOFString(String str){
        if(str == null || str.isEmpty()){
            return "";
        }
        String [] strArr = str.split("\\.");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<strArr.length;i++){

            sb.append(new StringBuilder(strArr[i]).reverse());
            if((i + 1) < strArr.length){
                sb.append(".");
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) throws Exception {
       // BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
       // int t =1;//Integer.parseInt(inp.readLine());
      //  while(t>0) {
            String str = "i.like.this.program.very.much";//inp.readLine();
            System.out.println(/*strObj.*/reverseWordsOFString(str));
          //  t--;
       // }
        String s = "welcome to the jungle";
        String separator = " ";
        System.out.println(reverseWords(s, separator));
    }
}
