package matrix;

public class MatrixRotation {

    /*
    * transpose matrix -- then rotate row wise will get clock wise rotation
    * if we do column wise rotation will get anti clock wise rotation
    * */

    public static void rotateMatrixByAntiClockwise(int [][] matrix, int n){
        transposeMatrix(matrix,n);
        for(int column = 0;column<n;column++) {
            reverseColumn(matrix,column,n-1);
        }
    }

    private static void transposeMatrix(int [][] matrix, int n){
        //top left corner transpose of matrix first row --> column
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                swapMatrix(matrix,i,j);
            }
        }
    }

    public static void rotateMatrixByClockwise(int [][] matrix, int n){
        transposeMatrix(matrix,n);
        for(int row=0;row<n;row++) {
            reverseRow(matrix,row,n-1);
        }
    }

    private static void reverseRow(int[][] matrix, int row, int n) {
        int i = 0;
        int temp;
        while(i<n){
            temp = matrix[row][i];
            matrix[row][i] = matrix[row][n];
            matrix[row][n] = temp;
            i++;
            n--;
        }
    }

    private static void reverseColumn(int[][] matrix, int column, int n) {
        int i = 0;
        int temp;
        while(i<n){
            temp = matrix[i][column];
            matrix[i][column] = matrix[n][column];
            matrix[n][column] = temp;
            i++;
            n--;
        }
    }

    public static void printMatrix(int[][] matrix, int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }
    public static void printMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static void swapMatrix(int [][]matrix,int i,int j){
        int temp = matrix[j][i];
        matrix[j][i] = matrix[i][j];
        matrix[i][j] = temp;
    }


    /*
    * one more solution
    * 1. Reverse all the columns
    * 2. Reverse All the rows
    * */
    static void rotateMatrix180(int[][] mat,int N) {
        for(int i=0;i<N/2;i++) {
            for(int j=0;j<N;j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[N-i-1][N-j-1];
                mat[N-i-1][N-j-1] = temp;
            }
        }
        if(N % 2 == 1){
            reverseRow(mat,N/2,N-1);
        }
    }

    public static void main(String[] args) {

        int [][] matrix = { {1,2,3},
                            {4,5,6},
                            {7,8,9}
                            };
        System.out.println("original matrix : ");
        printMatrix(matrix,matrix.length);
        rotateMatrixByAntiClockwise(matrix,matrix.length);
        System.out.println("90 degree anti clock-wise rotated matrix : ");
        printMatrix(matrix,matrix.length);

        int [][] matrix2 = { {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        rotateMatrixByClockwise(matrix2,matrix2.length);
        System.out.println("90 degree clock-wise rotated matrix : ");
        printMatrix(matrix2,matrix2.length);


        int [][] matrix3 = { {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        System.out.println("180 degree clock-wise rotated matrix : ");
        rotateMatrix180(matrix3,matrix3.length);
        printMatrix(matrix3,matrix3.length);

    }
}
