package dp;

import java.util.Arrays;
import java.util.HashSet;

/*https://www.youtube.com/watch?v=th4OnoGasMU*/

public class WordBreakProblem {

    private static HashSet dictionary = new HashSet<String>();


    /*
    *               "abcde"
    *
    *    "bcde"       "cde"      "de"     "e"    ""
    *
    *   "cde" "de" "e" ""
    *
    *  n^n
    * */

    public static boolean wordBreak(String input){
        int size = input.length();
        if(size == 0){
            return true;
        }
        for(int i=1;i<=size;i++){
            //prefix 0 to i and i to size breakable or not
            // partition only when current word is valid
            if(dictionary.contains(input.substring(0,i)) && wordBreak(input.substring(i,size))){
                return true;
            }
        }
        return false;
    }

    /*
    * https://www.techiedelight.com/word-break-problem/
    * */
    private static boolean wordBreakDp(String word, int[] dpLookup) {
        int n = word.length();
        if(n == 0){
            return true;
        }
        if(dpLookup[n] == -1){
            dpLookup[n] = 0;
            for(int i=1;i<=n;i++) {
                String prefix = word.substring(0, i);
                if(dictionary.contains(prefix) && wordBreakDp(word.substring(i,n),dpLookup)){
                    dpLookup[n] = 1;
                    return true;
                }

            }
        }
        return dpLookup[n] == 1;

    }

    public static void main(String[] args) {

        String [] dicsStrArr = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};

        for(int i=0;i<dicsStrArr.length;i++){
            dictionary.add(dicsStrArr[i]);
        }

        String [] words = {/*"ilikesamsung","iiiiiiii","ilikelikeimangoiii","samsungandmango",*/"tk"};
        for(String word:words) {
            System.out.println(word+" : " + wordBreak(word));
           // System.out.println("dp ");
            int [] dp = new int[word.length()+1];
            Arrays.fill(dp,-1);
            boolean isAbleToSegment = wordBreakDp(word,dp);
            System.out.println(word +" : "+isAbleToSegment);
        }
    }


}
