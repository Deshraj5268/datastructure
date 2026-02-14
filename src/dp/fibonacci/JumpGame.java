package dp.fibonacci;


import java.util.Arrays;

/*
 *
 * https://www.enjoyalgorithms.com/blog/minimum-number-of-jumps-to-reach-end
 * */
public class JumpGame {

    public static void main(String[] args) {
        int [][] mat = {{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 },
                {3,2,2,1,4,5},
                {0,2,2,1,4,5},
                {2,3,0,1,4},
                {2,3,1,1,4}
        };

        for (int i = 0; i < mat.length; i++) {
            System.out.println("input : "+ Arrays.toString(mat[i]));
            int result = minJumpSolRec(mat[i], 0, mat[i].length);
            System.out.println("recursive :" + result);

            // dp top down - memoization
            int [] dp = new int[mat[i].length];
            //Arrays.fill(dp , -1);
            result = minJumpDPMemoization(mat[i], 0, mat[i].length, dp);
            System.out.println("using topDown - memoization : "+ result);
        }
    }

    /* [3,2,2,1,4,5] ->  ( 3->2->4->5=== 3 jump --> f(0, 5)
     * if [n,n,n,n,n,n] every time n possibility O(n^n) complexity
     *                          f(0)
                                ├── f(1)
                                │   ├── f(2)
                                │   │   ├── f(3)
                                │   │   │   └── f(4)
                                │   │   │       └── f(5) = 0
                                │   │   └── f(4)
                                │   │       └── f(5) = 0
                                │   └── f(3)
                                │       └── f(4)
                                │           └── f(5) = 0
                                ├── f(2)
                                │   ├── f(3)
                                │   │   └── f(4)
                                │   │       └── f(5) = 0
                                │   └── f(4)
                                │       └── f(5) = 0 [3-->2-->4-->5]
                                └── f(3)
                                    └── f(4)
                                        └── f(5) = 0 [3-->1-->4-->5]

     *
     * */
    public static int minJumpSolRec(int[] arr, int start, int end) {
        if(start >= end){
            return 0;
        }
        int minJumpCount = Integer.MAX_VALUE;
        for(int i = 1; i <= arr[start] && i < end; i++){
            int jumpCount = 1 + minJumpSolRec(arr, start+i , end);

            if(jumpCount < minJumpCount){
                minJumpCount = jumpCount;
            }
        }
        return minJumpCount;
    }

    public static int minJumpDPMemoization(int [] arr, int start, int end, int [] dp){
        if(start >= end){
            return 0;
        }
        if(dp[start] != 0){
            return dp[start];
        }
        int minJumpCount = Integer.MAX_VALUE;
        for(int i = 1; i <= arr[start] && i < end; i++){
            int jumpCount = 1 + minJumpDPMemoization(arr, start+i , end, dp);

            if(jumpCount < minJumpCount){
                minJumpCount = jumpCount;
            }
        }
        return dp[start] = minJumpCount;
    }
}
