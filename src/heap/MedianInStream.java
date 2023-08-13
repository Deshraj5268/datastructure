package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;


/*
* https://leetcode.com/problems/find-median-from-data-stream/
* */
public class MedianInStream {

    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {
        int [] arr = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        MedianInStream median = new MedianInStream();
        for(int i=0;i<arr.length;i++){
            median.addNum(arr[i]);
            System.out.println("median as of now "+median.findMedian() + " till index "+i);
        }
    }

    /*
    * first approach use add element in insertion sorted manner and calculate median
    * */

    /*
    *  -----max heap----| ------min heap print from starting  so it form sorted data stream at given point
    * first insert into max heap of left side
    * before adding data in Max first check if minHeap data is less than the current
    *   then temp = delete.minHeap
    *        minHeap.add(element)
    *       maxHeap.add(temp);
    *   else max.add(element);
    * */
    public void addNum(int num) {
        int temp;

        //for max heap (left side )
        if((maxHeap.size()+minHeap.size())%2 == 0){
            if(!minHeap.isEmpty() && minHeap.peek() < num){
                temp = minHeap.poll();
                minHeap.offer(num);
                maxHeap.offer(temp);
            }else{
                maxHeap.offer(num);
            }
        }else{
            if(!maxHeap.isEmpty() && maxHeap.peek() > num){
                temp = maxHeap.poll();
                maxHeap.offer(num);
                minHeap.offer(temp);
            }else{
                minHeap.offer(num);
            }

        }
        // System.out.println(maxHeap.peek() + " "+minHeap.peek());

    }

    public double findMedian() {

        //System.out.println("max heap "+maxHeap + " size "+maxHeap.size()+ " \n min heap  "+minHeap +" size "+minHeap.size());

        if(maxHeap.size() == minHeap.size()){
            return ((double) (minHeap.peek()+maxHeap.peek()))/2;
        }else if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }else{
            return minHeap.peek();
        }

    }
}
