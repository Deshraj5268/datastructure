package linkedlist;

public class AddOneInLinkedList {

    public static void main(String[] args) {
        LinkedListOpd  list = new LinkedListOpdImpl();
        list.addNode(9);
        list.addNode(4);
        //list.addNode(20);

        list.display(list.getHead());
        System.out.println();
        ListNode newHead = addOne(list.getHead());
        list.display(newHead);
    }

    public static ListNode addOne(ListNode head) {
        LinkedListOpd linkedListOpd = new LinkedListOpdImpl();
        // code here.
        if(head == null){
            return head;
        }
        ListNode revNode = linkedListOpd.reverseListItr(head);

        int carry = 1;
        int sum = 0;
        ListNode temp = revNode;
        ListNode prev = temp;
        while(temp != null){
            prev = temp;
            sum = carry + temp.data;

            carry = sum / 10;
            temp.data = sum % 10;
            temp = temp.next;
        }
        if(carry > 0){
            prev.next = new ListNode(carry, null);
        }
        ListNode newNode = linkedListOpd.reverseListItr(revNode);
        return newNode;

    }
}
