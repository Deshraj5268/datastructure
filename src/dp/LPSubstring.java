package dp;

import java.util.Arrays;

public class LPSubstring {

    public static void main(String[] args) {

        String str = "aaa";
        lpsSubString(str);
        System.out.println("\nusing Dp ");
        lpsDp(str);
    }



    public static void lpsDp(String str){
        if(str == null || str.isEmpty()){
            return;
        }

        int n = str.length();
        int max = 1;
        int start = 0;
        int end = 0;
        int c=0;
        //table for storage
        boolean [][] table = new boolean[n][n];
        for(int i=0;i<n;i++){
            table[i][i] = true;
            c++;
        }

        for(int i=0;i<n-1;i++){
            if(str.charAt(i) == str.charAt(i+1)){
                table[i][i+1] = true;
                start = i;
                end = i+1;
                max = 2;
                c++;
            }
        }

        int j=0;
        for (int L = 3;L <= n;L++){
            for (int i=0;i<n-L+1;i++){
                j = i+L-1;
                if(table[i+1][j-1] && str.charAt(i) == str.charAt(j)){
                    table[i][j] = true;
                    if(max < L){
                        start = i;
                        end = j;
                        max = L;

                    }
                    c++;
                }
            }
        }
       /* for(boolean [] aarr : table) {
            System.out.println(Arrays.toString(aarr));
        }*/
        System.out.println(max+ " count "+c);
        printPalindromeStr(str,start,end);

    }

    /*
    * O(n^3)
    * brute force l =1 2...l
    * length i=1 to L
    * generate all string (J)of length i ( i.e L-i+1 all string )
    * check from J index to J+i ( staring from j to till length (i))
    *
    * */
    public static void lpsSubString(String str){
        int n = str.length();
        int max = 1;
        int s = 0;
        int e = 0;
        for(int L=1;L<=n;L++){
            for(int j=0;j<=n-L;j++){ //n-i+1 substring possible
                if(Common.isPalindromeRec(str,j,L+j-1)){
                    if(max < L){
                        max = L;
                        s = j;
                        e = L+j-1;
                    }
                }
            }
        }
        System.out.println(max);
        printPalindromeStr(str,s,e);

    }

    private static void printPalindromeStr(String str,int s,int e){
        while (s <= e){
            System.out.print(str.charAt(s));
            s++;
        }
    }
}
