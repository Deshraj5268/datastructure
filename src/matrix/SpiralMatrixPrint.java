package matrix;

public class SpiralMatrixPrint {

    public static void printSpiralMatrix(int [][] mat,int startRow,int endRow,int startCol,int endCol){

        int i;
        while((startRow < endRow) && (startCol < endCol)){

            for(i=startCol;i<endCol;i++){
                System.out.print(mat[startRow][i]+" ");
            }
            System.out.println();
            startRow++; //increase row count

            for (i=startRow;i<endRow;i++){
                System.out.print(mat[i][endCol-1]+" ");
            }
            System.out.println();
            endCol--;

            //M X 1 case
            if(startRow<endRow) {
                for (i = endCol - 1; i >= startCol; i--) {
                    System.out.print(mat[endRow - 1][i] + " ");
                }
                System.out.println();
                endRow--;
            }
            //1 X N
            if(startCol<endCol) {
                for (i = endRow - 1; i >= startRow; i--) {
                    System.out.print(mat[i][startCol] + " ");
                }
                startCol++;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int [][]mat = { { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 } };
        int startRow = 0;
        int startCol = 0;
        int m = mat.length;
        int n = mat[0].length;
        printSpiralMatrix(mat,startRow,m,startCol,n);

        //M X 1 matrix
        System.out.println("M X 1 matrix");
        int [][]mat1 = { { 1 },
                { 7},
                { 13} };
        startRow = 0;
        startCol = 0;
        m = mat1.length;
        n = mat1[0].length;
        printSpiralMatrix(mat1,startRow,m,startCol,n);

        System.out.println("1 X N ");
        //1 X N
        int [][]mat2 = { { 1, 2, 3, 4, 5, 6 }
        };

        startRow = 0;
        startCol = 0;
        m = mat2.length;
        n = mat2[0].length;
        printSpiralMatrix(mat2,startRow,m,startCol,n);
    }
}
