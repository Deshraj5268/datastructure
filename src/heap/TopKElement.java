package heap;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
* https://leetcode.com/problems/top-k-frequent-elements/description/
* */
public class TopKElement {

    public static void main(String[] args) {
        int [][] mat = {{1,1,1,2,2,3},
                {1,2,3},
                {1,1,2,2,3,3}};
        int [] kArr = {2,1,2};
        for(int i=0;i<mat.length;i++){
            System.out.println("input : "+" :K"+kArr[i]+"array"+ Arrays.toString(mat[i]));
            int [] result = topKFrequent(mat[i],kArr[i]);
            System.out.println("result : "+Arrays.toString(result));
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair<Integer,Integer>> minHeap = new PriorityQueue<Pair<Integer,Integer>>((x, y)->x.getValue()-y.getValue());
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Pair<Integer,Integer> currentPair;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            currentPair = new Pair<>(entry.getKey(),entry.getValue());
            if(minHeap.size()<k) {
                minHeap.add(currentPair);
            }else {
                if(minHeap.peek().getValue() < currentPair.getValue()){
                    minHeap.poll();
                    minHeap.add(currentPair);
                }
            }
        }
        int [] result = new int[k];
        int index=0;
        while (!minHeap.isEmpty()){
            result[index++] = minHeap.poll().getKey();
        }
        return result;
    }
}
