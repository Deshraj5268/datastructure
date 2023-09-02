package matrix;

import java.util.Arrays;


/*
*
* https://leetcode.com/problems/matrix-diagonal-sum/submissions/
* */
public class MatrixDiagonalSum {

    public static void main(String[] args) {
        int [][] [] mat ={ { {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}}

        };

        //square matrix is allowed
        System.out.println("using hashMap diagonal of matrix");
        for (int i=0;i<mat.length;i++) {
            System.out.println("input matrix : ");
            for (int j=0;j<mat[i].length;j++){
                System.out.println(Arrays.toString(mat[i][j]));
            }
            System.out.println("output ");
            diagonalSum(mat[i]);
        }
    }


    /*
    * primary diagonal is i == i , mat[i][i]
    * secondary diagonal(length - currentRow)  i , m-1-i , mat[i][m-1-i]
    * if m is odd then subtract mat[m/2][m/2]
    * */
    public static int diagonalSum(int[][] mat) {
        if(mat == null || mat.length == 0){
            return 0;
        }
        int m = mat.length;
        int sum = 0;
        for(int i=0;i<m;i++){
            sum += mat[i][i]+
                    mat[i][m-1-i];
        }
        return m%2 == 1? sum-mat[m/2][m/2]: sum;
    }
}
