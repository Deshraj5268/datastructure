package heap;

import java.util.*;

/*
*
* https://leetcode.com/problems/sliding-window-median/description/
* */
public class MedianInSlidingWindow {

    private PriorityQueue<Long> minHeap = new PriorityQueue<>();
    private PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private Map<Long, Long> delayedRemovalMap = new HashMap<>();
    private int leftMaxHeapElementCount = 0; // for balancing and valid data
    private int rightMinHeapElementCount = 0;

   public MedianInSlidingWindow(){
       this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
       this.minHeap = new PriorityQueue<>();
       this.delayedRemovalMap = new HashMap<>();
       this.leftMaxHeapElementCount = 0;
       this.rightMinHeapElementCount = 0;
   }
    public static void main(String[] args) {
        MedianInSlidingWindow medianInSlidingWindow = new MedianInSlidingWindow();
        int [][] mat = {{1,3,-1,-3,5,3,6,7},
                {1,2,3,4,2,3,1,4,2}
        ,{2147483647,2147483647}};
        int [] kArr = {3,3,2};
        for (int i = 0; i < mat.length; i++) {
            medianInSlidingWindow = new MedianInSlidingWindow();
            double [] medianArr = medianInSlidingWindow.medianSlidingWindow(mat[i], kArr[i]);
            System.out.println(Arrays.toString(medianArr));
        }
    }


    /*
    * Use same logic to calculate median and Store out of window data into map
    * remove element if we get Peek data
    * */
    public double[] medianSlidingWindow(int[] nums, int k) {
        double [] medians = new double[nums.length-k +1];
        for(int i=0;i<nums.length;i++){
            addNum(nums[i]);
            balanceHeap();

            storeDelayedData(nums , i, k);

            cleanTopDataOfOutOffHeap(maxHeap);
            cleanTopDataOfOutOffHeap(minHeap);
            balanceHeap();
            if(i+1 >= k) {
                medians[i+1 - k] = getMedian(k);
            }

        }
        return medians;

    }

    private double getMedian(int k) {
        if(k%2 == 0){ // even
            return (long)(maxHeap.peek() + (long) minHeap.peek()) /2.0;
        }
        return maxHeap.peek();
    }

    private void cleanTopDataOfOutOffHeap(PriorityQueue<Long> heap) {
        while (!heap.isEmpty() && delayedRemovalMap.containsKey(heap.peek())){
            long peekElement = heap.peek();
            delayedRemovalMap.put(peekElement, delayedRemovalMap.get(peekElement)-1); // decrease count by one
            if(delayedRemovalMap.get(peekElement) == 0){
                delayedRemovalMap.remove(peekElement);
            }
            heap.poll();
        }
    }

    private void storeDelayedData(int [] nums, int currentIndex, int k) {
        if(currentIndex >= k) {
            long toRemove = nums[currentIndex-k];
            delayedRemovalMap.put(toRemove, delayedRemovalMap.getOrDefault(toRemove, 0L) + 1);
            if(toRemove <= maxHeap.peek()){
                leftMaxHeapElementCount--;
            }else {
                rightMinHeapElementCount--;
            }
        }
    }

    private void balanceHeap() {
        if(leftMaxHeapElementCount > rightMinHeapElementCount +1){
            minHeap.add(maxHeap.poll());
            leftMaxHeapElementCount--;
            rightMinHeapElementCount++;
        }else if (leftMaxHeapElementCount < rightMinHeapElementCount){
            maxHeap.add(minHeap.poll());
            leftMaxHeapElementCount++;
            rightMinHeapElementCount--;
        }
    }

    /*
    * max heap     | minHeap
    * */
    public  void addNum(long num){
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
            leftMaxHeapElementCount++;
        }else {
            minHeap.add(num);
            rightMinHeapElementCount++;
        }
    }
}
