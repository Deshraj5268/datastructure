package dp;

public class LPSubsequence {

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

    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";
        char [] arr = str.toCharArray();
        System.out.println(lpSubSequence(arr,0,arr.length-1));
    }
}
