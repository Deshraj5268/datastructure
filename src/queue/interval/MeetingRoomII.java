package queue.interval;

import java.util.Arrays;

/*
* Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
*
* similar to min platform
* */
public class MeetingRoomII {

    public static void main(String[] args) {

        int [][][] intervals = {
                {{0, 30}, {5, 10}, {15, 20}},
                {{7, 10}, {2, 4}},
                {{0, 30}, {5, 10}, {6, 20}}
        };

        for(int i=0;i<intervals.length;i++){
            System.out.println(minRoom(intervals[i]));
        }

    }

    public static int minRoom(int [][] intervals){
        int [] startIntervals = new int[intervals.length];
        int [] endIntervals = new int[intervals.length];

        for(int i=0;i<startIntervals.length;i++){
            startIntervals[i] = intervals[i][0];
            endIntervals[i] = intervals[i][1];
        }
        Arrays.sort(startIntervals);
        Arrays.sort(endIntervals);
        System.out.println("after sorting ");
        System.out.println(Arrays.toString(startIntervals));
        System.out.println(Arrays.toString(endIntervals));

        int start = 0, end = 0;
        int minRoomCount = 0;
        int currCount = 0;

        while(start < startIntervals.length){
            if(startIntervals[start] < endIntervals[end]){
                currCount++;
                start++;
            }else {
                currCount--;
                end++;
            }
            minRoomCount = Math.max(minRoomCount, currCount);
        }
        return minRoomCount;
    }
}
