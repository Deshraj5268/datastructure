package src.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestNumber {

    public static void main(String[] args) {
        int [] arr = {7,10,3,4,24,15};
        int k = 3;
        System.out.println("input : "+ Arrays.toString(arr));
        int result = getKthSmallestNumber(arr,k);
        System.out.println("result : "+result);
    }

    public static int getKthSmallestNumber(int [] arr,int k){
        if(arr == null || arr.length < k){
            return -1;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int index=0;index<arr.length;index++){
            if(maxHeap.size() < k){
                maxHeap.add(arr[index]);
            }else {
                if(maxHeap.peek() > arr[index]){
                    maxHeap.poll();
                    maxHeap.add(arr[index]);
                }
            }
        }
        return maxHeap.poll();
    }
}
