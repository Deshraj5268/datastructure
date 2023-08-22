package dp.lcsvariation;


/*
* https://www.geeksforgeeks.org/longest-repeating-subsequence/
* */
public class LRepeatedSubsequence {

    public static void main(String[] args) {
        String [] str1Mat = {"AABEDCDD","sea","leetcode"};
        int result;
        for(int i=0;i<str1Mat.length;i++){
            result = lrs(str1Mat[i]);
            System.out.println("result "+result);
        }
    }

    /*
    * find lcs way if both position should be different
    *       "AABEDCDD"
    * copy  "AABEDCDD"
    *
    * */
    public static int lrs(String str){
        int m = str.length();
        return lcsModified(str,str,m,m);
    }

    public static int lcsModified(String str1,String str2,int m,int n){
        int [][] tab = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    tab[i][j] = 0;
                }else if(i != j && str1.charAt(i-1) == str2.charAt(j-1)){
                    tab[i][j] = 1+tab[i-1][j-1];
                }else {
                    tab[i][j] = Math.max(tab[i-1][j],tab[i][j-1]);
                }
            }
        }
        return tab[m][n];
    }
}
