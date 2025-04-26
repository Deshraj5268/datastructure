package strings;

public class GenerateLexicographicallyStr {

    /*
    *fill an initially the fill max value(z-a) from last
    * */
    public static String generateLexical(int k,int n){
        char [] charArr = new char[n];
        for(int i=0;i<n;i++){
            charArr[i] = 'a';
        }
        int c = n;
        int tc = k;
        int x = tc-n;
        for(int i=n-1;i>=0;i--){
            if(x > 26){
                charArr[i] = 'z';
                x = (x-26)+1;
            }else if(x>0){
                charArr[i] = (char)(charArr[i]+x);
                x = 0;
            }
            if(x == 0){
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(charArr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int k = 25;
        int n = 3;
        System.out.println(generateLexical(k,n));

    }
}
