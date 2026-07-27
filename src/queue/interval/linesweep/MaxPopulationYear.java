package queue.interval.linesweep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxPopulationYear {

    public static void main(String[] args) {

        int[][][] testCases = {
                {{1950, 1961}, {1960, 1971}},
                {{1950, 1960}, {1955, 1965}, {1960, 1970}},
                {{1993, 1999}, {2000, 2010}},
                {{1950, 1960}, {1950, 1960}, {1950, 1960}},
                {{1950, 2050}},
                {{1950, 1951}, {1951, 1952}, {1952, 1953}},
                {{2008,2026},{2004,2008},{2034,2035},{1999,2050},{2049,2050},{2011,2035},{1966,2033},{2044,2049}}
        };
        MaxPopulationYear maxPopulationYear = new MaxPopulationYear();
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1));
            System.out.println("Input: " + Arrays.deepToString(testCases[i]));

            int answer = maxPopulationYear.maximumPopulationUsingDAT(testCases[i]);

            System.out.println("Maximum Population Year: " + answer);
            answer = maxPopulationYear.maximumPopulationUsingLineSweep(testCases[i]);

            System.out.println("Sweep line Maximum Population Year: " + answer);
        }
    }

    public int maximumPopulation(int[][] logs) {
        int[] delta = new int[101]; // years 1950-2050
        for (int[] log : logs) {
            delta[log[0] - 1950]++;
            delta[log[1] - 1950]--;
        }
        int maxPop = 0, curr = 0, year = 1950;
        for (int i = 0; i < 101; ++i) {
            curr += delta[i];
            if (curr > maxPop) {
                maxPop = curr;
                year = 1950 + i;
            }
        }
        return year;
    }


    /*
    * brute force : O(Q X n) : each query worst case n update
    * DAT approach Q + N
    *
    * */
    public int maximumPopulationUsingDAT(int[][] logs) {
        int [] result = new int[2051];

        int startYear, endYear, val;
        for(int [] log : logs){
            startYear = log[0];
            endYear = log[1]; // (year -1) +1

            result[startYear] += 1;

            if(endYear < 2051){
                result[endYear] -= 1;
            }

            // simple
            /*
            * result[log[0]]++;
              result[log[1]]--;
            * */
        }

        //cumulative sum
        for(int i=1950; i < 2051-1;i++){
            result[i+1] += result[i];
        }

        int maxCount = 0;
        int populationYear = 1950;
        for(int i=1950; i < 2051-1;i++){
            if(maxCount < result[i]){
                maxCount = result[i];
                populationYear = i;
            }
        }

        return populationYear;
    }


    /*
    * nlogn
    * */
    public int maximumPopulationUsingLineSweep(int[][] logs) {
        List<int []> events = new ArrayList<>();

        for(int [] log : logs){
            int [] event1 = new int[]{log[0], +1};
            events.add(event1);

            int [] event2 = new int[]{log[1]-1, -1}; // not correct but all leetcode test cases passed
            events.add(event2);
        }

        events.sort((e1, e2) -> {
            int cmp = Integer.compare(e1[0], e2[0]);
            return cmp != 0 ? cmp : Integer.compare(e2[1], e1[1]);
        });


       // events.forEach(ev->System.out.println(Arrays.toString(ev)));
        int populationCount = 0, maxPopulationCount = 0;
        int populationYear = 1950;
        for(int [] event : events){
            populationCount += event[1];
            if(maxPopulationCount < populationCount){
                maxPopulationCount = populationCount;
                populationYear = event[0];
            }
        }
        return populationYear;
    }

}
