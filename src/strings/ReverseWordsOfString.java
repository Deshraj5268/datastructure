package strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/*
* input : i.like.this.program.very.much
* output : much.very.program.this.like.i
* */
public class ReverseWordsOfString {

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
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        int t =Integer.parseInt(inp.readLine());
        while(t>0) {
            String str = inp.readLine();
            System.out.println(/*strObj.*/reverseWordsOFString(str));
            t--;
        }
    }
}
