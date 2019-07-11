package tree.binarytree;

public class PostOrNode {
    BTNode btNode;
    boolean pushFlag;

    public PostOrNode() {
    }

    public PostOrNode(BTNode btNode, boolean pushFlag) {
        this.btNode = btNode;
        this.pushFlag = pushFlag;
    }
}
