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
            String newStr = str.replaceAll("[^A-Za-z0-9]", "");
            boolean strResult= isPalindromeWithSpacial(newStr, 0, newStr.length()-1);
            System.out.println("strResult :" +strResult);
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

    public static boolean isPalindromeWithSpacial(String str , int left, int right) {
        if(str == null || str.isEmpty()){
            return false;
        }
        while(left < right){
            if(Character.toUpperCase(str.charAt(left)) != Character.toUpperCase(str.charAt(right))){
                return isPalindromeWithSpacialUtil(str, left+1, right) ||
                        isPalindromeWithSpacialUtil(str, left, right-1);
            }
            left++;
            right--;
        }
        return true;

    }
    public static boolean isPalindromeWithSpacialUtil(String str , int left, int right) {
        if(str == null || str.isEmpty()){
            return false;
        }
        while(left < right){
            if(Character.toUpperCase(str.charAt(left)) != Character.toUpperCase(str.charAt(right))){
                return false;
            }else {
                left++;
                right--;
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
