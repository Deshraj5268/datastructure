package matrix;

import java.util.*;

/*
* https://www.youtube.com/watch?v=-FEeaf3ufIE
* https://www.youtube.com/watch?v=IDxaZrrggu0
* */
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


       /*
    *   rowCount = number of rows
        columnCount = number of columns
        Then, number of diagonals will be = rowCount + columnCount - 1
        * Step 1 Details: Print first rowCount diagonals
Iterate to print diagonals from row k = 0 to rowCount - 1.
1: Start with row = k and col = 0
2: Print the element matrix[row][col]
3: Decrement row by 1 Increment col by 1 till row greater than or equal to 0 and  col less than columnCount

Step 2 Details: Print next columnCount – 1 diagonals
Iterate to print diagonals from column k = 1 to columnCount - 1
1: Start with last row, row = rowCount – 1 and col = k
2: Print the element matrix[row][col]
3: Decrement row by 1 Increment col by 1till row greater than or equal to 0 and  col less than columnCount

    * */

    public static void printMatrixDiagonally(int [][] matrix){
        if(matrix == null || matrix.length == 0){
            return;
        }
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        //print first upper part wor counts
        for(int k=0;k<rowCount;k++){
            for(int row=k,col=0; row>=0 && col<colCount; row--,col++){
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
        for (int k=1;k<colCount;k++){
            for(int row=rowCount-1,col=k; row>=0 && col <colCount;row--,col++){
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }

    }



    /*
    * matrix
    *  [1 2 3]
    *  [4 5 6]
    *  [7 8 9]
    *
    * every cell calculate = row+col
    * [(0+0) (0+1) (0+2)]  --> [0,1,2]
    * [(1+0) (1+1) (1+2)]  --> [1,2,3]
    * [(2+0) (2+1) (2+2)]  --> [2,3,4]
    *
    * create hashmap
    * 0-> 1
    * 1->2,4
    * 2->3,5,7
    * 3->6,8
    * 4->9
    * */
    public static void printMatrixDiagonallyUsingHashMap(int [][] matrix){
        if(matrix == null || matrix.length == 0){
            return;
        }
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

       Map<Integer, List<Integer>> diagonalMatrixMap = new HashMap<>();
       List<Integer> diagonalElements;
       int rowColSum;
       for(int i=0;i<rowCount;i++){
           for(int j=0;j<colCount;j++){
               rowColSum = i+j;

             /*  diagonalElements = diagonalMatrixMap.get(rowColSum);
               if(diagonalElements == null){
                   diagonalElements = new ArrayList<>();
                   diagonalMatrixMap.put(rowColSum,diagonalElements);
               }
               diagonalElements.add(matrix[i][j]);*/

               diagonalElements = diagonalMatrixMap.computeIfAbsent(rowColSum, k -> new ArrayList<>());
               diagonalElements.add(matrix[i][j]);
           }
       }
       //print matrix
        for (Map.Entry<Integer,List<Integer>> entry:diagonalMatrixMap.entrySet()){
            entry.getValue().forEach(x-> System.out.print(x+" "));
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int [][] [] mat ={ { {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}},
                {{1}, {2}},
                {  {1,2,3,4}},
                {{1,2},{3,4},{5,6}}

        };
        //  printMatrixUpwardDiagonally(mat,mat.length,mat[0].length);


        System.out.println("simple way to print diagonal of matrix");
        for (int i=0;i<mat.length;i++) {
            System.out.println("input matrix : ");
            for (int j=0;j<mat[i].length;j++){
                System.out.println(Arrays.toString(mat[i][j]));
            }
            System.out.println("output ");
            printMatrixDiagonally(mat[i]);
        }

        System.out.println("using hashMap diagonal of matrix");
        for (int i=0;i<mat.length;i++) {
            System.out.println("input matrix : ");
            for (int j=0;j<mat[i].length;j++){
                System.out.println(Arrays.toString(mat[i][j]));
            }
            System.out.println("output ");
            printMatrixDiagonallyUsingHashMap(mat[i]);
        }
    }
}
