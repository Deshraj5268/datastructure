package tree.binarytree;

public class ExpressionBTNode {

    public char data;
    public ExpressionBTNode left;
    public ExpressionBTNode right;

    public ExpressionBTNode() {
    }

    public ExpressionBTNode(char data, ExpressionBTNode left, ExpressionBTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public ExpressionBTNode(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
