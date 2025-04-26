package leetcode.topinterviewquestion150;

import java.util.Arrays;

public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        String [] strs = {"flower","flow","flight"};
        System.out.println("input : "+ Arrays.toString(strs));
       String result  =  longestCommonPrefix(strs);
        System.out.println("result : "+result);
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int strLen;
        int j;
        String str;
        for(int i=1;i<strs.length;i++){
            str = strs[i];
            strLen = str.length();
            j = 0;
            while(j<Math.min(prefix.length(),strLen) && str.charAt(j) == prefix.charAt(j)){
                j++;
            }
            prefix = prefix.substring(0,j);
        }
        return prefix;
    }
}
