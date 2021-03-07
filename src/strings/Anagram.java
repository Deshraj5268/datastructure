package strings;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        String s1 = "cat";
        String s2 = "tec";
        System.out.println(isAnagramWithArray(s1,s2));
    }


    public static int basicCondition(String a,String b){
        int result = 0;
        if(a == null && b == null){
            result = 1;
        }
        if((a == null || b == null) || (a.length() != b.length())){
            result = 2;
        }
        return result;
    }

    public static boolean isAnagramWithArray(String s,String t){

        int basicTest = basicCondition(s,t);
        if(basicTest != 0){
            return basicTest == 1;
        }
        int [] countArr = new int[256];
        for(int i=0;i<s.length();i++){
            countArr[s.charAt(i)]++;
            countArr[t.charAt(i)]--;
        }
        boolean isAnagram = Arrays.stream(countArr).anyMatch(indexValue-> indexValue != 0);
        return !isAnagram;
    }
}
