package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

/*Given a sorted array arr[] and a value X, find the k closest elements to X in arr[].
* Note that if the element is present in array, then it should not be in output,
* only the other closest elements are required.
* */



public class KClosestOfEleX {

    static class CustomHeap  {
        int heapVal;
        int val;

        public CustomHeap(int heapVal, int val) {
            this.heapVal = heapVal;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        //sorted array
        int [] arr = {10, 2, 14, 4, 7, 6};//{12, 16, 22, 30, 35, 38,39, 42,45, 48, 50, 53, 55, 56};
        int x = 5;
        int k = 3;
        int [] result = kClosetElementOfX(arr,k,x);
        System.out.println(Arrays.toString(result));
    }


/** solution :
 * create max heap for k element(without including target x)
 * loop for remaining element (n-k)
 * 1.if current element less than peak element without including target x
 *      poll element and add current element
 *
* */

    public static int [] kClosetElementOfX(int []arr,int k,int x){
        if(arr == null || arr.length == 0 || (k > 0 && k > arr.length)){
            return new int[0];
        }
        int [] resultArr = new int[k];
        PriorityQueue<CustomHeap> maxQueue = new PriorityQueue<>(k, (obj1,obj2)-> (obj2.heapVal- obj1.heapVal)); // max heap
        int i=0;
        for(;i<arr.length;i++){
            if(maxQueue.isEmpty()){
                CustomHeap customHeap = new CustomHeap(Math.abs(x-arr[i]),arr[i]);
                maxQueue.add(customHeap);
            }else if(maxQueue.size() == k){
                break;
            }else if(arr[i] != x) {
                CustomHeap customHeap = new CustomHeap(Math.abs(x-arr[i]),arr[i]);
                maxQueue.add(customHeap);
            }
        }
        int temp = 0;
        for(int j = i;j<arr.length;j++){
            temp =  Math.abs(arr[j]-x);
            if((!maxQueue.isEmpty() && maxQueue.peek().heapVal > temp) && arr[j] != x){
                maxQueue.poll();
                maxQueue.add(new CustomHeap(temp,arr[j]));
            }
        }
        while (!maxQueue.isEmpty()){
            resultArr[--k] = maxQueue.poll().val;
        }
        return resultArr;
    }
}
