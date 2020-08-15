package bitproblems;

public class PowerOF4 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println("is number "+n+" power of 4 "+isPowerOf4(n));

    }

    public static boolean isPowerOf4(int n){
        if(n == 0){
            return false;
        }
        return (Math.floor(Math.log(n)/Math.log(4)) == Math.ceil(Math.log(n)/Math.log(4)));
    }
}
