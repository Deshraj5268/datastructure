package matrix;

public class PrintDiagonal {

    private static boolean isValidIndex(int m,int n,int i,int j){
        if(i<0 || i >= m || j<0 || j >= n){
            return false;
        }
        return true;
    }

    private static void printDiagonalUpward(int [][]mat,int m,int n,int i,int j){
        while (isValidIndex(m,n,i,j)){
            System.out.print(mat[i][j]+" ");
            i--;
            j++;//upward
        }
        System.out.println();
    }

    public static void printMatrixUpwardDiagonally(int [][]mat,int m,int n){

        int i;
        int j;
        for(int k=0;k<m;k++){
            System.out.print(mat[k][0] +" ");
            i = k-1;
            j = 1;
            printDiagonalUpward(mat,m,n,i,j);
        }
        for (int k = 1;k<n;k++){
            System.out.print(mat[m-1][k]+" ");
            i = m-2;//second last row
            j = k+1;
            printDiagonalUpward(mat,m,n,i,j);
        }
    }

    public static void main(String[] args) {
        int [][]mat = { {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}, };
        printMatrixUpwardDiagonally(mat,mat.length,mat[0].length);
    }
}
