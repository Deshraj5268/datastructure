package leetcode.topinterviewquestion;

public class ReverseInteger {

    public static void main(String[] args) {

        int original = 12344;
        int result = reverseInt(original);
        System.out.println("result : "+result);
    }

    public static int reverseInt(int original){
        if(original > Integer.MAX_VALUE || original < Integer.MIN_VALUE){
            return 0;
        }
        int temp = Math.abs(original);
        long result=0;
        while (temp != 0){
            result = result*10+ (temp%10);
            temp = temp/10;
        }
        if(original < 0){
            result = -1 * result;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }
}
