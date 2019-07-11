package tree.binarysearchtree;

import tree.binarytree.BTNode;

public class BSTService {

    public boolean isBST(BTNode root){
        if (root == null){
            return true;
        }
        if(root.left != null && findMax(root.left)>root.data){
            return false;
        }
        if (root.right != null && findMin(root.right) < root.data){
            return false;
        }
        return true;
    }

    /*public boolean isBST(BTNode root,int min,int max){
        if(root == null){
            return true;
        }
        return (())
    }*/

    public boolean isBSTUsingInOrder(BTNode root,DataNode prev){
        if(root == null){
            return true;
        }
        if(!isBSTUsingInOrder(root.left,prev)){
            return false;
        }
        if(root.data < prev.data){
            return false;
        }
        prev.data = root.data;
        if (!isBSTUsingInOrder(root.right,prev)){
            return false;
        }
        return true;
    }

    public int findMax(BTNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int left = findMax(root.left);
        int right = findMax(root.right);
        int max = root.data;
        if(left > max){
            max = left;
        }
        if(right > max){
            max = right;
        }
        return max;
    }

    public int findMin(BTNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int left = findMin(root.left);
        int right = findMin(root.right);
        int min = root.data;
        if(left < min){
            min = left;
        }
        if(right < min){
            min = right;
        }
        return min;
    }
}
