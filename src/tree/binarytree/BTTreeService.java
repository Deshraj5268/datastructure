package tree.binarytree;

import java.util.HashMap;
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

    public void levelOrderRec(BTNode root){
        int height = heightRec(root);
        for(int d=0;d<=height;d++){
            levelOrderRecUtil(root,d);
            System.out.println();
        }
    }

    private void levelOrderRecUtil(BTNode root, int d) {
        if(root == null){
            return;
        }
        if(d == 1){
            System.out.print(root.data+" ");
        }
        if(d > 1){
            levelOrderRecUtil(root.left,d-1);
            levelOrderRecUtil(root.right,d-1);
        }
    }

    public int heightRec(BTNode root){
        if(root == null){
            return 0;
        }
        int left = heightRec(root.left);
        int right = heightRec(root.right);
        if(left > right){
            return left+1;
        }else {
            return right+1;
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


    public void leftView(BTNode root){
        if(root == null){
            System.out.println("empty tree ");
            return;
        }
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        BTNode temp = null;
        System.out.print(root.data+" ");
        boolean isLfetViewNOde = false;
        while (!queue.isEmpty()){
           temp = queue.poll();
           if(temp == null){
               if(!queue.isEmpty()){
                   queue.offer(null);
                   isLfetViewNOde = true;
               }
           }else {
               if(isLfetViewNOde){
                   System.out.print(temp.data+" ");
                   isLfetViewNOde = false;
               }
               if(temp.left != null){
                   queue.offer(temp.left);
               }
               if (temp.right != null){
                   queue.offer(temp.right);
               }
           }
        }
    }

    public void rightView(BTNode root){
        if(root == null){
            System.out.println("empty tree ");
            return;
        }
        Queue<BTNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        BTNode temp = null;
        System.out.print(root.data+" ");
        boolean isRightViewNOde = false;
        while (!queue.isEmpty()){
            temp = queue.poll();
            if(temp == null){
                if(!queue.isEmpty()){
                    queue.offer(null);
                    isRightViewNOde = true;
                }
            }else {
                if(isRightViewNOde){
                    System.out.print(temp.data+" ");
                    isRightViewNOde = false;
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
                if(temp.left != null){
                    queue.offer(temp.left);
                }
            }
        }
    }

    /*
    * traverse level order way
     * increment count of left node
     * and count value in right node will be same as parent node
    * */
    public void diagonalLeftView(BTNode root){
        if(root == null){
            System.out.println("empty tree ");
            return;
        }
        Queue<LeftDiagonalNode> queue = new LinkedList<>();
        LeftDiagonalNode temp = null;
        LeftDiagonalNode leftNode = null;
        LeftDiagonalNode rightNode = null;
        LeftDiagonalNode leftDiagonalNode = new LeftDiagonalNode(root,0);
        queue.offer(leftDiagonalNode);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        while (!queue.isEmpty()){
            temp =  queue.poll();
            if(hashMap.get(temp.count) == null){
                hashMap.put(temp.count,temp.btNode.data);
            }
            if(temp.btNode.left != null){
                leftNode = new LeftDiagonalNode(temp.btNode.left,temp.count+1);
                queue.offer(leftNode);
            }
            if(temp.btNode.right != null){
                rightNode = new LeftDiagonalNode(temp.btNode.right,temp.count);
                queue.offer(rightNode);
            }
        }
        if(hashMap != null) {
            for (Integer value : hashMap.values()){
                System.out.print(value+" ");
            }
        }
    }

    public void printRootToLeafPath(BTNode root,int [] pathArr,int length){

        if(root == null){

            return;
        }
        if(root.left == null && root.right == null){
            for(int i=0;i<length;i++){
                System.out.print(pathArr[i]+" ");
            }
            System.out.println();
            return;
        }
        pathArr[length] = root.data;
        printRootToLeafPath(root.left,pathArr,length+1);
        printRootToLeafPath(root.right,pathArr,length+1);

    }

    public BTNode findLca(BTNode root,int n1,int n2){
        if(root == null){
            return null;
        }
        if(root.data == n1 || root.data == n2){
            return root;
        }
        BTNode left = findLca(root.left,n1,n2);
        BTNode right = findLca(root.right,n1,n2);

        if(left != null && right !=  null){
            return root;
        }
        return left!= null ? left:right;
    }

    public int diameter(BTNode root){
        if(root == null){
            return 0;
        }
        int lh = heightRec(root.left);
        int rh = heightRec(root.right);

        int ld = diameter(root.left);
        int rd = diameter(root.right);

        return Math.max((lh+rh+1),
                Math.max(ld,rd));
    }

    public int diameterWOHeight(BTNode root,Height height){
        Height lh = new Height();
        Height rh = new Height();
        if(root == null){
            height.h = 0;
            return 0;
        }

        int ld = diameterWOHeight(root.left,lh);
        int rd = diameterWOHeight(root.right,rh);

        height.h = 1+Math.max(lh.h,rh.h);

        return Math.max((lh.h+rh.h+1),
                Math.max(ld,rd));
    }

    public int diameterUsingHeight(BTNode root,Height height){
        if(root == null){
            return 0;
        }

        int lh = diameterUsingHeight(root.left,height);
        int rh = diameterUsingHeight(root.right,height);

        height.h = Math.max(height.h,(lh+rh+1));

        return 1+ Math.max(lh,rh);
    }

}
