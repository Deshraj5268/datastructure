package arrays;

public class SmallestPalindrome {

    public static void main(String[] args) {

    }


   /* public static String smallestPalindrome(String str){
        if(isPalindrome(str)){
            //str = addOne(str);
        }
        int length = str.length();
        StringBuilder left, reverseLeft, right , mid;
        if(length % 2 == 1){
            reverseLeft = new StringBuilder(str.substring(0,(length/2-1))).reverse();
            right = new StringBuilder(str.substring(length/2 , length-1));
            mid = new StringBuilder(str.substring(length/2, length/2));
        }
    }*/

    public static boolean isPalindrome(String str){
        if(str == null){
            return false;
        }
        int l = 0;
        int r = str.length()-1;
        while (l < r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
