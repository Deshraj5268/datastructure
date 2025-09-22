package queue.interval;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyCalender {

    private static List<int []> lists;
    public MyCalender() {
        lists = new LinkedList<>();
    }

    public static void main(String[] args) {
        int [][] intervals = {{10, 20}, {15, 25}, {20, 30}};
        for(int [] interval : intervals) {
            System.out.println(book(interval[0], interval[1]));
        }
    }

    public static boolean book(int startTime, int endTime) {
        int [] newPair = new int[]{startTime, endTime};
        System.out.println("new "+newPair[0] +" , "+newPair[1]);
        if(lists.isEmpty()){
            lists.add(newPair);
            return true;
        }
        Iterator<int [] > temp = lists.iterator();
        int [] pair;
        while(temp.hasNext()){
            pair = temp.next();
            System.out.println(pair[0] +" , "+pair[1]);
            if(!isOverLap(pair, newPair)){
                return false;
            }else {
                lists.add(newPair);
            }
        }

        return true;
    }

    private static boolean isOverLap(int [] pair, int [] newPair){

        return !(newPair[1] < pair[0] || pair[1] < newPair[0]);
    }
}

