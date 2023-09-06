package leetcode.topinterviewquestion150;

public class Utils {

    private Utils(){

    }

    public static void printMatrix(int [][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
