package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IsomorphicMatch {
    public static void main(String[] args) {
        String s="foo";
        String t = "bar";
        System.out.println(isIsomorphic(s,t));
    }

    /*
    * The idea is based on the fact that all occurrences of two characters should be at same index.
    * We mainly store the first index of every character and for remaining occurrences,
    * we check if they appear at same first index too.
    * */
    public static boolean isIsomorphic(String s, String t) {
        Map<Character ,Integer> lastSeenIndexSrcMap = new HashMap<>();
        Map<Character ,Integer> lastSeenIndexDstMap = new HashMap<>();
        char srcKey,dstKey;

        for(int i=0;i<s.length();i++){
            srcKey = s.charAt(i);
            dstKey = t.charAt(i);
            /*lastSeenIndexSrcMap.get(srcKey);
            if(!lastSeenIndexSrcMap.containsKey(srcKey)){
                lastSeenIndexSrcMap.put(srcKey, i);
            }
            if(!lastSeenIndexDstMap.containsKey(dstKey)){
                lastSeenIndexDstMap.put(dstKey, i);
            }

            if(!(lastSeenIndexSrcMap.get(srcKey).equals(lastSeenIndexDstMap.get(dstKey)))){
                return false;
            }*/
            if(!Objects.equals(lastSeenIndexSrcMap.put(srcKey, i), lastSeenIndexDstMap.put(dstKey, i))){ // put return value as well
                return false;
            }
        }
        return true;
    }
}
