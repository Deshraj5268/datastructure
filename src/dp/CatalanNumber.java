package src.dp;

public class CatalanNumber {

    public static void main(String[] args) {
        int n = 9;
        for(int i=0;i<n;i++){
            System.out.println(i +"th catalan number : "+catalanRec(i));
            System.out.println(i +"th catalan number DP: "+catalanDP(i));
        }

    }

    /*
    * TC : O(2^n)
    * */
    public static int catalanRec(int n){
        if(n<=1){
            return 1;
        }
        int res = 0;
        for(int i=0;i<n;i++){
            res += catalanRec(i) * catalanRec(n-i-1);
        }
        return res;
    }

    /*
    * TC O(2n)
    * SC: O(n)
    * */
    public static int catalanDP(int n){
        if(n<=1){
            return 1;
        }
        int [] cat = new int[n+1];
        cat[0] = cat[1] = 1;
        for(int i=2;i<=n;i++){
            cat[i] = 0;
            for(int j=0;j<i;j++){
                cat[i] += cat[j]*cat[i-j-1];
            }
        }
        return cat[n];
    }
}
