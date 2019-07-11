package tree.binarysearchtree;

import tree.binarytree.BTNode;
import tree.binarytree.BTTreeService;

public class BSTDriver {

    public static void main(String[] args) {
        BTTreeService btTreeService = new BTTreeService();
        BTNode root = null;
        root = btTreeService.insert(root,8);
        /*root = btTreeService.insert(root,5);
        root = btTreeService.insert(root,15);
        root = btTreeService.insert(root,3);
        root = btTreeService.insert(root,12);
        root = btTreeService.insert(root,6);*/
       root.left = new BTNode(10,null,null);
       root.right = new BTNode(1,null,null);
        BSTService bstService = new BSTService();
        boolean isBST = bstService.isBST(root);
        System.out.println("isBST : "+isBST);
        DataNode prev = new DataNode(Integer.MIN_VALUE);
        System.out.println("isBSTInorder : "+bstService.isBSTUsingInOrder(root,prev));
    }
}
