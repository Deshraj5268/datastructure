package src.dp.lcsvariation;

public class LCSubstring {

    public static void main(String[] args) {
        String s1 ="ABCDGH";
        String s2 = "ACDGHR";
        System.out.println("input s1: "+s1 +" s2: "+s2);
        int result = lcSubstring(s1,s2);
        System.out.println("output : "+result);
        int recResult = lcSubstringRec(s1,s2,s1.length()-1,s2.length()-1,0);
        System.out.println("recResult : "+recResult);
    }

    /*
    * same way of LCS but both are not matching then start with 0
    * if same then add 1 and take max of previous result , (1+Sof(l1-1,l2-1)
    * */
    public static int lcSubstring(String s1,String s2){
        int l1= s1.length();
        int l2 = s2.length();
        int result = 0;
        int [][] tab = new int [l1+1][l2+1];
        for(int i=0;i<=l1;i++){
            for(int j=0;j<=l2;j++){
                if(i==0|| j==0){
                    tab[i][j] = 0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    tab[i][j] = 1+tab[i-1][j-1];
                    result = Math.max(result,tab[i][j]);
                }else{
                    tab[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static int lcSubstringRec(String s1,String s2,int l1,int l2,int count){
        if(l1 == -1|| l2 == -1){
            return 0;
        }
        if(s1.charAt(l1) == s2.charAt(l2)){
            return lcSubstringRec(s1,s2,l1-1,l2-1,count+1);
        }
        return Math.max(count,
                Math.max(lcSubstringRec(s1,s2,l1-1,l2,0),
                        lcSubstringRec(s1,s2,l1,l2-1,0)));
    }
}
