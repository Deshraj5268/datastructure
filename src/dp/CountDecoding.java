package dp;

public class CountDecoding {

    public static long countDecoding(String str,int n){
        if(str == null){
           return 0;
        }
        if(n ==0 || n == 1){
            return 1;
        }
        long count = 0;
        if(str.charAt(n-1)>'0'){
            count = countDecoding(str,n-1);
        }
        if(str.charAt(n-2) == '1' || (str.charAt(n-2) == '2' && str.charAt(n-1) < '7')){
            count += countDecoding(str,n-2);
        }
        return count;
    }

    public static long countDecodingDp(String str,int n){
        if(n == 0 || n == 1){
            return 1;
        }
        long [] count = new long[n+1];
        count[0] = count[1] = 1;
        for(int i = 2;i<=n;i++) {
            count[i] = 0;
            if (str.charAt(i - 1) > '0') {
                count[i] = count[i - 1];
            }
            if(str.charAt(i-2) == '1' || (str.charAt(i-2) == '2'  && str.charAt(i-1)<'7')){
                count[i] += count[i-2];
            }
        }
        return count[n];
    }

    public static void main(String[] args) {
        String str = "121";
        System.out.println(countDecoding(str,str.length()));
        System.out.println(countDecodingDp(str,str.length()));

    }
}
