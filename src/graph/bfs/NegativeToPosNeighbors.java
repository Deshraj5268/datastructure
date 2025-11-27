package graph.bfs;


import java.util.LinkedList;
import java.util.Queue;

import static graph.dfs.islandtype.MaxAreaOfIsland.isSafe;
import static leetcode.topinterviewquestion150.Utils.printMatrix;

// asked in amazon -- similar to rotten orange
/*
*
* You are given a matrix of integers (both positive and negative).
Each pass, you can convert any negative number to positive if it has at least one positive neighbor (top, bottom, left, or right).

You need to find the minimum number of passes required to convert all negatives to positives.

If some negatives can never become positive (no positive neighbor ever), return -1.
* */
public class NegativeToPosNeighbors {

    public static void main(String[] args) {

        int [][][] grids = {
                {
                        {0, -10, -4},
                        {-3, 5, 0},
                        {-9, -3, 0}
                },

                {
                        {1, -2, -3}
                },
                {
                        {-1, -2, 5}
                },
                {
                        {-5, -3, -2},
                        {-1,  0,  0},
                        {-4, -6, -7}
                },
                {
                        {-5,  1, -7},
                        {-8, -9, -4},
                        {-3, -2, -1}
                }


        };

        NegativeToPosNeighbors negativeToPosNeighbors = new NegativeToPosNeighbors();
        for(int [][] grid : grids){
            System.out.println("original matrix :");
            printMatrix(grid);
            int count =  negativeToPosNeighbors.minPassesToConvert(grid);
            System.out.println(count);
            System.out.println("converted matrix :");
            printMatrix(grid);
        }
    }


    /*
     * rotten orange
     *multi bfs
     * add all positive element in queue
     * traverse all and convert neighbors to positive
     * and increment the pass
     *
     * */
    public static int minPassesToConvert(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        Queue<Cell> queue = new LinkedList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > 0) {
                    queue.add(new Cell(i, j));
                }
            }
        }

        int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int minPasses = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean isChanged = false;
            for (int i = 0; i < size; i++) {
                Cell cell = queue.poll();
                for (int[] dir : direction) {
                    int newRow = cell.r + dir[0];
                    int newCol = cell.c + dir[1];
                    if (isSafe(newRow, newCol, rows, cols) && matrix[newRow][newCol] < 0) {
                        matrix[newRow][newCol] = -1 * matrix[newRow][newCol];
                        queue.add(new Cell(newRow, newCol));
                        isChanged = true;
                    }
                }
            }
            if (isChanged) {
                minPasses++;
            }
        }

        // Step 3: Check if any negatives remain
        for (int[] row : matrix){
            for (int val : row) {
                if (val < 0) {
                    return -1;
                }
            }
        }

        return minPasses;
    }


}
