package tree.binarytree;

import java.util.*;

public class BTTreeService {

    public BTNode createBT(int [] arr){
        if(arr == null || arr.length == 0){
            return new BTNode();
        }
        BTNode root = null;
        for(int data:arr){
            root = insert(root,data);
        }
        return root;
    }

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

    boolean hasPathSum(BTNode root, int target) {
        // Your code here
        if(root == null){
            return false;
        }
        int sum = target - root.data;
        if(root.left == null && root.right == null && sum == 0){
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

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

    public int diameterUsingHeight(BTNode root,Height height,BTNode rootDmNode,Height leftH,Height rightH){
        if(root == null){
            return 0;
        }

        int lh = diameterUsingHeight(root.left,height,rootDmNode,leftH,rightH);
        int rh = diameterUsingHeight(root.right,height,rootDmNode,leftH,rightH);

        if(height.h < lh+rh+1) {
            height.h = lh + rh + 1;
            leftH.h = lh;
            rightH.h = rh;
            rootDmNode.data = root.data;
            rootDmNode.left = root.left;
            rootDmNode.right = root.right;
        }

        return 1+ Math.max(lh,rh);
    }

    int diameterSimple(BTNode root) {
        // Your code here
        Height a = new Height();
        diameterUtil(root,a);
        return a.h;

    }
    public int diameterUtil(BTNode root,Height a){

        if(root == null){
            return 0;
        }

        int leftHeight = diameterUtil(root.left,a);
        int rightHeight = diameterUtil(root.right,a);


        a.h = Math.max(a.h,1+leftHeight+rightHeight);

        return 1+Math.max(leftHeight,rightHeight);

    }

    public int [] printPath(BTNode root,int [] pathArr,int length,int leafLength){

        if(root == null){
            return null;
        }
        pathArr[length++] = root.data;
        if(isLeaf(root) && length == leafLength){
            return pathArr;
        }else {
            printPath(root.left, pathArr, length, leafLength);
            printPath(root.right, pathArr, length, leafLength);
            return pathArr;
        }
    }

    private boolean isLeaf(BTNode node){
        return (node.left == null && node.right == null);
    }


    public void printDiameter(int [] leftPath,int [] rightPath,BTNode rootDm){
        for(int j=leftPath.length-1;j>=0;j--){
            System.out.print(leftPath[j]+" ");
        }

        System.out.print(rootDm.data+" ");

        for(int i=0;i<rightPath.length;i++){
            System.out.print(rightPath[i]+" ");
        }
    }

    /* https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/ */
    /*
    * travers in level order way
    * if node is null then add -1
    * otherwise add node value and add lef, right node of tree
    * return result list
    * */
    public List<Integer> serialize(BTNode root){
        List<Integer> result = new ArrayList<>();
        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);
        BTNode curr;
        while (!queue.isEmpty()){
            curr = queue.poll();
            if(curr == null){
                result.add(-1);
                continue;
            }
            result.add(curr.data);
            queue.add(curr.left);
            queue.add(curr.right);
        }
        return result;
    }

    public BTNode deserialize(List<Integer> list){
        if(list.get(0) == -1){
            return null;
        }
        Queue<BTNode> queue = new LinkedList<>();
        BTNode root = new BTNode(list.get(0));
        queue.add(root);
        BTNode curr = null;
        int i = 1;
        while (!queue.isEmpty()){
            curr = queue.poll();

            if(list.get(i) != -1){
                BTNode left = new BTNode(list.get(i));
                curr.left = left;
                queue.add(left);
            }
            i++;
            if(list.get(i) != -1){
                BTNode right = new BTNode(list.get(i));
                curr.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }

    public static boolean isSymmetric(BTNode root)
    {
        // add your code here;
        if(root == null){
            return true;
        }
        return symmetricUtil(root.left,root.right);

    }
    public static boolean symmetricUtil(BTNode root1,BTNode root2){

        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return (root1.data == root2.data && symmetricUtil(root1.left,root2.right)
                && symmetricUtil(root1.right,root2.left));

    }


}
