package dp.lcsvariation;

public class LPSubSequence {

    public static void main(String[] args) {
        String str = "cbbd";
        char [] arr = str.toCharArray();
        System.out.println(lpSubSequence(arr,0,arr.length-1));

        System.out.println(lpsDp(arr,arr.length));
        System.out.println("lps using lcs "+lpsUsingLCS(str));
    }


    /*
    * lcs ( str,strRverse) ==> LPS
    * */
    public static int lpsUsingLCS(String str1){
        String str1reverse = new StringBuilder(str1).reverse().toString();
        int m = str1.length();
        int n = str1reverse.length();
       int [][] lcs =  LCS.lcsDpTab(str1,str1reverse,m,n);
       return lcs[m][n];
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

 /*  fun(i,j)
  *  lps[n][n]
  *  if i== j then return 1;
  *  if first == last element equal AND length =2
   *  then return 2;
   *  if first == last element ( increase starting index and decrease last index
   *  then return fun(i+1,j-1)+2;
   *  else
   *   Max( fun(i+1,j),fun(i,j-1)
  * O(2^n)
  *
  *           f(i,j)
  *        /        \
  *       /          \
  *    f(i+1,j)     f(i,j-1)
  *    /     \        .
  *   /       \
  * f(i+2,j)  f(i+1,j-1)
  * /     \
  *f(n,n)  f(n,j)
  *
  * */
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
