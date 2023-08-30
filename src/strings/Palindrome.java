package strings;


/*
* https://leetcode.com/problems/valid-palindrome/description/
* */
public class Palindrome {

    public static void main(String[] args) {

        String [] strs = {"","ABA","raaca ksd",
        "A man, a plan, a canal: Panama"};
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
        int left = 0;
        int right = str.length()-1;
        char leftChar,rightChar;
        while (left<right){
            leftChar = str.charAt(left);
            rightChar = str.charAt(right);
            if(!(isLowerCaseLetter(leftChar) || isUpperCaseLetter(leftChar) || isDigitLetter(leftChar))){
                left++;
            }else if(!(isLowerCaseLetter(rightChar) || isUpperCaseLetter(rightChar) || isDigitLetter(rightChar))){
                right--;
            }else {
                if((Character.toUpperCase(leftChar) != Character.toUpperCase(rightChar))){
                    return false;
                }
                left++;
                right--;
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
       // return Character.isLetter(leftChar);
    }
}
