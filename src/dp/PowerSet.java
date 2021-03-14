package dp;

import java.util.ArrayList;
import java.util.Arrays;

/* https://www.geeksforgeeks.org/recursive-program-to-generate-power-set/*/

public class PowerSet {

    public static void main(String[] args) {

        String set = "123";
        //n^n
        System.out.println("using prefix method");
        powerSetPreFix(set,-1,"");

        //2^n
        System.out.println("\n generate all : ");
        generateAllSet(set,0,"");
      //  generateAllSet(set,0,new char[set.length()]);

        System.out.println("\n add one element each set ..");
        ArrayList<ArrayList<Character>> result = getSubSetList(set,set.length()-1);
        if(result != null){
            for (int i=0;i<result.size();i++){
                for(Character ch : result.get(i)){
                    System.out.print(ch +" ");
                }
                System.out.println();
            }
        }

    }


    /*
    * start with empty list
    * add ith element in every list
    * */
    private static ArrayList<ArrayList<Character>> getSubSetList(String set, int index) {
        ArrayList<ArrayList<Character>> allSubSet = new ArrayList<>();
        if(index < 0){
            allSubSet.add(new ArrayList<>());
        }else {
            allSubSet = getSubSetList(set,index-1);
            char item = set.charAt(index);
            ArrayList<ArrayList<Character>> moreSubSet = new ArrayList<>();
            for (ArrayList<Character> allSet :allSubSet){
                ArrayList<Character> newSubSet = new ArrayList<>();
                newSubSet.addAll(allSet);
                newSubSet.add(item);
                moreSubSet.add(newSubSet);
            }
            allSubSet.addAll(moreSubSet);
        }
        return allSubSet;
    }

    /*
    * O(n^n) draw n --- depth n tree
    *
    *       f(0)
    *     /   |  \
    *    /    |   \
    *   f(1)  f(2) f(3)
    *   /     '
    *  /      '
    *  f(12)
    *  /
    *  /
    * */
    private static void powerSetPreFix(String set, int index, String currentSet) {
        if(index == set.length()){
            return;
        }
        System.out.print(currentSet+" ");
        for (int i=index+1;i<set.length();i++){
            currentSet += set.charAt(i);
            powerSetPreFix(set,i,currentSet);

            currentSet = currentSet.substring(0,currentSet.length()-1); // remove
        }
    }

    /*
    * initially currentSet is empty
    * if index is equal to set.length() then print currentSet
    * include current element in currentSet
    * do not current element in currentSet
    * O(2^n)
    *
    *          f(1)
    *       Y/     \N
    *       /        \
    *      f(2)      f(2)
    *    Y/   \N
    *   /     \
    *  f(3)   f(3)
    * Y/  \N           (path0 : 1,2,3  path1 : 1,2
    *f(n)  f(n)
    * path 0  1
    * */

    public static void generateAllSet(String set,int index,String currentSet){
        if(index == set.length()){
            System.out.print(currentSet+ " "/*+currentSet.length()*/);
            return;
        }
        generateAllSet(set,index+1,currentSet +(set.charAt(index))); //include element
        generateAllSet(set,index+1,currentSet);                               // not include element
    }

    public static void generateAllSet(String set, int index, char [] currentSet){
        if(index == set.length()){
            System.out.println(Arrays.toString(currentSet));
            return;
        }
        char temp = currentSet[index];
        currentSet[index] = set.charAt(index);
        generateAllSet(set,index+1,currentSet); //include element
        currentSet[index] = temp;
        generateAllSet(set,index+1,currentSet); // not include element
    }

}
