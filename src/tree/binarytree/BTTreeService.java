package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTTreeService {

    public BTNode insert(BTNode root, int val){
        if(root == null){
            root = new BTNode(val,null,null);
            return root;
        }
        BTNode temp = root;
        BTNode prev = root;
        BTNode newBTNode = new BTNode(val,null,null);
        while (temp != null){
            prev = temp;
            if(temp.data == val){
                return root;
            }else if(val < temp.data){
                temp = temp.left;
            }else {
                temp = temp.right;
            }
        }
        if(val < prev.data){
            prev.left = newBTNode;
        }else {
            prev.right = newBTNode;
        }
        return root;
    }

    public void preOrderItr(BTNode node){
        Stack<BTNode>stack = new Stack<>();
        BTNode temp = node;
        while (temp != null || !stack.isEmpty()){
            if (temp != null){
                System.out.print(temp.data+" ");
                stack.push(temp);
                temp = temp.left;
            }else {
                temp = stack.pop().right;
            }
        }
    }

    public void inOrderItr(BTNode node){
        Stack<BTNode>stack = new Stack<>();
        BTNode temp = node;
        while (temp != null || !stack.isEmpty()){
            if (temp != null){
                stack.push(temp);
                temp = temp.left;
            }else {
                temp = stack.pop();
                System.out.print(temp.data+" ");
                temp = temp.right;
            }
        }
    }

    public void postOrderItr(BTNode root){
        Stack<PostOrNode> stack = new Stack<>();
        BTNode temp = root;
        while (temp != null || !stack.isEmpty()){
            if(temp != null){
                stack.push(new PostOrNode(temp,false));
                temp = temp.left;
            }else {
                PostOrNode postOrNode = stack.pop();
                if(!postOrNode.pushFlag){
                    postOrNode.pushFlag = true;
                    stack.push(postOrNode);
                    temp = postOrNode.btNode.right;
                }else{
                    System.out.print(postOrNode.btNode.data +" ");
                    temp = null;
                }
            }
        }
    }

    public void levelOrderTrv(BTNode root){
        if(root == null){
            return;
        }
        Queue<BTNode> queue = new LinkedList<>();
        BTNode temp  = root;
        queue.offer(temp);
        while (!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(temp.data +" ");
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
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
