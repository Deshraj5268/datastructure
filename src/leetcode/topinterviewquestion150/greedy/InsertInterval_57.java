package leetcode.topinterviewquestion150.greedy;


import leetcode.topinterviewquestion150.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval_57 {

    public static void main(String[] args) {
        int [][][] intervals = {{{1,3},{6,9}},
                {{1,2},{3,5},{6,7},{8,10},{12,16}}
        };


        int [][] newInterval = {{2,5},{4,8}};
        for(int i=0;i<intervals.length;i++){
            System.out.println("input : ");
            Utils.printMatrix(intervals[i]);
            System.out.print("new interval : "+ Arrays.toString(newInterval[i]));
            int [][] result = insert(intervals[i],newInterval[i]);
            System.out.println(" output : ");
            Utils.printMatrix(result);
            result = insertOpt(intervals[i],newInterval[i]);
            System.out.println("optimize output : ");
            Utils.printMatrix(result);
        }
    }


    /*
    *
    * nlogin time
    * */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int [][] newMergedInterval = new int[intervals.length+1][2];
        int i=0;
        for(int [] itr:intervals){
            newMergedInterval[i++] = itr;
        }
        newMergedInterval[i] = newInterval;
        return MergeInterval_56.merge(newMergedInterval);
    }

    public static int[][] insertOpt(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int [] in:intervals){
            if(in[1]<newInterval[0]){ // current is left of newInterval
                result.add(in);
            }else if(newInterval[1] < in[0]){ // newInterval is left side then update newInterval
                result.add(newInterval);
                newInterval = in;
            }else{ // keep the track start = Min(both) end = max(both)
                newInterval[0] = Math.min(newInterval[0],in[0]);
                newInterval[1] = Math.max(newInterval[1],in[1]);
            }
        }
        result.add(newInterval);

        return result.toArray(new int[result.size()][]);

    }
}
