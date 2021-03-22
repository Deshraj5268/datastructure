package arrays.sortingsearching;

import linkedlist.LinkedListOpd;
import linkedlist.LinkedListOpdImpl;
import linkedlist.ListNode;
import linkedlist.MergeTwoSortedList;

public class LinkedListMergerSort {
    static LinkedListOpd list = new LinkedListOpdImpl();
    static MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();

    public static void main(String[] args) {
        int [] arr = {1,5,6,9,11,4,2};
        ListNode head = list.arrayToList(arr);
        ListNode sortedHeadNode = mergeSort(head);
        list.display(sortedHeadNode);
    }

    public static ListNode mergeSort(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode middleNode = list.findMiddleWithNullEnded(head);
        ListNode nextOfMiddle = middleNode.next;
        middleNode.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextOfMiddle);
        ListNode sortedList = mergeTwoSortedList.mergeSortedList(left,right);
        return sortedList;
    }


}
