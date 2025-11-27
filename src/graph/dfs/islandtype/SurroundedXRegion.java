package graph.dfs.islandtype;

import java.util.Arrays;


//https://leetcode.com/problems/surrounded-regions/submissions/1837325123/

// https://www.youtube.com/watch?v=yyofzfxWeKk : good explanation
public class SurroundedXRegion {

    static int [][] direction = {{-1,0},{0,-1},{0,1},{1,0}};
    public static void main(String[] args) {

        char [][][] grids = {
                {{'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}
                },
                        {
                                {'X', 'X', 'X', 'O','X'},
                                {'X', 'X', 'X', 'O','X'},
                                {'O', 'O', 'O', 'X','X'},
                                {'X', 'X', 'X', 'O','X'},
                                {'X', 'O', 'O', 'X','X'}
                        }
        };
        for(char [][] grid : grids){
            System.out.println("original matrix :");
            printMatrix(grid);
            surroundedZeroToXNotAtBoundary(grid);
            System.out.println("converted matrix :");
            printMatrix(grid);
        }
    }

    public static void printMatrix(char [][] grid){
        for(char [] gridRow : grid){
            System.out.println(Arrays.toString(gridRow));
        }
    }



    /*
     *
     * [["X","X","X","X"]
     * ["X","O","O","X"]
     * ["X","X","O","X"]
     * ["X","O","X","X"]]
     * */
    /*
     *
     * convert boundary's O to intermediate Char (V) and do dfs like island connected problem other O
     * then remaining O's to X ( like FloodFill problem
     * then convert intermediate V --> O
     * */
    public static void surroundedZeroToXNotAtBoundary(char [][] grid){
        char intermediateFlip = 'V';
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                // boundary o to V using dsf
                if(grid[i][j] == 'O' && (i==0 || j == 0 || i == grid.length-1 || j == grid[i].length-1)){
                    dfs(grid, i , j,intermediateFlip, direction);
                }
            }
        }

        //covert O --> X
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                }
            }
        }
        // original v --> o
        for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 'V'){
                    grid[i][j] = 'O';
                }
            }
        }

    }

    private static boolean isSafe(int i, int j, int totalRows, int totalCols) {
        return (i < 0 || j < 0 || i >= totalRows || j >= totalCols);
    }

    private static void dfs(char[][] grid, int i, int j, char intermediateFlip, int[][] direction) {
        grid[i][j] = intermediateFlip;

        for(int [] points : direction){
            int newRow = points[0]+i;
            int newCol = points[1]+j;
            if(!isSafe(newRow, newCol, grid.length, grid[i].length)
                    && grid[newRow][newCol] == 'O'){
                dfs(grid, newRow, newCol, intermediateFlip, direction);
            }
        }

    }
}
