package linkedlist.doublylinklist;

public class DLinkedList {
    public DListNode head;
    public DListNode last;
    public DListNode first;
    public int size;

    public DLinkedList(){

    }

    public DListNode getHead() {
        return head;
    }

    public DListNode getFirst() {
        return first;
    }

    public DListNode getLast() {
        return last;
    }

    public DListNode removeNode(DListNode node){
        DListNode result = null;
        if(node == null){
            return result;
        }    
        if(head == node || head.next == null){
            result =  removeFirst();
            return result;
        }
        result = node;
        node.prev.next = node.next;
        result.next = result.prev = null;
        size--;
        return result;
    }


    public DListNode addLast(DListNode node){
        if(head == null){
            head = node;
            size++;
            return node;
        }
        DListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        size++;
        return node;
    }
    
    public DListNode addLast(int data){
        DListNode node = new DListNode(data,null,null);
        if(head == null){
            head = node;
            size++;
            return node;
        }
        DListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        size++;
        return node;
    }
    
    public DListNode removeFirst(){
        if(head == null){
            return null;
        }
        DListNode firstNode = head;
        head = head.next;
        firstNode.next = null;
        size--;
        return firstNode;
    }
}