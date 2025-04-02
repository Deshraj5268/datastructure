package dp.fibonacci;

import java.util.Arrays;

/*
* https://leetcode.com/problems/min-cost-climbing-stairs/
* */
public class MInCostWithClimbingStair {

    public static void main(String[] args) {

        int [][] mat = {
                {10,15,20},
                {1,100,1,1,1,100,1,1,100,1}
        };
        int result;
        for(int i=0;i<mat.length;i++){
            result = minCostClimbingStairs(mat[i]);
            System.out.println("result : "+result);
        }
    }

    public static int minCostClimbingStairs(int[] cost) {
        int firstMin,secondMin;
        firstMin = secondMin = 0;
        for(int i=cost.length-1;i>=0;i--){
            cost[i] = cost[i] + Math.min(firstMin, secondMin);
            secondMin = firstMin;
            firstMin = cost[i];
        }
        System.out.println("calculative array : "+ Arrays.toString(cost));
        return Math.min(cost[0], cost[1]);
    }
}
