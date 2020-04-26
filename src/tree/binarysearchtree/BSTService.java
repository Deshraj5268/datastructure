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

    public BTNode searchNode(BTNode root,int val){
        BTNode temp = root;
        while (temp != null){
            if(temp.data == val){
                return root;
            }else if(val < temp.data){
                temp = temp.left;
            }else {
                temp = temp.right;
            }
        }
        return null;
    }

    public BTNode findMaxInBST(BTNode root){
        if(root == null){
            return null;
        }
        BTNode temp = root;
        while (temp.right != null){
            temp = temp.right;
        }
        return temp;
    }

    public BTNode delete(BTNode root,int data){
        if(root == null){
            return null;
        }
        BTNode delNode = searchNode(root,data);
        if(delNode == null){
            System.out.println("data is not present");
            return null;
        }
        BTNode temp=null;
        if(delNode.left != null && delNode.right != null){
            temp = findMaxInBST(delNode.left);
            delNode.data = temp.data;
            delNode.left = delete(delNode.left,delNode.data);
        }else {
            temp = delNode;
            if (delNode.left == null) {
                delNode= delNode.right;
            }
            if (delNode.right == null) {
                delNode = delNode.left;
            }
            temp.left = null;
            temp.right = null;
        }
        return temp;
    }
}
