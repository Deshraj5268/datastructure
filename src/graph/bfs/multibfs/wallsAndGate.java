package graph.bfs.multibfs;

/*
* problem
*
* DESCRIPTION
You have a grid representing a floor plan with rooms, walls, and gates.
The grid is an m x n matrix where each cell contains one of three values:

-1 → a wall or obstacle that cannot be passed through
0 → a gate
INF (which is 2^31 - 1, also referred to as INF) → an empty room
You are tasked to fill each empty room with its shortest distance to the nearest gate.

Distance is measured as the minimum number of steps needed to reach a gate.
Movement is only allowed horizontally or vertically (not diagonally).
If an empty room cannot reach any gate (blocked by walls), it should remain INF.
* */

/*
* good explanation : https://www.youtube.com/watch?v=e69C6xhiSQE
* */

import java.util.LinkedList;
import java.util.Queue;

public class wallsAndGate {

    static int [][] dirs = {{-1, 0},
                            {0, -1}, {0, 1},
                            {1, 0}}; // 4 dir

   static int INF = 2147483647;
    public static void main(String[] args) {

        int [][][] matArr = {
                {
                        {INF,-1,0,INF},
                        {INF,INF,INF,-1},
                        {INF,-1,INF,-1},
                        {0,-1,INF,INF}
                },
                {
                        {0,-1},
                        {INF,INF}
                }
        };


        for (int i = 0; i < matArr.length; i++) {
            System.out.println("input ");
            printMatrix(matArr[i]);
            mindDisBetweenWallsAndGates(matArr[i]);
            System.out.println("output ");
            printMatrix(matArr[i]);
        }

    }

    /*
    * multi BFS
    *
    * put all gates in queue ( val == 0)
    * distance = 1
    *  iterate  until queue is not empty
    *
    *   all the queue of size ( level)
    *     pic the node and traverse all 4 direction
    *       if(safe and val is INF)
    *       update = distance
    *
    *    distance++;
    * */
    public static void mindDisBetweenWallsAndGates(int [][] mat){
        int m = mat.length;
        int n = mat[0].length;
        Queue<Cell> queue = new LinkedList<>();
        int distance = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 0){
                    queue.add(new Cell(i, j));
                }
            }
        }
        int size;
        Cell cell;
        int newR, newC;
        while (!queue.isEmpty()){
         size = queue.size();

            for (int s = 0; s < size; s++) {
                cell = queue.poll();

                for (int d = 0; d < dirs.length; d++) {
                    newR = cell.r + dirs[d][0];
                    newC = cell.c + dirs[d][1];
                    if(isSafe(m,n,newR, newC) && mat[newR][newC] == INF){
                        mat[newR][newC] = distance;
                        queue.add(new Cell(newR, newC));
                    }
                }
            }
            distance++;
        }
    }

    public static boolean isSafe(int m, int n,int i, int j){
        return  !(i<0 || j < 0 || i >= m || j >= n);
    }

    private static void printMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int c = 0;
        int r = 0;
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
