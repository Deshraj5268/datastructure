package graph;

public class IslandProblem {

    //use for 8 direction movement (like complete 1 row and 3 column)
    int [] rowNumber = {-1,-1,-1,0,0,1,1,1};
    int [] colNumber = {-1,0,1,-1,1,-1,0,1};

    boolean [][]visited;

    public static void main(String[] args) {
        int [][] mat = {
                {1,1,0,1},
                {0,0,1,0},
                {1,1,0,1},
                {1,1,0,1}
        };/*{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};*/
        int m = mat.length;
        int n = mat[0].length;
        IslandProblem islandProblem = new IslandProblem();
        int totalIsland = islandProblem.countNumberOfIslandM1(mat,m,n,0,0);
        System.out.println("total island in 2D matrix :"+totalIsland);
        totalIsland = islandProblem.countNumberOfIslandM2(mat,m,n,0,0);
        System.out.println("total island in 2D matrix WO Extra space :"+totalIsland);
    }

    /* Algo
    * traverse the matrix
    * if cell value =1 and cell is not visited
    * check cell value in 8 direction recursively
    * islandCount++
    * TM O(n^2) SC O(n^2)
    * */
    public int countNumberOfIslandM1(int [][] mat,int m,int n,int i,int j){
        visited = new boolean[m][n];
        int islandCount = 0;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(mat[r][c] == 1 && !visited[r][c]){
                    dfs(mat,m,n,r,c);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    /* Algo
    * Use same matrix for visited track
    * traverse the matrix
    * if cell value =1
    *   check cell value in 8 direction recursively ( also modify cell =-1)
    *   islandCount++
    *   restore mat cell value to 1
    *
    * TM O(n^2) SC O(1)
    * */
    public int countNumberOfIslandM2(int [][] mat,int m,int n,int i,int j){
        int islandCount = 0;
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(mat[r][c] == 1){
                    dfsM2(mat,m,n,r,c);
                    islandCount++;
                    mat[r][c] = 1; // to reset 1 to count again 1 is original matrix otherwise all 1 became -1
                }

            }
            /*System.out.println("print one");
            printMatrix(mat,0,0,m,n);*/

        }
        return islandCount;
    }

    private void dfsM2(int[][] mat, int m, int n, int r, int c) {
        mat[r][c] = -1;
        int newR = r;
        int newC = c;
        for(int i=0;i<8;i++){
            newR = r+rowNumber[i];
            newC = c+colNumber[i];
            if(isSafeMatrixCell(mat,m,n,newR,newC) && (mat[newR][newC] == 1)){
               // mat[newR][newC] = -1;
                dfsM2(mat,m,n,newR,newC);
            }
        }
    }

    private void dfs(int[][] mat, int m, int n, int r, int c) {
        visited[r][c] = true;
        int newR = r;
        int newC = c;
        for(int i=0;i<8;i++){
            newR = r+rowNumber[i];
            newC = c+colNumber[i];
            if(isSafeMatrixCell(mat,m,n,newR,newC) && (mat[newR][newC] == 1 && !visited[newR][newC])){
                dfs(mat,m,n,newR,newC);
            }
        }
    }

    private boolean isSafeMatrixCell(int[][] mat, int m, int n, int r, int c) {
        return ((r > -1 && r < m) && (c > -1 && c < n));
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
}
