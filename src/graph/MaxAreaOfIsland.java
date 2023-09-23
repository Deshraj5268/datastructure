
package graph;




/*
* https://leetcode.com/problems/max-area-of-island/description/
* 695. Max Area of Island

 * */

public class MaxAreaOfIsland {

    static class Counter{
        int count=0;
    }
    static int [] row = {-1,0,0,1};
    static int [] col = {0,-1,1,0};// 4 dir
    public static void main(String[] args) {
        int [][][] mat = {
                { {1,1,0,1},
                        {0,0,1,0},
                        {1,1,0,1},
                        {1,1,0,1}
                },
                {{1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}},
                        {{0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}}
        };
        for(int i=0;i<mat.length;i++) {
            int maxArea = maxAreaOfIsland(mat[i]);
            System.out.println("max area in 2D matrix :" + maxArea);
            System.out.println("second way : "+maxAreaOfIslandSecondWay(mat[i]));
        }
    }



    public static int maxAreaOfIslandSecondWay(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] visited = new boolean[m][n];
        int maxArea = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int count = dfs(grid,i,j,m,n,visited,4);
                    if(maxArea < count){
                        maxArea = count;
                    }
                }
            }
        }
        return maxArea;
    }

    public static  int moves(int [][] grid,int r,int c,int m,int n){

        if(!isSafe(r,c,m,n) || grid[r][c] != 1){
            return 0;
        }
        return 1 + moves(grid,r,c+1,m,n) + // right
                moves(grid,r+1,c,m,n); // down
    }



    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] visited = new boolean[m][n];
        int maxArea = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int count = dfs(grid,i,j,m,n,visited,4);
                    if(maxArea < count){
                        maxArea = count;
                    }
                }
            }
        }
        return maxArea;
    }

    public  static int dfs(int [][] grid,int r,int c,int m,int n, boolean [][] visited,int direction){
        visited[r][c] = true;
        int onesCounter = 1;
        for(int k=0;k<direction;k++){ //  direction
            int nRow = row[k]+r;
            int nCol = col[k]+c;
            if(isSafe(nRow,nCol,m,n) && grid[nRow][nCol] == 1 && !visited[nRow][nCol]){
                onesCounter += dfs(grid,nRow,nCol,m,n,visited,direction);
            }
        }
        return onesCounter;
    }
    public static boolean isSafe(int row,int col,int m,int n){
        return ((row >-1 && row < m) &&(col >-1 && col < n));
    }
}
