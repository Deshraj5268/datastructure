package queue.dequeue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


/*
* https://www.naukri.com/code360/problems/first-negative-in-every-window_759333?leftPanelTabValue=PROBLEM
* */
public class FirstMinInKWinSize {

    //First negative integer in every window of size k
    public static void firstMinInWindowSizeK(int [] arr,int n,int k){

        if(n<k){
            return ;
        }
        int min;
        for(int i=1;i<n-k;i++){
            min = arr[i-1];
            for(int j=i-1;j<(i+k-1);j++){
                if(min > arr[j]){
                    min  = arr[j];
                }
            }
            if(min < 0){
                System.out.print(min +" ");
            }else{
                System.out.println(0+" ");
            }
        }
    }

    public static int [] findMinInWinKSize(int [] arr, int k){
        Deque<Integer> dq = new LinkedList<>();
        int [] result = new int[arr.length - k+1];
        int j = 0;
        for(int i=0;i<arr.length;i++){
            // re,ove use less element
            while (!dq.isEmpty() && (i+1-k ) > dq.peekFirst()){
                dq.removeFirst();
            }
            if(arr[i] < 0){
                dq.addLast(i);
            }

            if(i+1 >= k){
                if(dq.isEmpty()){
                    result[j++] = 0;
                }else {
                    result[j++] = arr[dq.peekFirst()];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {-8, 2, 3, -6 ,10};
        int k = 2;
        int [] result = findMinInWinKSize(arr,k);
        System.out.println("result : "+ Arrays.toString(result));
        firstMinInWindowSizeK(arr,arr.length,k);
    }
}
