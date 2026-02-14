package companyaskedquestion;


import java.util.Arrays;

//https://leetcode.com/problems/movement-of-robots/
//https://www.youtube.com/watch?v=uC01PNyKMFY
public class RobotCollisionMovement {

    public static void main(String[] args) {

        int [][] mat = {{-2,0,2}, {2000000000,-2000000000}, {1,0} };
        String [] dirStrArr = {"RLL", "RL", "RL"};
        int [] dArr = {3, 1000000000, 2};
        for (int i = 0; i < mat.length; i++) {
            System.out.println(robotDistanceSum(mat[i], dirStrArr[i], dArr[i]));
        }
    }


    /*
    *  collision happen then they transfer the energy at the end need to reach at end (d), so no change
    * sort
    * find distance , final pos [-2,0,2], RLL --> +d=3 ==> [ -2+3 , 0-3, 2-3]
    * sort it [ -3, -1, 1] ==> a1, a2,a3] ==> |(a3-a1)| + |(a3-a2)|+ |(a3-a1)|==>  , a2 --, a1
    * [(a3+a3+a3) - (a1+a2+a3)] ==> [a3 * 3 - (prefixSum)] ===result+ finalPos[i] * i - prefixSum
    * distance basic is N2
    * sort then cal dis
    *  [a3 * 3 - (prefixSum)] ===result+ finalPos[i] * i - prefixSum
    * */
    public static int robotDistanceSum(int [] nums , String direction , int d){
        int MOD = 1000000007;
        long [] finalPos = new long[nums.length];
        for (int i = 0; i < finalPos.length; i++) {
            finalPos[i] = (direction.charAt(i) == 'R' ?  (long)nums[i] + d :  (long)nums[i] -d);
        }
        // sort
        Arrays.sort(finalPos);

        // find distance

        long prefixSum = 0, result = 0;
        for (int i = 0; i < finalPos.length; i++) {
            result = (result+ finalPos[i] * i - prefixSum) % MOD;
            prefixSum += finalPos[i];
        }
        return (int) result;
    }
}
