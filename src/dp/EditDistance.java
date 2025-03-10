package dp;


/*https://www.geeksforgeeks.org/edit-distance-dp-5/
*
* Given two strings s1 and s2 and below operations that can be performed on s1.
* The task is to find the minimum number of edits (operations) to convert ‘s1‘ into ‘s2‘.

Insert: Insert any character before or after any index of s1
Remove: Remove a character of s1
Replace: Replace a character at any index of s1 with some other character.
* */
public class EditDistance {

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        int result = editDistance(str1,str2,str1.length(),str2.length());
        System.out.println("result : "+result);
        result = editDistanceDP(str1,str2,str1.length(),str2.length());
        System.out.println("result Dp : "+result);
        int [][] dp = new int[str1.length()][str2.length()];
         result = editDistanceMemoization(str1,str2,str1.length(),str2.length(),dp);
        System.out.println("memoization : "+result);
    }


    public static int editDistanceDP(String str1,String str2,int m,int n){
        int [][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0){
                    dp[i][j]=j;
                }else if(j==0){
                    dp[i][j]=i;
                }else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+ Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                }

            }
        }
        return dp[m][n];
    }



    public static int editDistance(String str1,String str2,int m,int n){
        if(n == 0){
            return m;
        }
        if(m == 0){
            return n;
        }
        if(str1.charAt(m-1) == str2.charAt(n-1)){
            return editDistance(str1,str2,m-1,n-1);//no cost
        }
        return 1 + Math.min(Math.min(editDistance(str1,str2,m,n-1) // insert 1 is cost of each operation
                ,editDistance(str1,str2,m-1,n) )// remove
               ,editDistance(str1,str2,m-1,n-1) // replace
        );
    }


    public static int editDistanceMemoization(String str1,String str2,int m,int n,int [][]dp){
        if(n == 0){
            return m;
        }
        if(m == 0){
            return n;
        }
        if(dp[m-1][n-1]!=0){
            return dp[m-1][n-1];
        }
        if(str1.charAt(m-1) == str2.charAt(n-1)){
            return editDistance(str1,str2,m-1,n-1);//no cost
        }
        return 1 + Math.min(Math.min(editDistance(str1,str2,m,n-1) // insert meant we can decrease length because we insert to match , 1 is cost of each operation
                        ,editDistance(str1,str2,m-1,n) )// remove
                ,editDistance(str1,str2,m-1,n-1) // replace
        );
    }}
