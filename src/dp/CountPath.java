package dp;

public class CountPath {

    private static int[][] memoization;

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int result = countPath(m,n);
        System.out.println(result);
        System.out.println(countPathTabBottomUp(m,n));
        memoization = new int[m][n];
        System.out.println(countPathMemoization(m-1,n-1));
    }

    /*
    * 2^(n+M)
    * */
    private static int countPath(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }
        return countPath(m,n-1)            // right in matrix
                + countPath(m-1,n);       // down in matrix
                //countPath(m-1,n-1) // diagonal
    }

    /*
    * LCS pattern forming in recursive formula
    * */
    private static int countPathTabBottomUp(int m,int n){
        int [][] tab = new int[m][n];
        // 1 wat to reach m row and 0th column
        for(int i=0;i<m;i++){
            tab[i][0] = 1;
        }
        //1 wat to reach 0 row and nth column
        for(int j=0;j<n;j++){
            tab[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                tab[i][j] = tab[i][j-1]+tab[i-1][j];
            }
        }
        return tab[m-1][n-1];
    }
    private static int countPathMemoization(int m,int n){
        if(m == 0 || n == 0){
            return 1;
        }
        if(memoization[m][n] != 0){
            return memoization[m][n];
        }
        memoization[m][n-1] = countPathMemoization(m,n-1);
        memoization[m-1][n] = countPathMemoization(m-1,n);
        memoization[m][n] = memoization[m][n-1]+memoization[m-1][n];
        return memoization[m][n];
    }
}
