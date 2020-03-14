package linkedlist;

public class LinkedListOpdImpl implements LinkedListOpd {

    private ListNode last;
    private ListNode head;
    private int size;

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
    public ListNode findNthNodeFromlast(ListNode head, int n){
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

}
