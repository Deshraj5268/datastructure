package advanceds.differencearraytechnique;

import java.util.Arrays;

// leetcode : Premium : https://leetcode.com/problems/range-addition/
// good video : https://www.youtube.com/watch?v=ZHNVmtm08WY&list=PLpIkg8OmuX-Kqkb8DqDe_4-Tiav6ilS_L
/*
*
*
Problem Description
You start with an array of zeros with a given length. You're given a series of updates
* where each update is a triplet [startIdx, endIdx, inc] that tells you to:

Add inc to every element from index startIdx to endIdx (inclusive)
Your task is to apply all these updates to the array and return the final result.

Example walkthrough:

If length = 5 and updates = [[1, 3, 2], [2, 4, 3]]
Start with: [0, 0, 0, 0, 0]
After first update (add 2 to indices 1-3): [0, 2, 2, 2, 0]
After second update (add 3 to indices 2-4): [0, 2, 5, 5, 3]
Return: [0, 2, 5, 5, 3]
The challenge is to find an efficient way to handle potentially many
* updates without actually iterating through each range for every update, which would be inefficient. The solution uses a difference array technique:

Instead of updating ranges directly, mark the boundaries:

When adding c to range [l, r], mark d[l] += c (start of increase)
Mark d[r+1] -= c (end of increase) if r+1 is within bounds
After marking all boundaries, compute the prefix sum of this
*  difference array to get the final result. The prefix sum naturally propagates the increments across the ranges.

This approach reduces the time complexity from O(n × m) for naive range
* updates to O(n + m) where n is the array length and m is the number of updates.
* */
public class RangeAddition {

    public static void main(String[] args) {

        //triplet [startIdx, endIdx, inc]
        int [][][] queryMat = {
                {
                        {1, 3, 2},
                        {2, 4, 3}

                }
        };
        int [][] expectedResult = {
                {0, 2, 5, 5, 3}
        };
        int [] lenArr = {5};
        for (int i = 0; i < queryMat.length; i++) {
            int [] result = findAdditionUsingBruteForce(queryMat[i], lenArr[i]);
            System.out.println("bruteforce :"+Arrays.toString(result));

            result = findAdditionDiffArrayTechnique(queryMat[i], lenArr[i]);
            System.out.println("Difference Array technique :"+Arrays.toString(result));
        }
    }

    // add inc data for given all range query : bruteforce
    // Q * n ( worst case for all n)
    private static int[] findAdditionUsingBruteForce(int[][] queries, int n) {
        int [] result = new int[n];
        for(int [] query : queries){

            for(int startIndex = query[0]; startIndex <= query[1]; startIndex++){
                result[startIndex] += query[2]; // inc value
            }
        }

        return result;
    }

    /*
     * we can add start index value and lastIndex+1 add opposite value (means if you do some then it's range query sum only
     *
     * Start with: [0, 0, 0, 0, 0]
      After first update (add 2 to indices 1-3): [0, 2, 0, 0, -2]
      * if we do sum : [0, 2, 2, 2, 0] : that we want
     *
     *   result[start] += inc
     *   result[endIndex+1] -= inc : if endIndex+1<n
     * after that prefix sum array
     * */
    public static int [] findAdditionDiffArrayTechnique(int[][] queries, int n) {
        int[] result = new int[n];
        int startIndex, endIndex, incVal;
        for(int [] query : queries){
            startIndex = query[0];
            endIndex = query[1];
            incVal = query[2];

            result[startIndex] += incVal;

            if(endIndex+1 < n) {
                result[endIndex + 1] -= incVal;
            }
        }

        for (int s = 0; s < n-1; s++) {
            result[s+1] += result[s];
        }
        return result;

    }

}
