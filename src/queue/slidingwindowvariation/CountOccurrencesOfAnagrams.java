package queue.slidingwindowvariation;

import java.util.*;

/*
* need to try
* https://leetcode.com/problems/find-all-anagrams-in-a-string/
* */

public class CountOccurrencesOfAnagrams {

    public static void main(String[] args) {

        String text = "aabaabba";
        String word = "aaba";
        int result = countOccurrencesOfAnagrams(text.toCharArray(),text.length(),
                word.toCharArray());
        System.out.println("input : "+text+ " word :"+word
                +"\nresult : "+result);

        List<Integer> anagramsIndexList = findAnagrams(text, word);
        System.out.println("input : "+text+ " word :"+word);
        System.out.print(" result :"+Arrays.toString(anagramsIndexList.toArray()));


    }

    public static int countOccurrencesOfAnagrams(char [] arr,int n,char [] pattern){
        Map<Character,Integer> patternMap = preparePatternMap(pattern);
        int i=0,j=0,result=0,count;
        count = patternMap.size();
        int k = pattern.length;
        Integer val;
        while(j<n){
           val = patternMap.get(arr[j]);
           if(val != null){
               if(val-1 == 0){
                   count--;
               }
               patternMap.put(arr[j],val-1);
           }
           if((j-i+1) < k){
               j++;
           }else {
               if(count == 0){
                   result++;
               }
               val = patternMap.get(arr[i]);
               if(val != null){
                   if(val == 1){
                       count++;
                   }
                   patternMap.put(arr[i],val+1);
               }
               i++;
               j++;
           }
        }
        return result;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[128];
        int required = p.length();

        for (final char c : p.toCharArray())
            ++count[c];

        for (int l = 0, r = 0; r < s.length(); ++r) {
            if (--count[s.charAt(r)] >= 0)
                --required;
            while (required == 0) {
                if (r - l + 1 == p.length())
                    ans.add(l);
                if (++count[s.charAt(l++)] > 0)
                    ++required;
            }
        }

        return ans;
    }


    public static int countOccurrenceOfAnagramsBruteForce(char [] arr,int n,char [] pattern){
        int [] patternArr = new int[26];
        int [] textArr = new int[26];
        prepareCountChars(pattern,patternArr);
       // prepareCountChars(arr,textArr);
        int i=0,j=0;
        int result = 0;
        int k = pattern.length;
        while(j<k){
            textArr[arr[j] -'a']++;
            if((j-i+1) < k){
                j++;
            }else{
                if(searchValuesInArr(patternArr,textArr)){
                    result++;
                }
                textArr[arr[i] -'a']--;
                i++;
                j++;
            }
        }
        return result;
   }

    private static boolean searchValuesInArr(int[] patternArr, int[] textArr) {

        for(int i=0;i<patternArr.length;i++){
            if(patternArr[i] != textArr[i]){
                return false;
            }
        }
        return true;
    }

    private static void prepareCountChars(char [] arr,int [] countArr){
        for(int i=0;i<arr.length;i++){
            // a- z
            countArr[arr[i]-'a']++;
        }
   }

    private static Map<Character, Integer> preparePatternMap(char[] pattern) {
       Map<Character,Integer> map = new HashMap<>();
        for(char ch:pattern){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        return map;
    }
}
