package tree.binarytree;

import arrays.sortingsearching.Search;
import tree.binarytree.traversals.Traversals;

import java.util.HashMap;
import java.util.Map;

public class TreeConstructionUsTraversal {

    static int preIndex=0;
    Search linearSearch = new Search();
    static  Map<Integer,Integer> map;
    public static void main(String[] args) {
        int [] preOrder = {20,8,4,12,10,14,22};
        int [] inOrder = {4,8,10,12,14,20,22};
        TreeConstructionUsTraversal buildObject = new TreeConstructionUsTraversal();
        map = prepareMap(inOrder);
        BTNode root = buildObject.buildTreeUsingPreAndInorder(preOrder,inOrder,0,inOrder.length-1);


        Traversals traversals = new Traversals();
        System.out.println("preOrder traversal :");
        traversals.preOrderRec(root);
        System.out.println("\nin Order traversal :");
        traversals.inOrderRec(root);
    }

    private static Map<Integer, Integer> prepareMap(int [] inOrder) {
       Map<Integer,Integer> localMap = new HashMap<>();
        for(int i=0;i<inOrder.length;i++){
            localMap.put(inOrder[i],i);
        }
        return localMap;
    }


    public BTNode buildTreeUsingPreAndInorder(int [] preOrderArr,int [] inOrderArr,int leftIndex,int rightIndex){

        if(leftIndex > rightIndex){
            return null;
        }
        BTNode node = new BTNode(preOrderArr[preIndex++],null,null);
        if(leftIndex == rightIndex){
            return node;
        }
        int parentIndex = findParentNodeIndex(inOrderArr,leftIndex,rightIndex,node.data);

        node.left = buildTreeUsingPreAndInorder(preOrderArr,inOrderArr,leftIndex,parentIndex-1);
        node.right = buildTreeUsingPreAndInorder(preOrderArr,inOrderArr,parentIndex+1,rightIndex);

        return node;
    }

    public int findParentNodeIndex(int [] inOrderArr,int leftIndex,int rightIndex,int data){
        boolean isLinearSearch = false;
        if(isLinearSearch){
            return linearSearch.linearSearch(inOrderArr,leftIndex,rightIndex,data);
        }else {
            return map.get(data);
        }
    }



}
