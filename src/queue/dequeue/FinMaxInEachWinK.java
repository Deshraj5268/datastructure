package queue.dequeue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

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

    public static void main(String[] args) {
        /*int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;*/
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int [] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            findMaxFromEachWinK(arr,arr.length,k);
        }

       // findMaxFromEachWinK(arr,arr.length,k);
    }
}
