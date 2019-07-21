package linkedlistproblem;

public class LinkedListDriver {


    public static void main(String[] args) {

        LinkedListOpd  list = new LinkedListOpdImpl();
        list.addNode(10);
        list.addNode(16);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.display(list.getHead());
        int n =0;
        ListNode nthNode = list.findNthNodeFromlast(list.getHead(),n);
        if(nthNode != null){
            System.out.println(n+"thNode: "+nthNode.data);
        }
    }
}
