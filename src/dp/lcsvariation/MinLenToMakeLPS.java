package dp.lcsvariation;


/*
* https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
* */
public class MinLenToMakeLPS {

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(minLengthOfLps(str));
    }

    public static int minLengthOfLps(String str){
        return str.length()-LPSubSequence.lpsUsingLCS(str);
    }
}
