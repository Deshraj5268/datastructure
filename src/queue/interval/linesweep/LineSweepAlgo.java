package queue.interval.linesweep;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// Sweep line = walk through timeline and count active intervals
//problems : https://leetcode.com/discuss/post/2166045/line-sweep-algorithms-by-c0d3m-8ebq/
public class LineSweepAlgo {

    public static void main(String[] args) {
        int [] arrival = {900, 940, 950, 1500, 1100, 1800};
        int [] dept = {910, 1200, 1120, 1900, 1300, 2000};

        // output : 3
        int minPlatformCount = lineSweepAlgo(arrival, dept);
        System.out.println("minPlatformCount required using Line sweep algo: "+minPlatformCount);
    }

    //if arrival and departure times are in HH:MM format
    private int toMinutes(String t) {
        String[] parts = t.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public static int lineSweepAlgo(int [] arrival , int [] dept){
        List<Event> events = new ArrayList<>();

        for(int starTime : arrival){
            events.add(new Event(starTime, +1));
        }

        for(int endTime : dept){
            events.add(new Event(endTime, -1));
        }

        events.sort((e1, e2)-> {
            if(e1.time == e2.time){
                return e2.type - e1.type; // arrival first (-1 -(1) : -2 :  negative means swap , >=0 then don't swap
            }
            return e1.time - e2.time;
        });

        int max = 0 , curr = 0;
        for(Event event : events){
            curr += event.type;
            max = Math.max(curr, max);
        }
        return max;
    }

    public static int lineSweepAlgoUsingMap(int[] arr, int[] dep) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (int d : dep) {
            map.put(d + 1, map.getOrDefault(d + 1, 0) - 1); // if overlapping so use d+1
        }

        int curr = 0, max = 0;

        for (int val : map.values()) {
            curr += val;
            max = Math.max(max, curr);
        }

        return max;
    }
}

class Event {
    int time;
    int type;// arrival : +1 , Dept : -1

    public Event(int time, int type){
        this.time = time;
        this.type = type;
    }
}