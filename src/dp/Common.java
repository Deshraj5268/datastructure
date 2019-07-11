package dp;

public class Common {

    public static int gcd(int m,int n){
        if(m == 0){
            return n;
        }
        return gcd(n%m,m);
    }
}
