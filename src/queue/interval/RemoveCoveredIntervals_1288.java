package queue.interval;

import java.util.Arrays;


/*
* https://www.youtube.com/watch?v=nhAsMabiVkM
* */
public class RemoveCoveredIntervals_1288 {

    public static void main(String[] args) {

        int [][][] mat ={ {{1,2},{1,4},{3,4}},
                {{1,4},{3,6},{2,8}}};

        for(int [][] arr: mat){
            int result = removeCoveredIntervals(arr);
            System.out.println("result : "+result);
        }

    }


    /*
    *
    * [[1,4],[3,6],[2,8]]
    *
    * 1----------4
    *       3---------6    // 3 6 is covered by 2 8
    *   2------------------8
    *
    * so  1-------4
    *       2--------------8 will be remaining in the list
    * sort based on start time
    * check overlapping condition then store
    * */
    public static  int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y)->x[0]-y[0]);// sort based on start time

        int [] curr  = {-1,-1};
        int count=0;
        for(int [] in: intervals){ // [] in one cell {stat,end}
            if(in[0] > curr[0] && in[1] > curr[1]){//  overlapping added in remaining list
                curr[0] = in[0];
                count++;
            }
            curr[1] = Math.max(curr[1],in[1]); // max of end times

        }
        return count;
    }
}
