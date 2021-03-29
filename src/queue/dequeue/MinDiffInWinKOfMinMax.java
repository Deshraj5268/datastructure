package queue.dequeue;

import java.util.Deque;
import java.util.LinkedList;

public class MinDiffInWinKOfMinMax {

    static Deque<Integer> minDeque;
    static Deque<Integer> maxDeque;

    public static void main(String[] args) {

        int [][] mat = {
                { 3, 2, 4, 5, 6, 1, 9 }
                ,{ 1, 2, 3, 3, 2, 2  }
                ,{4,4,4,4,4,}
                ,{1,2,3,4,5,6,7}
                ,{7,6,5,4,3,2,1}
        };
        int [] kValueArr = {3,4,3,3,3};
        MinDiffInWinKOfMinMax minDiff = new MinDiffInWinKOfMinMax();
        for(int i=0;i<mat.length;i++){
            minDeque = new LinkedList<>();
            maxDeque = new LinkedList<>();
            int result =  minDiff.MinDiffInWinSizeKOfMinMaxElement(mat[i],mat[i].length,kValueArr[i]);
            System.out.println(result);
        }

    }

    public int MinDiffInWinSizeKOfMinMaxElement(int [] arr,int n,int k){

        if(k <= 1 || k > n){
            return 0;
        }
        // insert k element in both Deque
        int i=0;
        while(i<k){
            removeUnOrderedLastElementsFromMinDeque(minDeque,arr,i);
            minDeque.addLast(i);

            removeUnOrderedLastElementsFromMaxDeque(maxDeque,arr,i);
            maxDeque.addLast(i);

            i++;
        }

        int globalMin = minDiff(arr[maxDeque.peekFirst()], arr[minDeque.peekFirst()]);

        while(i<n){
            //remove useless from minDeque
            removeUseless(minDeque,i,k);
            removeUnOrderedLastElementsFromMinDeque(minDeque,arr,i);
            minDeque.addLast(i);

            //remove useless from maxDeque
            removeUseless(maxDeque,i,k);
            removeUnOrderedLastElementsFromMaxDeque(maxDeque,arr,i);
            maxDeque.addLast(i);

            globalMin = Math.min(globalMin,minDiff(arr[maxDeque.peekFirst()],arr[minDeque.peekFirst()]));

            i++;
        }

        return globalMin;
    }

    private int minDiff(int first, int second) {
        return first-second;
    }

    /*
     * remove useless element(front ) from queue
     * */
    private void removeUseless(Deque<Integer> deque, int i, int k){
        while(!deque.isEmpty() && (i-k) >= deque.peekFirst()){
            deque.removeFirst();
        }
    }

    /*
     * remove element until find min
     * */
    private void removeUnOrderedLastElementsFromMinDeque(Deque<Integer> minDeque,int [] arr,int i){
        while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[i]){
            minDeque.removeLast();
        }
    }


    private void removeUnOrderedLastElementsFromMaxDeque(Deque<Integer> maxDeque,int [] arr,int i){
        while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[i]){
            maxDeque.removeLast();
        }
    }


}
