package queue.interval;

import leetcode.topinterviewquestion150.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval_56 {

    public static void main(String[] args) {

        int [][][] intervals = {{{1,3},{2,6},{8,10},{15,18}},
                {{1,4},{4,5}},
                {{1,3},{2,6},{8,10},{15,18},{7,17}}};


        for(int i=0;i<intervals.length;i++){
            System.out.println("input : ");
            Utils.printMatrix(intervals[i]);
            int [][] result = merge(intervals[i]);
            System.out.println(" output : ");
            Utils.printMatrix(result);
        }
    }

    // sort the based on start time
    // then check endTime of previous pair is greater than satrtTime of next slot
    //so update end time with max(endTimeOFPrev , endTimeOfNextSlot)

    /*
    *{1,3},{2,6},{8,10},{15,18}
    *
    *    1------------3
    *       2---------------------6
    *                                   8---------------10
    *                                                       15 -----18
    *
    * Ans
    * 1----------------------------6   8----------------10  15------18
    *
    * so merge the overlapping into one interval
    * */
    public static int[][] merge(int[][] intervals) {
        if(intervals.length <=1){
            return intervals;
        }
        Arrays.sort(intervals,(x, y)->x[0]-y[0]);
        int [] in = intervals[0]; // first pair start , endtime
        List<int[]> result = new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(in[1] < intervals[i][0]){ // endTime < startTime of next slot
                result.add(in);
                in = intervals[i];
            }else{
                in[1] = Math.max(in[1],intervals[i][1]); // updating end time
            }
        }
        result.add(in);// last record
        return result.toArray(new int[result.size()][]);
    }
}
