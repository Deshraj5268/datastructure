package dp;


/*
* https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
* */
public class JumpGame {

    public static void main(String[] args) {
        int [] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };;
        int result = minJumpRec(arr, 0);
        System.out.println(result);
       int resul1 =  minJumpDP(arr, 0, new int[arr.length]);
        System.out.println("using dp "+resul1);

    }

    public static int minJumpRec(int [] arr, int i){
        if(i >= arr.length-1){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int currVal = 0;
        for(int j = i+1; j <= i + arr[i];j++){
            currVal = minJumpRec(arr, j);
            ans = Math.min(ans, 1+currVal);
        }
        return ans;
    }

    public static int minJumpDP(int [] arr, int i, int [] dp){
        if(i >= arr.length-1){
            return 0;
        }
        if(dp[i] != 0){
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        int currVal = 0;
        for(int j = i+1; j <= i + arr[i];j++){
            currVal = minJumpRec(arr, j);
            ans = Math.min(ans, 1+currVal);
        }
        dp[i] = ans;
        return dp[i];
    }

}
