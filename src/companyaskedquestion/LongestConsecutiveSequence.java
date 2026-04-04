package companyaskedquestion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int [][] mat = {
                {1,3,5,6,7,2,4,100, 200},
                {100, 101, 102, 103, 104, 105, 1,2,6,4},
                {100, 101, 102, 103, 104, 105, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };
        for(int [] arr : mat){
            int result = findLConsecutiveSequence(arr);
            System.out.println("input :"+ Arrays.toString(arr));
            System.out.println("output : "+ result);
        }
    }

    /*
    *
    * add all element in set
    * then check if (n-1) element is not present in set
    * then check all n , n+1, n+2 , n+3 ....
    *      element in set and maintain the max and current count
    *
    * */
    public static int findLConsecutiveSequence(int [] arr){
        Set<Integer> set = new HashSet<>();
        for(int element : arr){
            set.add(element);
        }

        int maxSeq = 0;
        int currentSeqLen = 0;
        for(int element : set){
            currentSeqLen = 0;
            if(!set.contains(element - 1)){
                while (set.contains(element)){
                    element++;
                    currentSeqLen++;
                    if(currentSeqLen > maxSeq){
                        maxSeq = currentSeqLen;
                    }
                }
            }
        }
        return maxSeq;
    }
}
