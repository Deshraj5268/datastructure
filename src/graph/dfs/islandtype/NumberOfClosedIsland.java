package graph.dfs.islandtype;

import static leetcode.topinterviewquestion150.Utils.printMatrix;


//https://leetcode.com/problems/number-of-closed-islands/
public class NumberOfClosedIsland {

    public static void main(String[] args) {

        int [][][] grids = {
                {       {1,1,1,1,1,1,1,0},
                        {1,0,0,0,0,1,1,0},
                        {1,0,1,0,1,1,1,0},
                        {1,0,0,0,0,1,0,1},
                        {1,1,1,1,1,1,1,0}
                }  ,
                {       {0,0,1,0,0},
                        {0,1,0,1,0},
                        {0,1,1,1,0}
                },

                {       {1,1,1,1,1,1,1},
                        {1,0,0,0,0,0,1},
                        {1,0,1,1,1,0,1},
                        {1,0,1,0,1,0,1},
                        {1,0,1,1,1,0,1},
                        {1,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1}}

        };

        NumberOfClosedIsland numberOfClosedIsland = new NumberOfClosedIsland();

        for(int [][] grid : grids){
            System.out.println("original matrix :");
            printMatrix(grid);
            int count = numberOfClosedIsland.closedIsland(grid);
            System.out.println(count);
            System.out.println("converted matrix :");
            printMatrix(grid);
        }
    }

    public int closedIsland(int[][] grid) {

        int closedIslandCount = 0;
        int [][] direction = {{-1,0},{0,-1},{0,1},{1,0}};
        int m = grid.length;
        int n = grid[0].length;
        //marked boundaries 0 --> -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && isBoundary(i, j , m, n)){
                    dfsWithMarker(grid, i, j , m ,n , direction, -1);
                }
            }
        }

        //
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && !isBoundary(i, j , m, n)){
                    dfsWithMarker(grid, i, j , m ,n , direction, -2);
                    closedIslandCount++;
                }
            }
        }

        // get the original if wanted
        return closedIslandCount;
    }

    private static boolean isBoundary(int i, int j, int m, int n) {
        return i == 0 || j == 0 || i >= m - 1 || j >= n - 1;
    }

    private void dfsWithMarker(int[][] grid, int i, int j, int m, int n, int[][] direction, int marker) {
        grid[i][j] = marker;
        int newRow;
        int newCol;
        for (int k = 0; k < direction.length; k++) {
            newRow = i + direction[k][0];
            newCol = j + direction[k][1];
            if(!isSafe(newRow, newCol, m, n) && grid[newRow][newCol] == 0){
                dfsWithMarker(grid,newRow, newCol,m ,n, direction, marker);
            }
        }
    }

    private static boolean isSafe(int i, int j, int totalRows, int totalCols) {
        return (i < 0 || j < 0 || i >= totalRows || j >= totalCols);
    }
}
