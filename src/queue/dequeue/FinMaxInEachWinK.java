package queue.dequeue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


/*
* https://algo.monster/liteproblems/239
* https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/?ref=gcse_ind&_gl=1*1fmoph8*_up*MQ..*_gs*MQ..&gclid=CjwKCAjwzMi_BhACEiwAX4YZUGWyiS3B30ECdKocUpuGmfPAvXXmADJXgD3LFxFxMk5gmIiylnm8wxoCV7UQAvD_BwE
* */
public class FinMaxInEachWinK {

    //https://www.youtube.com/watch?v=39grPZtywyQ
    public static void findMaxFromEachWinK(int [] arr,int n,int k){
        if(k>n){
            return ;
        }
        Deque<Integer> deque = new LinkedList<>();
        int i=0;
        while(i<k){
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            i++;
        }
        while (i<n){
            System.out.print(arr[deque.peekFirst()] +" ");
            while (!deque.isEmpty() && deque.peekFirst() <= i-k){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            i++;
        }
        System.out.println(arr[deque.peekFirst()] +" ");
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        int [] result = new int[n-k+1]; // 1 2 3 4 ,n = 4, k=3 result size is 2
        int j = 0;
        for(int i=0;i<n;i++){
            // removing front data until data is out of window
            while(!dq.isEmpty() && (i-k + 1) >dq.peekFirst()) {
                dq.removeFirst();
            }
            if(!dq.isEmpty()){
                System.out.println(dq.peekFirst());
            }
            // removing last element until current data is less than
            while(!dq.isEmpty() &&  nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.add(i);
            // add data into result
            if(i+1 >= k){
                result[j++] = nums[dq.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1, -1};//{ 12, 1, 78, 90, 57, 89, 56 };
        int k = 1;
        /*Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int [] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            findMaxFromEachWinK(arr,arr.length,k);
        }*/

       // findMaxFromEachWinK(arr,arr.length,k);
        int [] result = maxSlidingWindow(arr , k);
        System.out.println(Arrays.toString(result));
    }
}
