package gfg.arrays;

import java.util.*;

public class KthSmallest {

    //k<n
    public static int kthSmalletUsingSorting(int [] arr,int k){
        if(arr == null || arr.length == 0){
            return 0;
        }
        Arrays.sort(arr);
        return arr[k-1];
    }

    public static int kthSmallUsingMaxHeap(int [] arr,int k){
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            maxHeap.offer(arr[i]);
        }
        for(int  j=k;j<arr.length;j++){
            if(maxHeap.peek() > arr[j]){
                maxHeap.poll();
                maxHeap.offer(arr[j]);
            }
        }
        return maxHeap.poll();

    }



    public static void main(String[] args) {
        int [] arr = {7 ,10, 4, 3, 20, 15};
        int k = 3;
        int kthsmall = kthSmalletUsingSorting(arr,k);
        System.out.println("using sorting "+kthsmall);
        int kthsmall1 = kthSmallUsingMaxHeap(arr,k);
        System.out.println("using maxHeap "+kthsmall);
        /*Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        while (t-- > 0) {
            int n = kb.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = kb.nextInt();
            }
            int k = kb.nextInt();
            int kthMin = kthSmalletUsingSorting(arr, k);
            System.out.println(kthMin);
        }*/
    }

}
