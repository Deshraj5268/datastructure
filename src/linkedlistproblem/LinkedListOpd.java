package linkedlistproblem;

public interface LinkedListOpd {

    ListNode getHead();

    public void addLast(int date);

    public void display(ListNode head);

    public void addFirst(int date);

    void addNode(int data, int index);

    void addNode(int data);

    ListNode deleteEleExceptLast(ListNode node);

    ListNode findNthNodeFromlast(ListNode head, int n);
}