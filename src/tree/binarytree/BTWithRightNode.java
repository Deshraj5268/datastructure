package tree.binarytree;

public class BTWithRightNode {

    public int data;
    public BTWithRightNode left;
    public BTWithRightNode right;
    public BTWithRightNode next;

    public BTWithRightNode() {
    }
    public BTWithRightNode(int data) {
        this.data = data;
    }

    public BTWithRightNode(int data, BTWithRightNode left, BTWithRightNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BTWithRightNode(int data, BTWithRightNode left, BTWithRightNode right, BTWithRightNode next) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
