package linkedlistproblem;

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
        ListNode nthNode = list.findNthNodeFromlast(list.getHead(),n);
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
        ListNode middleNode2 = list.findMiddleNodeUsingLength(list.getHead());
        if(middleNode2 != null) {
            System.out.println("middle Node using length :"+middleNode2.data);
        }
    }
}
