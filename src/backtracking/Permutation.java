package backtracking;

import java.util.ArrayList;

public class Permutation {

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        String str = "ABC";
        ArrayList<String> ans = new ArrayList<>();
        permutation.permutationUtil(new StringBuilder(str), 0, ans);
        System.out.println(ans);
    }

    public void permutationUtil(StringBuilder sb, int index, ArrayList<String> ans){

        if(sb.length() == index){
            ans.add(sb.toString());
        }
        for(int i=index;i<sb.length();i++){
            swap(sb, i, index);
            permutationUtil(sb, index+1, ans);
            swap(sb, i, index); // backtracking
        }

    }

    public void swap(StringBuilder sb , int src , int dst){
        char temp = sb.charAt(src);
        sb.setCharAt(src, sb.charAt(dst));
        sb.setCharAt(dst, temp);
    }
}
