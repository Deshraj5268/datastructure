package linkedlist;


/*
* L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
* */
public class ReorderList {


    public static void main(String[] args) {
        LinkedListOpd  list1 = new LinkedListOpdImpl();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(4);
        list1.addNode(5);
        list1.addNode(6);
        list1.addNode(7);
        list1.addNode(8);
        System.out.println("original list ");
        list1.display(list1.getHead());
        ReorderList list = new ReorderList();
        list.reorderList(list1.getHead());
        System.out.println("\nafter reorder : ");
        list1.display(list1.getHead());
    }

    public void reorderList(ListNode head) {

        if(head == null || head.next == null){
            return ;
        }

        ListNode node1 = head;
        ListNode node3 = findMiddle(head);
        ListNode node2 = node3.next;
        node3.next = null;
        node2 = reverse(node2);

        ListNode node = new ListNode();// dummy node
        ListNode newHead = node;

        while(node1 != null || node2 != null){
            if(node1 != null){
                node.next = node1;
                node = node.next;
                node1 = node1.next;
            }
            if(node2 != null){
                node.next = node2;
                node = node.next;
                node2 = node2.next;
            }
        }
        head = newHead.next;
        //return newHead;

    }

    public ListNode reverse(ListNode node){
        ListNode temp,nextNode;
        temp = nextNode = null;
        while(node != null){
            nextNode = node.next;
            node.next = temp;
            temp = node;
            node = nextNode;
        }
        return temp;
    }

    public ListNode findMiddle(ListNode node){
        ListNode slow,fast;
        slow = fast = node;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
