package matrix;


/* asked in agoda
* Find the number of unique paths from (0,0) to (n-1,m-1) in a grid with obstacles (1 = blocked, 0 = free).
The robot can move only right or down.
* */
public class RobotPaths {

    public static void main(String[] args) {
        int [][][] grids = getGrids();

        for(int i=0;i<grids.length;i++){
            System.out.println("brute force :"+uniquePathsWithObstaclesRec(grids[i], 0, 0));
            System.out.println("using DP : "+uniquePathsWithObstaclesDP(grids[i]));
        }

    }

    private static int[][][] getGrids() {
        int [][][] grids  =   {
            {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
            },
            {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
            },
                {
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 1}
                },
                {
                        {0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0}
                }
        };
        return grids;
    }

    public static int uniquePathsWithObstaclesRec(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if(i >= m || j >= n || grid[i][j] == 1){ // if out off boundary or value is 1
            return 0;
        }

        if(i == n-1 && j == m-1){
            return 1;
        }

        int rightPathCount = uniquePathsWithObstaclesRec(grid, i, j+1);
        int downPathCount = uniquePathsWithObstaclesRec(grid, i+1, j);
        return rightPathCount + downPathCount;
    }

    public static int uniquePathsWithObstaclesDP(int [][] grid){
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return 0;
        }
        int [][] dp = new int[m][n];

        // first col filling
        dp[0][0] = 1;
        for(int col=1;col<m;col++){
           /* if(grid[0][col] == 0){ // non block
                dp[0][col] = dp[0][col-1];
            }else {
                grid[0][col] = 0;
            }*/
            dp[0][col] = grid[0][col] == 0 ? dp[0][col-1] : 0; // first row with 1
        }
        // first row and  filling
        for(int row=1;row<n;row++){
            dp[row][0] = grid[row][0] == 0 ? dp[row-1][0] : 0;
        }

        for (int row = 1;row<m;row++){
            for (int col = 1;col<n;col++){
                if(grid[row][col] == 0){
                    dp[row][col] = dp[row-1][col] + dp[row][col-1]; //
                }else { // obstacle
                    dp[row][col] = 0;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
