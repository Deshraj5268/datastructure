package queue.interval.linesweep;

import java.util.ArrayList;
import java.util.List;

public class LineSweepAlgo {

    public static void main(String[] args) {
        int [] arrival = {900, 940, 950, 1500, 1100, 1800};
        int [] dept = {910, 1200, 1120, 1900, 1300, 2000};

        // output : 3
        int minPlatformCount = minPlatform(arrival, dept);
        System.out.println("minPlatformCount required using Line sweep algo: "+minPlatformCount);
    }

    public static int minPlatform(int [] arrival , int [] dept){
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
}

class Event {
    int time;
    int type;// arrival : +1 , Dept : -1

    public Event(int time, int type){
        this.time = time;
        this.type = type;
    }
}