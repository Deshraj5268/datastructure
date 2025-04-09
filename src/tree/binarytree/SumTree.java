package tree.binarytree;


import tree.binarytree.traversals.Traversals;

/*
* https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
* */
public class SumTree {
    public static void main(String[] args) {
        BTNode root = createBinaryTree();

        Traversals traversals = new Traversals();
        traversals.inOrderItr(root);
        System.out.println();
        boolean isSumTree = isSumTreeRec(root);
        System.out.println("isSumTree : " +isSumTree);
        System.out.println("isSumTree using POSt order trv: " +isSumTreeUsingPostOrdTrv(root));
    }

    public static boolean isSumTreeUsingPostOrdTrv(BTNode root){
        return isSumTreeUsingPostOrdTrvUtil(root) != -1;
    }

    private static int isSumTreeUsingPostOrdTrvUtil(BTNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.data;
        }
        int leftSum = isSumTreeUsingPostOrdTrvUtil(root.left);
        int rightSum = isSumTreeUsingPostOrdTrvUtil(root.right);

        if(root.data == rightSum + leftSum){
            return leftSum+rightSum+root.data;
        }else {
            return -1;
        }

    }

    private static BTNode createBinaryTree() {
        BTNode root = new BTNode(26,null,null);

        root.left = new BTNode(10,null,null);
        root.left.left = new BTNode(4,null,null);
        root.left.right = new BTNode(6,null,null);

        root.right= new BTNode(3,null,null);
        root.right.right = new BTNode(3,null,null);
        return root;
    }

    // brute force
    public static boolean isSumTreeRec(BTNode root){
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        int leftSum = sumTreeData(root.left);
        int rightSum = sumTreeData(root.right);

        return (leftSum+rightSum == root.data &&
                (isSumTreeRec(root.left) && isSumTreeRec(root.right)));
    }

    private static int sumTreeData(BTNode root) {
        if(root == null){
            return 0;
        }
        return sumTreeData(root.left) + root.data + sumTreeData(root.right);
    }
}
