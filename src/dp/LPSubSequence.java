package dp;

import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

public class LPSubSequence {

    public static void main(String[] args) {
        String str = "abcdba";
        char [] arr = str.toCharArray();
        System.out.println(lpSubSequence(arr,0,arr.length-1));

        System.out.println(lpsDp(arr,arr.length));
    }

    public static int lpsDp(char [] arr,int n){
        int [][] lps = new int[n][n];
        for(int i=0;i<n;i++){
            lps[i][i] = 1;
        }
        int j=0;
        for(int l=2;l<=n;l++){
            for(int i=0;i<n-l+1;i++){
               j = i+l-1;
               if(arr[i] == arr[j] && l==2){
                   lps[i][j] = 2;
               }else if(arr[i] == arr[j]){
                   lps[i][j] = lps[i+1][j-1]+2;
               }else {
                   lps[i][j] = Math.max(lps[i+1][j],lps[i][j-1]);
               }
            }
        }
        /*for (int k=0;k<lps.length;k++){
            System.out.println(Arrays.toString(lps[k]));
        }*/
        return lps[0][n-1];
    }

    public static int lpSubSequence(char [] arr,int i,int j){
        if(i == j){
            return 1;
        }
        if(arr[i] == arr[j] && i+1 == j){
            return 2;
        }
        if(arr[i] == arr[j]){
            return lpSubSequence(arr,i+1,j-1)+2;
        }
        return Math.max(lpSubSequence(arr,i+1,j),lpSubSequence(arr,i,j-1));
    }

}
