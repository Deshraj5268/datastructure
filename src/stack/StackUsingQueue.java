package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
     Queue<Integer> q1;
     Queue<Integer>  q2;
     Queue<Integer> singleQu;
    public StackUsingQueue(){
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
        this.singleQu = new LinkedList<>();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


        System.out.println("Using single queue : ");
        stack.pushUsingSingleQueue(1);
        stack.pushUsingSingleQueue(2);
        stack.pushUsingSingleQueue(3);
        stack.pushUsingSingleQueue(4);
        System.out.println(stack.popUsingSingleQueue());
        System.out.println(stack.popUsingSingleQueue());
        System.out.println(stack.popUsingSingleQueue());
        System.out.println(stack.popUsingSingleQueue());
        System.out.println(stack.popUsingSingleQueue());
    }

    public void swapQueueReferences(Queue<Integer> q1,Queue<Integer> q2){
        Queue<Integer> temp = q1;
        this.q1 = q2;
        this.q2 = temp;
    }

    /*
    * insert new data in empty queue(q1)
    * then dequeue all elements fro q2 and insert into q1
    * *  Swap the queue references
    *
    * here : push operation is costly .. you can changes this in pop
    * */
    public void push(int val){
        q1.offer(val);
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        swapQueueReferences(q1,q2);
    }


    /*
    * Dequeue the element from q2
    * */
    public int pop(){
        return q2.isEmpty()?-1:q2.poll();
    }

    public void pushUsingSingleQueue(int val){
        singleQu.offer(val);
    }


    /*
    * delete element till size-1 and add in queue,
    * dequeue the element (after size-1 deletion last one will be the poped element
    * */
    public int popUsingSingleQueue(){
        if(singleQu.isEmpty()){
            return -1;
        }
        if(singleQu.size() == 1){
            return singleQu.poll();
        }
        int count = singleQu.size();
        int val;
        while (count != 1){
            val = singleQu.poll();
            singleQu.offer(val);
            count--;
        }
        return singleQu.poll();
    }

}
