package linkedlistproblem;

import java.util.LinkedHashMap;

public class CloningWithRandomRef {

    public ListNode copyListUsingNextRefCopy(ListNode head1){
        ListNode head2 = null;
        if(head1 == null || head1.next == null){
            head2 = head1;
            return head2;
        }
        ListNode temp = head1;
        ListNode newNode2 = null;
        //creating node
        while (temp != null){
            newNode2 = new ListNode(temp.data,temp.next);
            if(head2 == null){
                head2 = newNode2;
            }
            //newNode2.next = temp.next;
            temp = temp.next;
        }
        //random pointer copy
        temp = head1;
        //ListNode temp2 = head2;
        while (temp != null){
            temp.next = temp.next.next;

        }

        return null;

    }

    public static void main(String[] args) {
       // LinkedHashMap lh =
    }
}
