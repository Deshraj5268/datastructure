package linkedlist.doublylinklist;

public class DListNode {
    public int data;
    public DListNode prev;
    public DListNode next;

    public DListNode(int data, DListNode prev, DListNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DListNode() {
    }
}
