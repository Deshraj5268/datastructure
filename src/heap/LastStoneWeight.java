package heap;

import java.util.Arrays;
import java.util.PriorityQueue;


/*
* problem : https://leetcode.com/problems/last-stone-weight
* */
public class LastStoneWeight {

    public static void main(String[] args) {

        int [][] mat = {{1},
                {1,1},
                {1,2},
                {2,7,4,1,8,1}
        };
        int result;
        for(int i=0;i<mat.length;i++){
            System.out.println("input : "+ Arrays.toString(mat[i]));
            result = lastStoneWeight(mat[i]);
            System.out.println("result :"+result);
        }
    }

    /*
    * build max heap
    * take top two element
    * if max1>max2 then store diff in max heap
    *
    * finally return the value if heap is not empty
    * */
    public static int lastStoneWeight(int[] stones) {
        if(stones == null || stones.length ==0){
            return 0;
        }
        if(stones.length == 1){
            return stones[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y)->y-x);
        for(int stone:stones){
            maxHeap.add(stone);
        }
        int max1;
        int max2;
        while( maxHeap.size()>1){
            max1 = maxHeap.poll();
            max2 = maxHeap.poll();
            if(max1-max2>0){
                maxHeap.add(max1-max2);
            }
        }
        return maxHeap.isEmpty()?0:maxHeap.poll();
    }
}
