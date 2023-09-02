package matrix;


import java.util.*;

/*
* https://www.youtube.com/watch?v=-FEeaf3ufIE
* https://www.geeksforgeeks.org/print-matrix-in-zig-zag-fashion/
*
*
* */
public class ZigZagDiagonal {

    public static void zigzagDiagonalPrint(int [][] mat,int n){

        int i = 0;
        int j = 0;
        boolean isUp = true;
        for(int k=0;k<n*n;k++){
            if(isUp){
                for(;i>=0 && j < n;i--,j++){
                    System.out.print(mat[i][j]+ " ");
                    k++;
                }
                if(i<0 && j <= n-1){
                    i = 0;
                }
                if(j == n){
                    i = i+2;
                    j = j-1;
                }
            }else{
                for(;j>=0 && i < n;j--,i++){
                    System.out.print(mat[i][j]+ " ");
                    k++;
                }
                if(j < 0 && i <= n-1){
                    j = 0;
                }
                if(i == n){
                    j = j+2;
                    i = i-1;
                }
            }
            isUp = !isUp;
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
     * 1->3,4
     * 2->3,5,7
     * 3->6,8
     * 4->9
     * if rowCount is even then print same order
     * else print in reverse order
     * */
    public static void printMatrixZigZagDiagonallyUsingHashMap(int [][] matrix){
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
                diagonalElements = diagonalMatrixMap.computeIfAbsent(rowColSum,x->new ArrayList<>());
                diagonalElements.add(matrix[i][j]);
            }
        }
        //print matrix
        for (Map.Entry<Integer,List<Integer>> entry:diagonalMatrixMap.entrySet()){
            List<Integer> values = entry.getValue();
            if(entry.getKey() %2 ==1) {
                values.forEach(x -> System.out.print(x + " "));
            }else {
               for(int i=values.size()-1;i>=0;i--) {
                    System.out.print(values.get(i)+ " ");
               }
            }
            System.out.println();
        }

    }
    /*
    * https://leetcode.com/problems/diagonal-traverse/description/
    * https://www.youtube.com/watch?v=-FEeaf3ufIE
    * */

    public int[] findDiagonalOrder(int[][] mat) {

        if(mat == null || mat.length == 0){
            return null;
        }

        Map<Integer,List<Integer>> diagonalMatrixMap = new HashMap<>();
        List<Integer> elements;
        int rowColSum;
        int rowCount = mat.length;
        int colCount = mat[0].length;
        for(int i=0;i<rowCount;i++){
            for(int j=0;j<colCount;j++){
                rowColSum = i+j;
                elements = diagonalMatrixMap.computeIfAbsent(rowColSum,x->new ArrayList<>());
                elements.add(mat[i][j]);
            }
        }
        List<Integer> result = new ArrayList();
        for (int k = 0; k < rowCount + colCount - 1; k++) {
            List<Integer> list = diagonalMatrixMap.get(k);
            if (k % 2 == 0) {
                Collections.reverse(list);
            }
            result.addAll(list);
        }

        return result.stream().mapToInt(x -> x).toArray();
    }



    /*
    *            r == 0 , c++ ( upper case)
    *                 -----------
    *               |           |  c == n-1 , r++ ( upper case)
    * c==0, r++     |           |
    *               ------------
    *                  r == n-1 , c++
    *
    *
    * */
    public int[] findDiagonalOrderOptimize(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];

        int m = matrix.length, n = matrix[0].length, r = 0, c = 0;
        int[] result = new int[m * n];

        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[r][c];

            // even going up ( r-- , c++  )
            if ((r + c) % 2 == 0) {
                if (c == n - 1) { // lower half of matrix r++
                    r++;
                } else if (r == 0) { // upper half of matrix c++
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else {
                if (r == m - 1) {// lower half of matrix c++
                    c++;
                } else if (c == 0) { // upper half of matrix r++
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int [][] mat = { { 1, 2, 3 },
                         { 4, 5, 6 },
                         { 7, 8, 9 } };
        System.out.println("zig diagonal in reverse order : ");
        zigzagDiagonalPrint(mat,mat.length);

        System.out.println("zig diagonal in reverse order using hashmap : ");
        printMatrixZigZagDiagonallyUsingHashMap(mat);
    }
}
