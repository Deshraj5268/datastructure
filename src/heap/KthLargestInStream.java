package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestInStream {

    public static void main(String[] args) {

        int k = 4;
        int [][] mat = {
                {1, 2, 3, 4, 5, 6},
                {4, 5, 8, 2,3,5,10,9,4}};

        int n;
        for(int i=0;i<mat.length;i++) {
            n = mat[i].length;
            int[] kthArr = kthLargest(k, mat[i], n);
            System.out.println(Arrays.toString(kthArr));
        }
    }

    /*
    * https://leetcode.com/problems/kth-largest-element-in-a-stream/
    * create min heap for k elements
    * if peek() < current element then remove peek ( i.e out the kth largest element because peek element is lesser
     * Ex (3,4,2) --> 4 3 2 so 2 is kth(3) largest now 6 come ( 6 4 3) and 2 will be removed
    * */
    public static int[] kthLargest(int k, int[] arr, int n) {
        int [] kthArr = new int [n];
        Queue<Integer> minHeap = new PriorityQueue<>();
        int x;
        for(int i = 0;i<n;i++){
            x = arr[i];
            if(minHeap.size() < k){
                minHeap.offer(x);
            }else if(minHeap.peek() < x){
                minHeap.poll();
                minHeap.offer(x);
            }
            if(minHeap.size() >= k){
                kthArr[i] = minHeap.peek();
            }else{
                kthArr[i] = -1;
            }
        }
        return kthArr;
    }
}
