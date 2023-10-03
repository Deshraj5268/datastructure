package tree;

import tree.binarytree.BTNode;
import tree.binarytree.BTTreeService;


/*
*
* https://leetcode.com/problems/subtree-of-another-tree/description/
* */
public class SubTreeExist {

    public static void main(String[] args) {
        int [][] rootArr = {{5,4,6,1,2},{1,1},{5,4,6,1,2,3}}; // {1,1}
        int [][] subArr = {{4,1,2},{1},{4,1,2}}; // {1}
        // out put T T F
        for(int i=0;i<rootArr.length;i++) {
            BTNode root = new BTTreeService().createBT(rootArr[i]);//bst
            BTNode subTree = new BTTreeService().createBT(subArr[i]);
            boolean result = isSubtree(root, subTree);
            System.out.println("result : " + result);
        }
    }

    public static boolean isSubtree(BTNode root, BTNode subRoot) {
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }

        boolean isIdentical = isBTIdentical(root,subRoot);
        if(isIdentical){
            return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }


    public static boolean isBTIdentical(BTNode root1, BTNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return (root1.data == root2.data) &&
                isBTIdentical(root1.left,root2.left) && isBTIdentical(root1.right,root2.right);
    }
}
