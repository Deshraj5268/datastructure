package linkedlist;

public class MergeTwoSortedList {


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
