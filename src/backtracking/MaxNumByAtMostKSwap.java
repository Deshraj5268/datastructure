package backtracking;

import java.util.ArrayList;
import java.util.List;

public class MaxNumByAtMostKSwap {

    public static void main(String[] args) {
        String [] inputs = {"721","723", "4577","52398", "52399"};
        int [] kArr = {3,2,2,2,3};
        int start = 0;
        for(int i=0;i<inputs.length;i++){
            StringBuilder sb = new StringBuilder(inputs[i]);
            List<StringBuilder> result = new ArrayList<>();
            result.add(new StringBuilder(inputs[i]));
            maxNumByAtMostKSwap(sb, start, kArr[i], result);
            System.out.println("input:"+inputs[i]+"-> output:"+result.get(0));
        }
    }


    //https://www.youtube.com/watch?v=DOXoQfHyc7A&list=PL_z_8CaSLPWdbOTog8Jxk9XOjzUs3egMP&index=10
    public static void maxNumByAtMostKSwap(StringBuilder sb, int start, int k, List<StringBuilder> result){
        if(k == 0 || start == sb.length()-1){
            return ;
        }
        char max = findValMax(sb, start);
        for(int i=start+1; i< sb.length();i++){ // all check
            if(sb.charAt(start) < sb.charAt(i) && sb.charAt(i) <= max){
                Utility.swap(sb, start, i);
                if(sb.toString().compareTo(result.get(0).toString()) > 0){
                    result.set(0,new StringBuilder(sb)); // max digit
                }
                maxNumByAtMostKSwap(sb, start+1, k-1, result);
                Utility.swap(sb, start, i); // backtrack
            }
        }
        // if no swap horizontal rec
        maxNumByAtMostKSwap(sb, start+1, k, result); // k as it is
    }

    private static char findValMax(StringBuilder sb, int nextIndexSearch) {
        char result = sb.charAt(nextIndexSearch);
        int n = sb.length();
        while (nextIndexSearch < n){
            if(result < sb.charAt(nextIndexSearch)){
                result = sb.charAt(nextIndexSearch);
            }
            nextIndexSearch++;
        }
        return result;
    }
}
