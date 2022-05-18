package linkedlist;

import dp.LIS;

public class LinkedListOpdImpl implements LinkedListOpd {

    private ListNode last;
    private ListNode head;
    private int size;
    private ListNode newHead;


    public ListNode arrayToList(int [] arr){
        this.head = null;
        for (int data:arr){
            addLast(data);
        }
        return head;
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

    public ListNode getNewHead() {
        return newHead;
    }

    public void setNewHead(ListNode newHead) {
        this.newHead = newHead;
    }

    @Override
    public ListNode addLast(int date){
        if(head == null){
            last = head = new ListNode(date,null);
            size++;
            return head;
        }
        ListNode temp = new ListNode(date,null);
        last.next = temp;
        last = temp;
        size++;
        return temp;
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
    public ListNode addFirst(int date){
        if(head == null){
            head  = last = new ListNode(date,null);
            size++;
            return head;
        }
        ListNode temp = new ListNode(date,null);
        temp.next = head;
        head = temp;
        size++;
        return temp;
    }

    @Override
    public ListNode removeFirstNode(ListNode head){
        if(head == null){
            return head;
        }
        if(head.next == null){
            this.head = this.last = null;
            size--;
            return head;
        }
        size--;
        ListNode temp = head;
        this.head = head.next;
        temp.next = null;
        return temp;
    }

    @Override
    public ListNode removeLast(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            this.head = this.last = null;
            size--;
            return head;
        }
        ListNode temp = head;
        ListNode prev = head;
        while (temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        last = prev;
        size--;
        return temp;
    }
    
    @Override
    public ListNode remove(ListNode head,int data){
        if(head == null){
            return null;
        }
        if(head.data == data){
            this.head = head.next;
            if(head.next == null){
                last = null;
            }
            head.next = null;
            return head;
        }
        ListNode temp = head;
        ListNode prev = head;
        while (temp != null && data != temp.data){
            prev= temp;
            temp = temp.next;
        }
        if(temp != null && data == temp.data){
            prev.next = temp.next;
            size--;
            if(temp.next == null){
                last = prev;
            }
            temp.next = null;
            return temp;
        }
        return null;
    }

    @Override
    public  ListNode deleteEleExceptLast(ListNode node){
        if(node == last){
            return null;
        }
        size--;
        ListNode temp = new ListNode(node.data,null);
        node.data = node.next.data;
        node.next = node.next.next;
        return temp;
    }

    @Override
    public ListNode insertion(int data){
        ListNode node = new ListNode(data,null);
        if(head == null){
            head  = node;
            size++;
            return head;
        }
        ListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        last = node;
        return node;
    }

    @Override
    public ListNode addNode(int data, int index){
        ListNode node = new ListNode(data,null);
        if(index < 1){
            return null;
        }
        if(head == null && index == 1){
            last = head  = node;
            size++;
            return head;
        }
        if(head == null){
            return null;
        }
        ListNode temp = head;
        int count = 1;
        ListNode prev = head;
        while (temp != null && count < index){
            prev = temp;
            temp = temp.next;
            count++;
        }
        if(count == index){
            prev.next = node;
            if(temp == null || temp.next == null){
                last = node;
            }
            size++;
            return node;
        }
        return null;
    }

    @Override
    public ListNode addNode(int data){
        return addLast(data);
    }

    @Override
    public ListNode findNthNodeFromLast(ListNode head, int n){
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

    public ListNode findMiddleWithNullEnded(ListNode head){
        if(head == null){
            return head;
        }
        ListNode f=head,s=head;
        while (s.next != null && s.next.next != null){
            f = f.next;
            s = s.next.next;
        }
        return f;
    }


    @Override
    public ListNode findMiddleNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode f = head;
        ListNode s = head;
        while (f.next != null && s.next.next != null){
            f = f.next;
            s = s.next.next;
            if(s.next == null){
                return f;
            }
        }
        return f;
    }

    /*
    *
    * x % L = z proof
    * L = y+z ( loop length)
    * slow
    *
    * L+L+a = temp
    * temp%L -> a
    * a = z
    *
    * or
    *  2(x*Y) = x+y+z+y
    *  x = z
    *
    * https://www.youtube.com/watch?v=9YTjXqqJEFE
    * https://www.youtube.com/watch?v=gBTe7lFR3vc&list=PLot-Xpze53leU0Ec0VkBhnf4npMRFiNcB&index=17
    *
    * fast = 2 ,s = 1, loop length = n
    *
    * n+(1-2) ~ n-1 ( s move 1 step increase and f will decrease speed by 2 )
    * so every time lenth will reduce by 1 . so O(n)
    * */
    @Override
    public boolean isLoopExist(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        if(head.next == head){
            return true;
        }
        ListNode f = head;
        ListNode s = head;
        while (f != null && s.next != null){
            s = s.next.next;
            if(s == null){
                return false;
            }
            if(s == f){
                return true;
            }
            f = f.next;
        }
        return false;
    }


    public int findLength(ListNode head){
        if(head == null){
            return 0;
        }
        ListNode temp = head;
        int count=0;
        while (temp!= null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    @Override
    public ListNode findMiddleNodeUsingLength(ListNode head){
        int length = findLength(head);
        if(length == 0){
            return null;
        }
        int count = 0;
        int mid = length/2;
        ListNode temp = head;
        while (temp != null && mid != ++count){
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverseListItr(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode nextNode = null;
        ListNode newHead = null;
        while (head != null){
            nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    public ListNode reverseListRec(ListNode head){
        /*if(head == null){
            return null;
        }
        ListNode nextNode = head.next;
        head.next = newHead;
        newHead = head;
        return reverseListRec(nextNode);*/
        ListNode newHead = null;
        newHead = reverseRecUtil(head,newHead);
        return newHead;

    }

    public ListNode reverseRecUtil(ListNode head,ListNode newHead){
        if(head == null){
            return newHead;
        }
        ListNode nextNode = head.next;
        head.next = newHead;
        newHead = head;
        return reverseRecUtil(nextNode,newHead);
    }

    public int findLengthOfList(ListNode head){
        ListNode temp = head;
        int c = 0;
        while (temp != null){
            temp = temp.next;
            c++;
        }
        return c;
    }

    @Override
    public ListNode reverseGroupOfKNode(ListNode head,int k,int remainingLength){
        if(head == null){
            return head;
        }
        ListNode current,nextNode,prev;
        current = head;
        nextNode = prev = null;
        int c = 0;

        if((remainingLength-k) >= 0) {
            while (c < k && current != null) {
                nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
                c++;
            }
        }else{
            return head;
        }

        if(nextNode != null){
            head.next = reverseGroupOfKNode(nextNode,k,remainingLength-k);
        }
        return prev;
    }


}
