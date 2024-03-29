package arrays.sortingsearching.mergesortapps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntersectionInMatrix {
    public static void main(String[] args) {

        /*int [][] mat = new int[3][];
        mat[0] = new int[]{3,1,2,4,5};
        mat[1] = new int[]{1,2,3,4};
        mat[2] = new int[]{3,4,5,6};
*/
        int [][] mat = new int[2][];
        mat[0] = new int[]{1,2,3};
        mat[1] = new int[]{4,5,6};


        List<Integer> result = intersectionInMatrix(mat);
        result.stream().forEach(x-> System.out.print(x + " "));
    }

    public static List<Integer> intersectionInMatrix(int [][] matrix){
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int [] colIndexArr = new int[m];
        int minRow = 0;

        // sort all rows
        for(int i=0;i<m;i++){
            Arrays.sort(matrix[i]);
            colIndexArr[i] = matrix[i].length-1;
        }

        while (colIndexArr[minRow]>=0){

            //find minRow of minElement
            for(int row =0;row<m;row++){
                if(matrix[row][colIndexArr[row]] < matrix[minRow][colIndexArr[minRow]]){
                    minRow = row;
                }
            }

            // decrease the colIndex if value is greater than minRow
            int eqCount = 0;
            for(int row=0;row<m;row++){
                if(matrix[minRow][colIndexArr[minRow]] < matrix[row][colIndexArr[row]]){
                    if(colIndexArr[row] <= 0){
                        Collections.sort(result);
                        return result;
                    }colIndexArr[row] -= 1;
                }else {
                    eqCount++;
                }
            }
            if(eqCount == m){
                result.add(matrix[minRow][colIndexArr[minRow]]);
                for(int i=0;i<colIndexArr.length;i++){
                    if(colIndexArr[i] <= 0){
                        Collections.sort(result);
                        return result;
                    }
                    colIndexArr[i]--;
                }

            }
        }
        Collections.sort(result);
        return result;
    }
}
