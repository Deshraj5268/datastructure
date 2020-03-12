package dp;

import java.util.HashSet;

public class WordBreakProblem {

    private static HashSet dictionary = new HashSet<String>();

    public static boolean wordBreak(String input){
        int size = input.length();
        if(size == 0){
            return true;
        }
        for(int i=1;i<=size;i++){
            //prefix 0 to i and i to size breakable or not
            if(dictionary.contains(input.substring(0,i)) && wordBreak(input.substring(i,size))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String [] dicsStrArr = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};

        for(int i=0;i<dicsStrArr.length;i++){
            dictionary.add(dicsStrArr[i]);
        }

        System.out.println("ilikesamsung : "+wordBreak("ilikesamsung"));
        System.out.println("iiiiiiii : "+wordBreak("iiiiiiii"));
        System.out.println("empty string  : " + wordBreak(""));
        System.out.println("ilikelikeimangoiii : "+wordBreak("ilikelikeimangoiii"));
        System.out.println("ilikelikeimangoiii : "+wordBreak("samsungandmango"));
        System.out.println("samsungandmangok : "+wordBreak("samsungandmangok"));


    }
}
