package queue.slidingwindowvariation.vwindowsize;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithUniqueChar {

    public static void main(String[] args) {
        String input = "aabacbebebe";//aaaa
        int k = 3;//2 out -1
        System.out.println("input :"+input+" k:"+k);
        int result = longestSubStrWithUniqueChar(input,k);
        System.out.println(result);

    }

    public static int longestSubStrWithUniqueChar(String input,int k){
        Map<Character,Integer> map = new HashMap<>();
        Integer mapCharCount;
        int i=0,j=0;
        int maxLen=0;
        char ch;
        int l=input.length();
        while(j<l){
            ch = input.charAt(j);
            mapCharCount = map.get(ch);
            if(mapCharCount == null){
                map.put(ch,1);
            }else{
                map.put(ch,mapCharCount+1);
            }
            if(map.size()<k){
                j++;
            }else if(map.size() == k){
                if(maxLen < (j-i+1)){
                    maxLen = j-i+1;
                }
                j++;
            }else{
                while (map.size() > k){
                    ch = input.charAt(i);
                    mapCharCount = map.get(ch);
                    if(mapCharCount != null && mapCharCount>0){
                        map.put(ch,mapCharCount-1);
                    }
                    if(map.get(ch) == 0){
                        map.remove(ch);
                    }
                    i++;
                }
                j++;
            }
        }
        return  (maxLen == 0)?-1:maxLen;
    }
}
