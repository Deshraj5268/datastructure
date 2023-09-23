package backtracking;

import java.util.ArrayList;
import java.util.List;


/*
* https://leetcode.com/problems/generate-parentheses/description/
* */
public class GenerateAllBalancedPara {

    static  char leftPara = '(';
    static char rightPara = ')';
    public static void main(String[] args) {

        int n = 3;
        List<String> result = generateParenthesis(n);
        result.stream().forEach(x-> System.out.println(x + " "));
    }

    public static List<String> generateParenthesis(int n) {
        int open=n,close = n;
        List<String> result = new ArrayList<>();
        generateParenthesisUtil(open,close,n,result,"");
        return result;
    }

    private static void generateParenthesisUtil(int open, int close, int n, List<String> result,String tempResult) {
        if(open == 0 && close == 0){
            result.add(tempResult);
            return;
        }
        if(open != 0){
            generateParenthesisUtil(open-1,close,n,result,tempResult+leftPara);
        }
        if(close>open){
            generateParenthesisUtil(open,close-1,n,result,tempResult+rightPara);
        }
    }
}
