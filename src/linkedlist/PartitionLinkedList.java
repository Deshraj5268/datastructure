package linkedlist;

public class PartitionLinkedList {

    public ListNode partition(ListNode node, int x) {
        if(node == null || node.next == null){
            return node;
        }
        ListNode lHead,lTail,hHead,hTail,current;
        lHead=lTail=hHead=hTail=null;
        current = node;

        while(current != null){
            if(current.data < x){
                if(lHead == null){
                    lTail = lHead = current;
                }else{
                    lTail.next = current;
                    lTail = lTail.next;
                }
            }else {
                if(hHead == null){
                    hTail = hHead = current;
                }else{
                    hTail.next = current;
                    hTail = hTail.next;
                }
            }
            current = current.next;
        }

        if(hTail != null){
            hTail.next = null;
        }

        if(lTail == null){
            return hHead;
        }
        lTail.next = hHead;
        return lHead;


    }
}
