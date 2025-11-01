package linkedlist;


public class MergeTwoSortedList {


    public static void main(String[] args) {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode l1 = new ListNode();
        l1.data = 10;
        l1.next = new ListNode();
        l1.next.data = 20;

        ListNode l2 = new ListNode();
        l2.data = 1;
        /*l2.next = new ListNode();
        l2.next.data = 2;*/


        ListNode newHead = mergeTwoSortedList.mergeListItr(l1,l2);
        mergeTwoSortedList.display(newHead);
    }

    public void display(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public ListNode mergeSortedList(ListNode l1,ListNode l2){
        if (l1 == null) {
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.data <= l2.data){
            l1.next = mergeSortedList(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeSortedList(l1,l2.next);
            return l2;
        }
    }

    public ListNode mergeListItr(ListNode l1,ListNode l2){
        ListNode dummyNode = new ListNode();
        ListNode newHead = dummyNode;
        while(l1 != null && l2 != null){
            if(l1.data <= l2.data){
                dummyNode.next = l1;
                dummyNode = dummyNode.next;
                l1 = l1.next;
            }else{
                dummyNode.next = l2;
                dummyNode = dummyNode.next;
                l2 = l2.next;
            }
        }
         if(l1 == null){
            dummyNode.next = l2;
        }else {
            dummyNode.next = l1;
        }
        return newHead.next;
    }

    public static FlattenNode mergeSortedList(FlattenNode l1,FlattenNode l2){
        if (l1 == null) {
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.data <= l2.data){
            l1.down = mergeSortedList(l1.down,l2);
            return l1;
        }else {
            l2.down = mergeSortedList(l1,l2.down);
            return l2;
        }
    }
}
