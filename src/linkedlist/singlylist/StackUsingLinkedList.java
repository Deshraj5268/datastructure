package linkedlist.singlylist;

import linkedlist.ListNode;

public class StackUsingLinkedList {
    
    ListNode top;
    
    public StackUsingLinkedList(ListNode top){
        this.top = top;
    }

    public static void main(String[] args) {
        StackUsingLinkedList list = new StackUsingLinkedList(null);
        list.enqueue(1);
        list.enqueue(2);
        list.enqueue(3);
        list.enqueue(4);
        list.enqueue(5);

        System.out.println("pop : ");
        System.out.println(list.dequeue().data);
        System.out.println(list.dequeue().data);
        System.out.println(list.dequeue().data);
        System.out.println(list.dequeue().data);
        System.out.println(list.dequeue().data);
        System.out.println(list.dequeue().data);

    }
    
    /*
    * create new node
    * node.next point to top of stack
    * top point to newNode;
    * 
    *       newNode
    *         |
    *         |
    *         V
    *        top
    * 
    * */
    public void enqueue(int val){
        ListNode node = new ListNode(val,null);
        if(top == null){
           top = node;
           return;
        }
        node.next = top;
        top = node; 
    }
    
    public ListNode dequeue(){
        if(top == null){
            return new ListNode(-1,null);
        }
        ListNode temp = top;
        top = top.next;
        return temp;
    }
}
