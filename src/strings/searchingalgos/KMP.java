package strings.searchingalgos;

import java.util.Arrays;

public class KMP {

    public static void main(String[] args) {

        KMP kmp = new KMP();
        String pattern = "aaacaaaaa";
        // aaacaaaa (j!=0) case  [0, 1, 2, 0, 1, 2, 3, 3, 3]
        int [] lps = kmp.calculateLPS(pattern);
        System.out.println(Arrays.toString(lps));

        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        boolean result = kmp.patternSearching(str.toCharArray(), subString.toCharArray());
        System.out.print(result);
    }

    /*
    * longest prefix suffix : find the longest proper prefix which is also suffix
    * */
    public  int [] calculateLPS(String pattern){
        int j=0;
        int [] lps = new int[pattern.length()];//fill 0

        for(int i=1;i<pattern.length();){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j+1;
                j++;
                i++;
            }else{
                if(j != 0){
                    j = lps[j-1]; //
                }else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    /*
    * TC : O(m+n)
    * SC : O(m) : m is length of pattern
    * */
    public  boolean patternSearching(char []text, char []pattern){

        int lps[] = calculateLPS(new String(pattern));
        int i=0;
        int j=0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }
}
