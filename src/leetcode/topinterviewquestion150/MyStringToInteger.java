package leetcode.topinterviewquestion150;

public class MyStringToInteger {

    public static void main(String[] args) {

        String [] mat = {"   -42","4193 with words","2147483647","-2147483648"};
        int result;
        for(int i=0;i<mat.length;i++){
            System.out.println("intput : "+mat[i]);
            result = myAtoi(mat[i]);
            System.out.println("result : "+result);
        }
    }

    public static int myAtoi(String s) {
        if(s == null){
            return 0;
        }
        s = s.trim();
        if(s.isEmpty()){
            return 0;
        }
        int i=0,n=s.length(),sign=1;
        long result = 0;
        char currentChar;
        if(s.charAt(0) == '-'){
            sign = -1;
            i++;
        } else if(s.charAt(0) == '+'){
            i++;
        }
        while(i<n){
            currentChar = s.charAt(i);
            if(!isDigit(currentChar)){
                break;
            }else {
                result = result*10 + currentChar-'0';
            }
            if(result*sign > Integer.MAX_VALUE ){
                return sign*Integer.MAX_VALUE;
            }
            if(result*sign < Integer.MIN_VALUE){
                return sign*Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)sign*(int)result;
    }
    public static boolean isDigit(char currentChar){
        return (currentChar >= '0' && currentChar <='9');
    }
}
