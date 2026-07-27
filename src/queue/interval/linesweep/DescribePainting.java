package queue.interval.linesweep;

import java.util.*;


/*
*
* https://leetcode.com/problems/describe-the-painting/description/
* https://www.youtube.com/watch?v=e3Tr6ZnqKP0&list=PLpIkg8OmuX-IOG_-Bv92l-EhuBQX28LOm&index=10 : good explanation it's line sweep
* */
public class DescribePainting {

    public static void main(String[] args) {

        int[][][] testCases = {
                {   // Test Case 1
                        {1, 4, 5},
                        {4, 7, 7},
                        {1, 7, 9}
                },
                {   // Test Case 2
                        {1, 7, 9},
                        {6, 8, 15},
                        {8, 10, 7}
                },
                {   // Test Case 3
                        {1, 4, 4},
                        {1, 7, 7},
                        {4, 7, 1},
                        {4, 5, 2}
                },
                {   // Test Case 4
                        {1, 3, 2},
                        {2, 5, 3},
                        {4, 6, 4}
                }
        };
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            List<List<Long>> ans = splitPainting(testCases[i]);

            for (List<Long> interval : ans) {
                System.out.println(interval);
            }
            System.out.println();

        }
    }

    public static List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, Long> treeMap = new TreeMap<>(); // this is sorted order

        for(int [] segment : segments){
            treeMap.put(segment[0], treeMap.getOrDefault(segment[0], 0L) + segment[2]);
            treeMap.put(segment[1], treeMap.getOrDefault(segment[1], 0L) - segment[2]);
        }

        List<List<Long>> result = new ArrayList<>();

        Integer prevSeg = null;
        long colorSum = 0;
        for(Map.Entry<Integer, Long> entry : treeMap.entrySet()){

            int currSeg = entry.getKey();

            if(prevSeg != null && colorSum > 0){
                result.add(Arrays.asList((long)prevSeg, (long)currSeg, colorSum));
            }

            colorSum += entry.getValue();
            prevSeg = currSeg;
        }

        return result;

    }
}
