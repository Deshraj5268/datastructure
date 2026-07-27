package queue.interval.linesweep;

import java.util.Arrays;
import java.util.TreeMap;


/*
 *
 * https://leetcode.com/problems/my-calendar-iii/description/*/
public class MyCalenderIII {

    private TreeMap<Integer, Integer> treeMap;
    private  int bookingCount;
    public MyCalenderIII() {
        treeMap = new TreeMap<>();
        bookingCount = 0;
    }

    public static void main(String[] args) {
        int [][] intervals = {{10,20},{50,60},{10,40},{5,15},{5,10},{25,55}};
        MyCalenderIII myCalenderIII = new MyCalenderIII();
        for(int [] interval : intervals) {
            System.out.println("new pair : "+ Arrays.toString(interval));
            System.out.println("can book using TreeMap line sweep :"+myCalenderIII.bookUsingTreeMapSeepLine(interval[0], interval[1]));
        }
    }

    public int bookUsingTreeMapSeepLine(int startTime, int endTime) {
        treeMap.put(startTime, treeMap.getOrDefault(startTime, 0)+1);
        treeMap.put(endTime, treeMap.getOrDefault(endTime, 0)-1);

        int activeBookingCount = 0;
        for(int count : treeMap.values()){
            activeBookingCount += count;
            bookingCount = Math.max(bookingCount, activeBookingCount);
        }
        return bookingCount;
    }
}

