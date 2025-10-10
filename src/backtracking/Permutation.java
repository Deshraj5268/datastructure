package backtracking;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=EnRciMd08_g&list=PL_z_8CaSLPWdbOTog8Jxk9XOjzUs3egMP&index=9
public class Permutation {

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        String str = "ABC";
        ArrayList<String> ans = new ArrayList<>();
        permutation.permutationUtil(new StringBuilder(str), 0, ans);
        System.out.println(ans);
    }


              /*
              *
              *                     abc
              *
              *          abc        bac         cba
              *
              *    abc    acb    bac  bca     cba  cab
              *
              *
              *
              * */

    public void permutationUtil(StringBuilder sb, int index, ArrayList<String> ans){

        if(sb.length() == index){
            ans.add(sb.toString());
        }
        for(int i=index;i<sb.length();i++){
            Utility.swap(sb, i, index);
            permutationUtil(sb, index+1, ans);
            Utility.swap(sb, i, index); // backtracking
        }

    }
}
