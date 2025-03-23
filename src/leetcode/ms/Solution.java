package leetcode.ms;

import java.util.Arrays;

public class Solution {
    public static int solution(int[] X, int[] Y) {
       /* // Combine X and Y coordinates of trees into pairs
        int n = X.length;
        int[][] trees = new int[n][2];
        for (int i = 0; i < n; i++) {
            trees[i][0] = X[i];
            trees[i][1] = Y[i];
        }

        // Sort the trees based on their X coordinates
        Arrays.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));

        int maxWidth = 0;

        // Iterate through adjacent trees to find the maximum width
        for (int i = 1; i < n; i++) {
            int width = trees[i][0] - trees[i - 1][0] - 1;
            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;*/

        int widestPath = 0;
        Arrays.sort(X);
        for (int i = 0; i < X.length - 1; i++) {
            widestPath = Math.max(widestPath, X[i + 1] - X[i]);
        }
        return widestPath;
    }

    public static void main(String[] args) {
        int[][] X = {{4,1,5,4},{6,10,1,4,3},{5,5,5,7,7,7}};
        int [][] Y = {{4,5,1,3},{2,5,3,1,6},{3,4,5,1,3,7}};// --> 1
       for(int i=0;i<X.length;i++) {
           System.out.print(solution(X[i], Y[i]) +" "); // Output: 2
       }
    }
}
