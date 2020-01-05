package graph;

import java.util.LinkedList;
import java.util.Queue;

public class PrintJumpingNumber {

    public static void printJumpingNum(int x){
        System.out.print(0+ " ");
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1;(i<=9 && i<=x);i++){
            queue.offer(i);
        }
        int value;
        while (!queue.isEmpty() && queue.peek() <= x){
            System.out.print(queue.peek() +" ");
            value = queue.poll();
            if(value == 0){
                queue.offer((value*10)+(value%10+1));
            }else if(value == 9){
                queue.offer((value*10)+(value%10-1));
            }else {
                queue.offer((value*10)+(value%10-1));
                queue.offer((value*10)+(value%10+1));
            }
        }
    }

    public static void main(String[] args) {
        int x = 125;
        printJumpingNum(x);
    }
}
