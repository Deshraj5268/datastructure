package linkedlistproblem;

public class LinkedListOpdImpl implements LinkedListOpd {

     private ListNode first;
     private ListNode last;
     private ListNode head;
     private int size;

    public ListNode getFirst() {
        return first;
    }

    public void setFirst(ListNode first) {
        this.first = first;
    }

    public ListNode getLast() {
        return last;
    }

    public void setLast(ListNode last) {
        this.last = last;
    }

    @Override
    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void addLast(int date){
        if(head == null){
            first = last = head = new ListNode(date,null);
            size++;
            return;
        }
        ListNode temp = new ListNode(date,null);
        last.next = temp;
        last = temp;
        size++;
    }

    @Override
    public void display(ListNode head){
        if(head == null){
            return;
        }
        ListNode temp =  head;
        while (temp != null){
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
    }

    @Override
    public void addFirst(int date){
        if(head == null){
            head = first = last = new ListNode(date,null);
            size++;
            return;
        }
        ListNode temp = new ListNode(date,null);
        temp.next = first;
        temp.next = head;
        first = temp;
        head = temp;
        size++;
    }

    @Override
    public void addNode(int data, int index){
        ListNode node = new ListNode(data,null);
        if(head == null || index == 0){
            head = first = node;
            size++;
            return;
        }
        ListNode temp = head;
        int count = 1;
        while (temp.next != null && count<index){
            temp = temp.next;
            count++;
        }
        temp.next = node;
        last = node;
        size++;
    }

    @Override
    public void addNode(int data){
        addLast(data);
    }

    @Override
    public  ListNode deleteEleExceptLast(ListNode node){
        if(node == last){
            return null;
        }
        ListNode temp = new ListNode(node.data,null);
        node.next = node.next.next;
        return temp;
    }

    @Override
    public ListNode findNthNodeFromlast(ListNode head,int n){
        if(head == null){
            return null;
        }
        int c=0;
        ListNode pthNOde = head;
        ListNode nthNode = head;
        while (pthNOde != null){
            if(c >= n){
                nthNode = nthNode.next;
            }
            pthNOde = pthNOde.next;
            c++;
        }
        if(c >= n){
            return nthNode;
        }
        return null;
    }

    /*@Override
    public ListNode deleteNodeAddress(ListNode node){
        ListNode temp = null;
        //one node check
        if(head == null){
            return null;
        }
        if(head.next == null){
            temp = node;
            head = first = last = null;
            return temp;
        }
        temp = head;
        while (temp.next != null && temp != node){
            temp = temp.next;
        }
        
        ListNode resultNode = temp.next;
        temp.next = null;
        last = temp;
        return resultNode;
    }*/



}
