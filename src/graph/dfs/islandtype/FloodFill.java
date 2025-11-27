package graph.dfs.islandtype;

public class FloodFill {

    public static void main(String[] args) {
        int [][] mat = {{4},
                {5},
                {4},
                {2},
                {4},
                {9},
                {9},
                {9},
                {4},
                {9},
                {8}};
        int x=9;
        int y=0;
        int newColor = 52;
        FloodFill floodFill = new FloodFill();
        System.out.println("input mat ");
        floodFill.printMatrix(mat,0,0,mat.length,mat[0].length);
        floodFill.floodFill(mat,mat.length,mat[0].length,x,y,newColor,false);
        System.out.println("\n output mat ");
        floodFill.printMatrix(mat,0,0,mat.length,mat[0].length);

    }

    private void printMatrix(int[][] mat, int r, int c, int m, int n) {
        int c1=c;
        int r1=r;
        while (r1<m){
            c1 = 0;
            while (c1<n){
                System.out.print(mat[r1][c1] +" ");
                c1++;
            }
            System.out.println();
            r1++;
        }
    }

    private void floodFill(int [][] mat,int m,int n,int x,int y,int futureColorValue,boolean needOriginalMat) {

        if (!isSafeMatrixCell(m, n, x, y)) {
            return;
        }
        int[] rowNumber = { -1, 0, 0, 1};
        int[] colNumber = { 0, -1, 1, 0};
        int direction=4;
        int currentColorValue = mat[x][y];
        /*
        *
        * [[0,0,0],[0,1,1]]
          1
          1
          1*/
        if(currentColorValue == futureColorValue){
            return ;
        }
        dfsM2(mat, m, n, x, y, rowNumber, colNumber, currentColorValue,futureColorValue,direction);
    }


    private void dfsM2(int[][] mat, int m, int n, int r, int c,int [] rowNumber,int [] colNumber,int currentColorValue,int futureColorValue,int direction) {
        mat[r][c] = futureColorValue;
        int newR = r;
        int newC = c;
        for(int i=0;i<direction;i++){
            newR = r+rowNumber[i];
            newC = c+colNumber[i];
            if(isSafeMatrixCell(m,n,newR,newC) && (mat[newR][newC] == currentColorValue)){
                dfsM2(mat,m,n,newR,newC,rowNumber,colNumber,currentColorValue,futureColorValue,direction);
            }
        }
    }

    public boolean isSafeMatrixCell(int m, int n, int r, int c) {
        return ((r > -1 && r < m) && (c > -1 && c < n));
    }
}
