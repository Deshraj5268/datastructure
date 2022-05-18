package linkedlist;

public class LinkedListDriver {


    public static void main(String[] args) {

        LinkedListOpd  list = new LinkedListOpdImpl();
        list.addNode(10);
        list.addNode(16);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.addNode(50);
        list.display(list.getHead());
        int n =1;
        ListNode nthNode = list.findNthNodeFromLast(list.getHead(),n);
        if(nthNode != null){
            System.out.println(n+"thNode: "+nthNode.data);
        }
        ListNode middleNode = list.findMiddleNode(list.getHead());
        if(middleNode != null) {
            System.out.println("middle Node :"+middleNode.data);
        }

        /*//create loop in linked list
        LinkedListOpd  list1 = new LinkedListOpdImpl();
        list1.addNode(1);
        list1.addNode(8);
        list1.addNode(2);
        ListNode node = list1.addNode(3);
        list1.addNode(4);
        ListNode node1 = list1.addNode(5);
        node1.next = node;
        System.out.println("is loop exist :"+list1.isLoopExist(list1.getHead()));
*/
        //find middle noe using lenth
       /* ListNode middleNode2 = list.findMiddleNodeUsingLength(list.getHead());
        if(middleNode2 != null) {
            System.out.println("middle Node using length :"+middleNode2.data);
        }

        LinkedListOpd  list1 = new LinkedListOpdImpl();
        list1.addNode(10);
        list1.addNode(16);
        list1.addNode(20);
        list1.addNode(30);
        list1.addNode(40);
        list1.addNode(50);
        System.out.print("before reversal : \n");
        list1.display(list1.getHead());

       ListNode newHead =  list1.reverseListRec(list1.getHead());
        System.out.println("After reversal recursively : \n");
        list1.display(newHead);*/

        /*ListNode newHead = list1.reverseListItr(list1.getHead());
        System.out.println("After reversal Iterative : \n");
        list1.display(list1.getNewHead());*/

        LinkedListOpd  list1 = new LinkedListOpdImpl();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(4);
        list1.addNode(5);
        list1.addNode(6);
        list1.addNode(7);
        list1.addNode(8);

        System.out.println("before groupOf k");
        list1.display(list1.getHead());
        int k = 2;
        int length = list1.findLengthOfList(list1.getHead());
        ListNode newHead = list1.reverseGroupOfKNode(list1.getHead(),k,length);
        System.out.println("\nreverse of k size list ");
        list1.display(newHead);

        LinkedListOpd  list2 = new LinkedListOpdImpl();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(4);
        list1.addNode(5);
        list1.addNode(6);
        list1.addNode(7);
        list1.addNode(8);

        System.out.println("before  reverse");
        list1.display(list1.getHead());
       // int k = 2;

        System.out.println("\nreverse of k size list ");
        list2.display(newHead);


    }
}
