package strings;


/*
* 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/
* */
public class PalindromeII {

    public static void main(String[] args) {

        String [] strs = {"ABA","aba",
        "abc"};
        boolean result;
        for (String str:strs){
            System.out.println("input : "+str);
            result = isPalindrome(str);
            System.out.println("Output : "+result);
        }

    }

    /*
    * it contains ALL printable ASCII chars
    * */
    public static boolean isPalindrome(String str){
        if(str == null){
            return false;
        }
        int leftIndex = 0;
        int rightIndex = str.length()-1;
        char leftChar,rightChar;
        while (leftIndex<rightIndex){
            leftChar = str.charAt(leftIndex);
            rightChar = str.charAt(rightIndex);
            if(!(isLowerCaseLetter(leftChar) || isUpperCaseLetter(leftChar) || isDigitLetter(leftChar))){
                leftIndex++;
            }else if(!(isLowerCaseLetter(rightChar) || isUpperCaseLetter(rightChar) || isDigitLetter(rightChar))){
                rightIndex--;
            }else {
                if((Character.toUpperCase(leftChar) != Character.toUpperCase(rightChar))){
                   return isPalindromeAtMostOneDel(str,leftIndex+1,rightIndex)
                           || isPalindromeAtMostOneDel(str,leftIndex,rightIndex-1);
                }else {
                    leftIndex++;
                    rightIndex--;
                }
            }
        }
        return true;

    }

    public static boolean isPalindromeAtMostOneDel(String str,int leftIndex,int rightIndex){
        char leftChar,rightChar;
        while (leftIndex<rightIndex){
            leftChar = str.charAt(leftIndex);
            rightChar = str.charAt(rightIndex);
            if(!(isLowerCaseLetter(leftChar) || isUpperCaseLetter(leftChar) || isDigitLetter(leftChar))){
                leftIndex++;
            }else if(!(isLowerCaseLetter(rightChar) || isUpperCaseLetter(rightChar) || isDigitLetter(rightChar))){
                rightIndex--;
            }else {
                if((Character.toUpperCase(leftChar) != Character.toUpperCase(rightChar))){
                    return false;
                }
                leftIndex++;
                rightIndex--;
            }
        }
        return true;
    }

    private static boolean isDigitLetter(char letter) {
        return (letter >='0' && letter <='9');
    }

    private static boolean isUpperCaseLetter(char letter) {
        return (letter >='A' && letter <='Z');
    }

    private static boolean isLowerCaseLetter(char letter) {
        return (letter >='a' && letter <='z');
    }
}
