package queue.interval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NonOverlapping_435 {

    public static void main(String[] args) {


        int [][][] mat ={{{1,2}},
                {{1,2},{3,9},{3,4},{4,8}},
                {{1,2},{2,3},{3,4},{1,3}},
                {{1,2},{1,2},{1,2}}
        };

        for(int [][] arr: mat){
            List<int []> result = eraseOverlapIntervals(arr);
            System.out.println("result : "+result.size());
            for (int [] interval : result){
                System.out.print("{"+interval[0]+ ", "+interval[1]+"}"+ ", ");
            }
            System.out.println();
        }
    }

    /*

   sort the array be start time in increasing order
        2---3
    1----------4
         overlapping removing (2< 4) and 3<4 so [1-4] is larger interval so keep [2-3]

         else : no over lapping so update last interval
   */
    public static List<int[]> eraseOverlapIntervals(int[][] intervals) {
        List<int []> nonOverLapping = new LinkedList<>();
        if(intervals.length <=1){
            return nonOverLapping;
        }
        Arrays.sort(intervals,(x, y)->x[0]-y[0]);//sort based on start time

        int [] in = intervals[0];
        int count = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] < in[1]){ // overlapping  start of 1 < endTime of first
                count++;
                if(intervals[i][1] < in[1]){ // in end time also greater than , ie. start,end
                    nonOverLapping.add(in);
                    in = intervals[i];
                }else {
                    nonOverLapping.add(intervals[i]);
                }
            }else {
                in = intervals[i];
            }
        }
        return nonOverLapping;
    }
}
