package leetcode.monthlycontest;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3423/
* */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aabb"));
        System.out.println(longestPalindrome("aaabb"));
        System.out.println(longestPalindrome("aabbccccde"));
    }

    public static int longestPalindrome(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        Integer charCount;
        char ch;
        for(int i=0;i<s.length();i++){
            ch = s.charAt(i);
            charCount = map.get(ch);

            if(charCount == null){
                map.put(ch,1);
            }else{
                map.put(ch,charCount+1);
            }
        }
        int evenLengthSum = 0;
        int oddLengthCount = 0;
        for(Integer value:map.values()){
            if(value % 2 == 0){
                evenLengthSum += value;
            }else{
                evenLengthSum += value-1;
                oddLengthCount++;
            }
        }
        return (oddLengthCount == 0?evenLengthSum:evenLengthSum+1);
    }
}