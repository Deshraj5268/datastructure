package dp;

public class Common {


    private Common(){

    }
    public static int gcd(int m,int n){
        if(m == 0){
            return n;
        }
        return gcd(n%m,m);
    }

    public static boolean isPalindrome(String str,int i,int len){
        while(i < len){
            if(str.charAt(i) != str.charAt(len)){
                return false;
            }
            i++;
            len--;
        }
        return true;
    }

    public static boolean isPalindromeRec(String str,int i,int j){
        if(i > j){
            return true;
        }
        if(str.charAt(i) != str.charAt(j)){
            return false;
        }
        return isPalindromeRec(str,i+1,j-1);
    }
}
