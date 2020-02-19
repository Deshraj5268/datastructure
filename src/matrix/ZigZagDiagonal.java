package matrix;

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

    public static void main(String[] args) {
        int [][] mat = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        zigzagDiagonalPrint(mat,mat.length);
    }
}
