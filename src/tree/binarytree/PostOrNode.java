package tree.binarytree;

public class PostOrNode {
    public BTNode btNode;
    public boolean pushFlag; // is node visited or not

    public PostOrNode() {
    }

    public PostOrNode(BTNode btNode, boolean pushFlag) {
        this.btNode = btNode;
        this.pushFlag = pushFlag;
    }
}
