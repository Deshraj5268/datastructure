package linkedlist;

public class PartitionLinkedList {

    public ListNode partition(ListNode node, int x) {
        if(node == null || node.next == null){
            return node;
        }
        ListNode lHead,lTail,rHead,rTail,current;
        lHead=lTail=rHead=rTail=null;
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
                if(rHead == null){
                    rTail = rHead = current;
                }else{
                    rTail.next = current;
                    rTail = rTail.next;
                }
            }
            current = current.next;
        }

        if(rTail != null){
            rTail.next = null;
        }

        if(lTail == null){
            return rHead;
        }
        lTail.next = rHead;
        return lHead;


    }
}
