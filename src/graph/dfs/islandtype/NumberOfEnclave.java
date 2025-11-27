package graph.dfs.islandtype;

import java.util.Arrays;

import static graph.dfs.islandtype.MaxAreaOfIsland.isSafe;

//https://leetcode.com/problems/number-of-enclaves/description/
public class NumberOfEnclave {


    public static void main(String[] args) {

        NumberOfEnclave numberOfEnclave = new NumberOfEnclave();

        int [][][] grids = {{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}},

                {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}}

        };
        for(int [][] grid : grids){
            System.out.println("original matrix :");
            printMatrix(grid);
            int count =  numberOfEnclave.numEnclaves(grid);
            System.out.println(count);
            System.out.println("converted matrix :");
            printMatrix(grid);
        }

    }

    private static void printMatrix(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }


    // similar to Surrounded Region also we need to count the number of one's
    public int numEnclaves(int[][] grid) {

        int countEnclaves = 0;
        int [][] direction = {{-1,0},{0,-1},{0,1},{1,0}};
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if(grid[i][j] == 1 && (i==0 || j==0 || i >= m-1 || j >= n-1)){ // 1 and boundary 1 --> -1
                    dfs(grid , i, j , m, n, direction);
                }
            }
        }

        // 1--> 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    countEnclaves++;
                }
            }
        }

        // back to -1--> 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == -1){
                    grid[i][j] = 1;
                }
            }
        }
        return countEnclaves;

    }

    private void dfs(int[][] grid, int i, int j, int m, int n, int[][] direction) {
        grid[i][j] = -1;
        int newRow;
        int newCol;

        for (int [] point : direction) {
            newRow = i+point[0];
            newCol = j+point[1];
            if(isSafe(newRow, newCol, m, n) && grid[newRow][newCol] == 1){
                dfs(grid,newRow, newCol,m,n,direction);
            }
        }
    }
}
