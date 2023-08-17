package dp.lcsvariation;

public class MinDistanceStrAToB {

    public static void main(String[] args) {
        String [] str1Mat = {"heap","sea","leetcode"};
        String [] str2Mat = {"pee","eat","etco"};
        int m,n,result;
        for(int i=0;i<str1Mat.length;i++){
            result = minDistance(str1Mat[i],str2Mat[i]);
            System.out.println("result "+result);
        }
    }

    public static int minDistance(String str1,String str2){
        int m = str1.length();
        int n = str2.length();
        int [][] lcsTab = LCS.lcsDpTab(str1,str2,m,n);
        int lcs = lcsTab[m][n];
        int insertionCost = m-lcs;
        int deletionCost = n-lcs;
        System.out.println("insertionCost "+insertionCost+" deletionCost "+deletionCost);
        return Math.min(insertionCost,deletionCost);
    }
}
