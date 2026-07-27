package queue.interval.linesweep;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/car-pooling/description/
 * */
public class CarPooling {

    int [] maxCap;

    public CarPooling(){
        maxCap = new int[100000];
    }
    public static void main(String[] args) {

        int [][][] tripsMat = {{{2,1,5},{3,5,7}},
        };
        int [] caps = {3};
        for (int t = 0; t < tripsMat.length; t++) {
            CarPooling carPooling = new CarPooling();
            System.out.println("result : "+ carPooling.carPooling(tripsMat[t], caps[t]));
        }
    }


    public boolean carPoolingUsingDAT(int[][] trips, int capacity) {

        for(int [] trip : trips){
            maxCap[trip[1]] += trip[0];
            maxCap[trip[2]] -= trip[0];
        }

        int currCap = 0;
        for(int i=0;i<maxCap.length;i++){
            currCap += maxCap[i];
            if(currCap > capacity){
                return false;
            }
        }
        return true;



    }

    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> events = new ArrayList<>();

        for(int [] trip : trips){
            int [] event1 = new int[]{trip[1], +trip[0]};
            int [] event2 = new int[]{trip[2], -trip[0]}; // test cases passes new int[]{trip[2]-1, -trip[0]};
            events.add(event1);
            events.add(event2);
        }

        events.sort((e1, e2) -> {
            int cmp = Integer.compare(e1[0], e2[0]);
            return cmp != 0 ? cmp : Integer.compare(e2[1], e1[1]);
        });
        int currCap = 0;
        for(int [] event : events){
            currCap += event[1];
            if(currCap > capacity){
                return false;
            }
        }

        return true;
    }

}
