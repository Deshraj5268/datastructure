package tree.binarytree;

import java.util.*;

public class BTTreeService {

    public BTNode makeBT(int [] arr){
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

    public int diameterUsingHeight(BTNode root,Height height,BTNode rootDmNode,Height left,Height right){
        if(root == null){
            return 0;
        }

        int lh = diameterUsingHeight(root.left,height,rootDmNode,left,right);
        int rh = diameterUsingHeight(root.right,height,rootDmNode,left,right);

        if(height.h < lh+rh+1) {
            height.h = lh + rh + 1;
            left.h = lh;
            right.h = rh;
            rootDmNode.data = root.data;
            rootDmNode.left = root.left;
            rootDmNode.right = root.right;
        }

        return 1+ Math.max(lh,rh);
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


}
