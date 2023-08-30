package graph;

import java.util.LinkedList;
import java.util.Queue;

public class PrintJumpingNumber {

    public static void printSpacialNumber(int x){
        System.out.print(0+ " ");
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1;(i<=9 && i<=x);i++){
            queue.offer(i);
        }
        int value;
        int nextNumber;
        int prevNumber;
        while (!queue.isEmpty() && queue.peek() <= x){
            System.out.print(queue.peek() +" ");
            value = queue.poll();
            nextNumber = (value*10)+(value%10+1);
            prevNumber = (value*10)+(value%10-1);
            if(value%10 == 0){
                queue.offer(nextNumber);
            }else if(value%10 == 9){
                queue.offer(prevNumber);
            }else {
                queue.offer(nextNumber);
                queue.offer(prevNumber);
            }
        }
    }

    public static void printSpacialNumber(int m, int n){
        System.out.print(0+ " ");
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1;(i<=9 && i<=m);i++){
            queue.offer(i);
        }
        int value;
        int nextNumber;
        int prevNumber;
        while (!queue.isEmpty() && queue.peek() <= n){
           if(queue.peek()>=m) {
               System.out.print(queue.peek() + " ");
           }
            value = queue.poll();
            nextNumber = (value*10)+(value%10+1);
            prevNumber = (value*10)+(value%10-1);
            if(value%10 == 0){
                queue.offer(nextNumber);
            }else if(value%10 == 9){
                queue.offer(prevNumber);
            }else {
                queue.offer(nextNumber);
                queue.offer(prevNumber);
            }
        }
    }

    public static void main(String[] args) {
        int x = 105;
      //  printJumpingNum(x);
        printSpacialNumber(12,100);
    }
}
