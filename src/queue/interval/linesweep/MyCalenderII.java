package queue.interval.linesweep;

import java.util.*;


/*
*
* https://leetcode.com/problems/my-calendar-ii/description/*/
public class MyCalenderII {

    private static List<int []> lists;

    private static TreeMap<Integer, Integer> treeMap;
    private static int bookingCount = 3;
    public MyCalenderII() {
        lists = new LinkedList<>();
    }

    public static void main(String[] args) {
        int [][] intervals = {{10,20},{50,60},{10,40},{5,15},{5,10},{25,55}};
        lists = new ArrayList<>();
        treeMap = new TreeMap<>();
        for(int [] interval : intervals) {
            System.out.println("new pair : "+ Arrays.toString(interval));
            System.out.println("can book :"+book(interval[0], interval[1]));
            System.out.println("can book using TreeMap line sweep :"+bookUsingTreeMapSeepLine(interval[0], interval[1]));
        }
    }


    /*
    * n * n
    * */
    public static boolean book(int startTime, int endTime) {
        int [] newPair = new int[]{startTime, endTime};
        if(lists.isEmpty()){
            lists.add(newPair);
            return true;
        }
        Iterator<int [] > temp = lists.iterator();
        int [] pair;
        int count = 0;
        while(temp.hasNext()){
            pair = temp.next();
            if(isOverLap(pair, newPair)){
                count++;
            }
            if(count >= 2){
                return false;
            }
        }
        lists.add(newPair);
        return true;
    }


    public static boolean bookUsingTreeMapSeepLine(int startTime, int endTime) {
        treeMap.put(startTime, treeMap.getOrDefault(startTime, 0)+1);
        treeMap.put(endTime, treeMap.getOrDefault(endTime, 0)-1);

        int activeBookingCount = 0;
        for(int count : treeMap.values()){
            activeBookingCount += count;

            if(activeBookingCount >= bookingCount){
                treeMap.put(startTime, treeMap.getOrDefault(startTime, 0)-1);
                if(treeMap.get(startTime) == 0){
                    treeMap.remove(startTime);
                }

                treeMap.put(endTime, treeMap.getOrDefault(endTime, 0) + 1);
                if(treeMap.get(endTime) == 0){
                    treeMap.remove(endTime);
                }
                return false;
            }
        }

        return true;
    }

    private static boolean isOverLap(int [] pair, int [] newPair){
        return !(newPair[1] <= pair[0] || pair[1] <= newPair[0]); // new pair left hand side or completely right hand side then no overlapping
    }
}

