package queue.slidingwindowvariation.vwindowsize;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWORepeating {

    public static void main(String[] args) {

        String input = "geeksfeeks";
        int result = longestSubstringWORepeating(input);
        System.out.println("input : "+input +" result : "+result);
    }

    public static int longestSubstringWORepeating(String input){
        Map<Character,Integer> map = new HashMap<>();
        int i=0,j=0,len = input.length();
        char nextChar;
        int maxLen = 0;
        while(j<len){
            nextChar = input.charAt(j);
            if(map.containsKey(nextChar)){
               i = Math.max(i,map.get(nextChar)+1);
            }
            map.put(nextChar,j);
            maxLen = Math.max(maxLen,(j-i+1));
            j++;
        }
        return maxLen;
    }
}
