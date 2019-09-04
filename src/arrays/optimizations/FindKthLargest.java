package arrays.optimizations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthLargest {

    public static int [] findKthLargestElements(int [] arr,int k){
        if(k < 0 || arr == null || arr.length == 0 || k> arr.length){
            return new int[0];
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue(k);
        int i=0;
        while(i<k){
            minHeap.offer(arr[i]);
            i++;
        }
        while (i<arr.length){
            if(arr[i]>minHeap.peek()){
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
            i++;
        }
        int [] result = new int[k];
        for(int j = k-1;j>=0;j--){
            result[j]= minHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {11, 3, 2, 1, 15, 5, 4,
                45, 88, 96, 50, 45 };
        int k=10;
        int [] result = findKthLargestElements(arr,k);
        System.out.println(Arrays.toString(result));

    }
}
