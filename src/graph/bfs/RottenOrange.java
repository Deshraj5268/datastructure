package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

import static leetcode.topinterviewquestion150.Utils.printMatrix;


//https://leetcode.com/problems/rotting-oranges/
// https://www.youtube.com/watch?v=y704fEOx0s0
public class RottenOrange {

    public static void main(String[] args) {
        int [][][] grids = {{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        },
                {       {2,1,1},
                        {0,1,1},
                        {1,0,1}},
                {{0,2}},

                {       {2,0,0,2},// multi bfs
                        {1,1,1,1},
                        {0,0,1,1}
                }
        };

        RottenOrange rottenOrange = new RottenOrange();
        for(int [][] grid : grids){
            System.out.println("original matrix :");
            printMatrix(grid);
            int count = rottenOrange.orangesRotting(grid);
            System.out.println(count);
            System.out.println("converted matrix :");
            printMatrix(grid);
        }
    }

    /*
     * multi source bfs
     * queued all the rotten orange and make rotten all the fresh orange
     * */
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        int time = 0;
        Queue<Cell> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 1){
                    freshCount++;
                }
                if(grid[i][j] == 2){
                    queue.add(new Cell(i,j));
                }
            }
        }

       // queue.add(null);// marker / level
        int [][] direction = {{-1,0},{0,-1},{0,1},{1,0}};

        while (!queue.isEmpty() && freshCount > 0){ // level order traversal
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                    Cell currentNode = queue.poll();
                    for (int [] dir : direction) {
                        int x = currentNode.r+dir[0];
                        int y = currentNode.c+dir[1];
                        if(!isSafe(x,y,rows,cols) && grid[x][y] == 1){ // fresh
                            grid[x][y] = 2;
                            queue.add(new Cell(x ,y));
                            freshCount--;
                        }
                    }
                }
                time++;
            }
        return freshCount == 0 ? time: -1;
    }

    public boolean isSafe(int i, int j, int m, int n){
        return (i<0 || j < 0 || i >= m || j >= n);
    }
}

