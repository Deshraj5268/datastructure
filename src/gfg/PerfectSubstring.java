package gfg;

import java.util.HashMap;
import java.util.Map;

/*
* https://learnbyexample.in/content/technical/anchanto.php
* https://www.geeksforgeeks.org/number-substrings-count-character-k/
* */
public class PerfectSubstring {

    public static void main(String[] args) {

        String [] strs = {"1102021222","aabbcc","aabccc"};
        int [] ksVal = {2,2,2};
        for (int i=0;i<strs.length;i++){
            System.out.println("inout string "+strs[i] + " k "+ksVal[i]);
            int result = countPerfectSubstring(strs[i],ksVal[i]);
            System.out.println("result : "+result);
            result = countPerfectSubstringOpt(strs[i],ksVal[i]);
            System.out.println("result optimize : "+result);
        }

    }

    public static int countPerfectSubstring(String str,int k){
        if(str == null || str.isEmpty()){
            return 0;
        }
        int count = 0;
        int n = str.length();
        char currentChar;
        for(int i=0;i<n;i++){
            Map<Character,Integer> counterMap = new HashMap<>();
            for(int j=i;j<n;j++){
                currentChar = str.charAt(j);
                counterMap.put(currentChar,counterMap.getOrDefault(currentChar,0)+1);
                /*if(counterMap.size()>k){
                    break;
                }*/
                if(isPerfectMatch(counterMap,k)){
                    count++;
                }
            }
        }
        return count;
    }

    public static int countPerfectSubstringOpt(String str,int k){
        if(str == null || str.isEmpty()){
            return 0;
        }
        int count = 0;
        int n = str.length();
        char currentChar;
        Map<Character,Integer> counterMap = new HashMap<>();

        for(int i=0;i<n;i++){

          //  Map<Character,Integer> counterMap = new HashMap<>();
            for(int j=i;j<n;j++){
                if(i==0) {
                    currentChar = str.charAt(j);
                    counterMap.put(currentChar, counterMap.getOrDefault(currentChar, 0) + 1);
                }else {
                    Integer val = counterMap.get(str.charAt(i));
                    if(val!= null){
                        if(val-1 == 0){
                            counterMap.remove(str.charAt(i));
                        }
                        counterMap.put(str.charAt(i),val-1);
                    }
                }
                /*if(counterMap.size()>k){
                    break;
                }*/
                if(isPerfectMatch(counterMap,k)){
                    count++;
                }
            }
        }
        return count;
    }



    private static boolean isPerfectMatch(Map<Character, Integer> counterMap, int k) {

        for(int val :counterMap.values()){
            if(val != k){
                return false;
            }
        }
        return true;
    }
}
