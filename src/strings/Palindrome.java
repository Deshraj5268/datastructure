package strings;


/*
* https://leetcode.com/problems/valid-palindrome/description/
* */
public class Palindrome {

    public static void main(String[] args) {

        String [] strs = {"","ABA","raaca ksd",
        "A man, a plan, a canal: Panama",
        "&&*#(@","      "};
        boolean result, resultRemoveSpacialChar;
        for (String str:strs){
            System.out.println("input : "+str);
            result = isPalindrome(str);
            resultRemoveSpacialChar = isPalindromeWithSpacial(str);
            System.out.println("Output : "+result);
            System.out.println("result using remove spacial : "+resultRemoveSpacialChar);
            System.out.println();
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
        boolean isAllSpecial=true;
        while (left<right){
            leftChar = str.charAt(left);
            rightChar = str.charAt(right);
            if(!(isLowerCaseLetter(leftChar) || isUpperCaseLetter(leftChar) || isDigitLetter(leftChar))){
                left++;
            }else if(!(isLowerCaseLetter(rightChar) || isUpperCaseLetter(rightChar) || isDigitLetter(rightChar))){
                right--;
            }else {
                isAllSpecial = false;
                if((Character.toUpperCase(leftChar) != Character.toUpperCase(rightChar))){
                    return false;
                }
                left++;
                right--;
            }
        }
        if(isAllSpecial){
            return false;
        }
        return true;

    }

    public static boolean isPalindromeWithSpacial(String str) {
        if(str == null){
            return false;
        }
        String woSpacialChar = str.replaceAll("[^A-Za-z0-9]", "");
        int left = 0;
        int right = woSpacialChar.length()-1;

      //  System.out.println(woSpacialChar);
        while(left < right){
            if(Character.toUpperCase(woSpacialChar.charAt(left)) != Character.toUpperCase(woSpacialChar.charAt(right))){
                return false;
            }
            left++;
            right--;
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
