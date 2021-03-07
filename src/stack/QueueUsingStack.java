package stack;

import java.util.Stack;



/*
* In Enqueue operation push element in s1 when there is
* dequeue operation pop all the element of s1 and push in second stack return top element of s2
* */
public class QueueUsingStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueUsingStack(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public static void main(String[] args) {
        QueueUsingStack qu = new QueueUsingStack();
        qu.enqueue(2);
        qu.enqueue(3);
        qu.enqueue(4);
        qu.enqueue(5);
        qu.enqueue(6);
        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());//queue is empty
    }

    /*
    * load distributor algo
    *
    * 1.  pop element from stack 2 (s2) until s2 is empty
    * 2.  poped element pushed into s1 stack
    * 3.  push new element in s1
    * */
    public void enqueue(int val){
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        s1.push(val);
    }

    /*
     * load distributor algo
     *
     * 1.  pop element from stack 1 (s1) until s1 is empty
     * 2.  return poped element from s2 stack
     * */
    public int dequeue(){
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return (s2.isEmpty()?-1:s2.pop());
    }
}
