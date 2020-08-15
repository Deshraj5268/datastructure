package linkedlist;

public interface LinkedListOpd {

    public  ListNode getHead();

    public ListNode getNewHead();

    //addition
    public ListNode addLast(int date);

    public ListNode addFirst(int date);

    ListNode removeFirstNode(ListNode head);

    ListNode removeLast(ListNode head);

    ListNode remove(ListNode head, int data);

    ListNode insertion(int data);

    public ListNode addNode(int data, int index);

    public ListNode addNode(int data);

    public void display(ListNode head);

    public ListNode deleteEleExceptLast(ListNode node);

    public ListNode findNthNodeFromlast(ListNode head, int n);

    public ListNode findMiddleNode(ListNode head);

    public boolean isLoopExist(ListNode head);

    public ListNode findMiddleNodeUsingLength(ListNode head);

    public ListNode reverseListItr(ListNode head);

    public ListNode reverseListRec(ListNode head);
}