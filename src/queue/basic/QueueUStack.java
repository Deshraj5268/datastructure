package queue.basic;

import java.util.Stack;

public class QueueUStack {

    public static Stack<Integer> stack1;
    public static Stack<Integer> stack2;

    public static void main(String[] args) {

        stack1 = new Stack<>();
        stack2 = new Stack<>();
        deQueueCostly();
        enQueueLight(10);
        enQueueLight(20);
        enQueueLight(30);
        deQueueCostly();
        deQueueCostly();

        System.out.println("  dequeue light and enqueue costly :");
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        deQueueLight();
        enQueueCostly(10);
        enQueueCostly(20);
        enQueueCostly(30);
        deQueueLight();
        deQueueLight();

        System.out.println("  dequeue and enqueue optimized:");
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        deQueue();
        enQueue(10);
        enQueue(20);
        enQueue(30);
        deQueue();
        deQueue();
        peek();
        isEmpty();

    }

    /*
     * s1->s2
     * s2 -> pop
     * s2->s1
     * */
    public static int deQueueCostly(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int temp = stack2.isEmpty()? -1: stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        System.out.println("deQueued : "+temp);
        return temp;
    }

    /*
     * push data into s1
     * */
    public static void enQueueLight(int data){
        System.out.println("queued : "+data);
        stack1.push(data);
    }

    /*
     * s2->s1
     * s1<-data
     * s1->s2
     * */
    public static void enQueueCostly(int data){
        System.out.println("queued : "+data);
        while(!stack2.isEmpty()){
            stack1.push((stack2.pop()));
        }
        stack1.push(data);
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    /*
     * pop from s2
     * */
    public static int deQueueLight(){
        int temp =  stack2.isEmpty()? -1:stack2.pop();
        System.out.println("dequeued : "+temp);
        return temp;
    }


    public static void moveElementS1ToS2(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    /*
    * s2->s1
    * s1<-data
    * */
    public static void enQueue(int data){
        System.out.println("queued : "+data);
        while(!stack2.isEmpty()){
            stack1.push((stack2.pop()));
        }
        stack1.push(data);
    }

    /*
    * s1-> s2
    * pop from s2
    * */
    public static int deQueue(){
        moveElementS1ToS2();
        int temp = stack2.isEmpty() ? -1 : stack2.pop();
        System.out.println("dequeued : "+temp);
        return temp;
    }

    public static int peek(){
        moveElementS1ToS2();
        int temp = stack2.isEmpty() ? -1 : stack2.peek();
        System.out.println("peek : "+temp);
        return temp;
    }

    public static boolean isEmpty(){
        return (stack1.isEmpty() && stack2.isEmpty());
    }
}


