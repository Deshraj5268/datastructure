package dp;

public class LPSubstring {

    public static boolean isPalindrom(String str,int i,int len){

        while(i < len){
            if(str.charAt(i) != str.charAt(len)){
                return false;
            }
            i++;
            len--;
        }
        return true;
    }

    public static int lpSubstring(String str){
        int max = 0;
        for(int i=0;i<=str.length()-1;i++){
            for(int j=0;j<=i;j++){
                if(isPalindrom(str,j,i)){
                    if(max < (i-j+1)){
                        max = i-j+1;
                        System.out.println(i+","+j);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        String str = "forgeeksskeegfor";
        System.out.println(lpSubstring(str));
    }
}
