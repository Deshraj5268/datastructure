package dp;

public class LCS {

    private static int [] memoArr;

    public static int lcs(String str1,String str2,int m,int n){
        if(n == -1 || m == -1){
            return 0;
        }
        if(str1.charAt(m) == str2.charAt(n)){
            return 1+ lcs(str1,str2,m-1,n-1);
        }
        return Math.max(lcs(str1,str2,m-1,n),lcs(str1,str2,m,n-1));
    }

    public static int [][] lcsDpTab(String str1,String str2,int m,int n){
        int [][] tab = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i == 0 || j == 0){
                    tab[i][j] = 0;
                }else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    tab[i][j] = 1 + tab[i-1][j-1];
                }else{
                    tab[i][j] = Math.max(tab[i-1][j],tab[i][j-1]);
                }
            }
        }
        return tab;
    }

    public static int lcsDPMemmoziation(String str1,String str2,int m,int n,int [][] arr){
        if(m == -1 || n == -1){
            return 0;
        }
        if(arr[m][n] != 0){
            return arr[m][n];
        }
        if(str1.charAt(m) == str2.charAt(n)){
            arr[m][n] = 1+lcsDPMemmoziation(str1,str2,m-1,n-1,arr);
            return arr[m][n];
        }else {
            arr[m][n] = Math.max(lcsDPMemmoziation(str1,str2,m-1,n,arr),lcsDPMemmoziation(str1,str2,m,n-1,arr));
            return arr[m][n];
        }
    }

    public static int  lcsDpTabSpaceOptimize(String str1,String str2,int m,int n){
        int [][] tab = new int[2][n+1];
        int bi = 0;
        for(int i=0;i<=m;i++){
            bi = i & 1;
            for(int j=0;j<=n;j++){
                if(i == 0 || j == 0){
                    tab[bi][j] = 0;
                }else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    tab[bi][j] = 1 + tab[1-bi][j-1];
                }else{
                    tab[bi][j] = Math.max(tab[1-bi][j],tab[bi][j-1]);
                }
            }
        }
        return tab[bi][n];
    }

    /*public static int lcsDpMemoziation(String str1,String str2,int m,int n){
        if(m == -1 || n == -1){
            return 0;
        }
        if(str1.charAt(m) == str2.charAt(n)){
            memoArr[m][n] = 1+
        }
    }*/


    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println("native "+lcs(str1,str2,str1.length()-1,str2.length()-1));
        int [][] arr = new int [str1.length()+1][str2.length()+1];
        System.out.println("Dp With memoziation "+lcsDPMemmoziation(str1,str2,str1.length()-1,str2.length()-1,arr));
        System.out.println("Dp with space optimization "+lcsDpTabSpaceOptimize(str1,str2,str1.length(),str2.length()));
        int [][] tab = lcsDpTab(str1,str2,str1.length(),str2.length());
        System.out.println("Dp with tabulation appraoch"+tab[str1.length()][str2.length()]);
        printLCS(tab,str1,str2,tab[str1.length()][str2.length()]);
    }

    private static void printLCS(int[][] tab,String str1,String str2,int lcs) {

       char [] lcsArr = new char[lcs+1];
       int temp = lcs;
       int i=str1.length();
       int j = str2.length();
       while (i > 0 && j > 0){
           if(str1.charAt(i-1) == str2.charAt(j-1)){
               lcsArr[temp] = str1.charAt(i-1);
               temp--;
               i--;
               j--;
           }else if(tab[i-1][j] > tab[i][j-1]){
               i--;
           }else {
               j--;
           }
       }
       for (int k = 0;k<=lcs;k++){
           System.out.print(lcsArr[k]);
       }

    }

}
