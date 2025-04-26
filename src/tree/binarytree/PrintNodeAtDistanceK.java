package tree.binarytree;

import java.util.*;


/*
* https://takeuforward.org/binary-tree/print-nodes-at-distance-k-in-a-binary-tree
* https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
* https://www.youtube.com/watch?v=1wkIAT-8B_o
* https://algo.monster/liteproblems/863
* */
public class PrintNodeAtDistanceK {

    public static void main(String[] args) {

        BTNode root = new BTNode(3);
        root.left = new BTNode(5);
        root.right = new BTNode(1);
        root.left.left = new BTNode(6);
        root.left.right = new BTNode(2);
        root.right.left = new BTNode(0);
        root.right.right = new BTNode(8);
        root.left.right.left = new BTNode(7);
        root.left.right.right = new BTNode(4);

        BTNode target = root.left;
        int k = 2;

        List<Integer> result = distanceK(root, target, k);
        System.out.println(result.toString());
    }

    /*
    * To efficiently travel away from the target node one step at a time, we need to be able to access
    * all adjacent nodes (left, right and parent) of each node. While the left and right child nodes are
    *  directly accessible through pointers, accessing the parent node requires maintaining an additional
    *  hashmap of the node as key and value as its parent. The approach involves three primary steps: first,
    *  creating parent-child mappings through BFS, then
    * locating and storing the target node, and finally, employing DFS from the target node to identify nodes at distance 'K'.
    * */
    public static List<Integer> distanceK(BTNode root, BTNode target, int k) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Map<BTNode, BTNode> parentTrack = makeParentMap(root);
        Set<BTNode> visited = new HashSet<>();
        Queue<BTNode> qu = new LinkedList<>();
        qu.add(target);
        visited.add(target); // we need to skip
        int currentLevel = 0;
        BTNode currentNode;
        int quSize;
        while(!qu.isEmpty()){
            quSize = qu.size();
            if(currentLevel++ == k){
                break;
            }

            // dfs way traversing 
            for(int i=0;i<quSize;i++){
                currentNode = qu.poll();
                if(currentNode.left != null && !visited.contains(currentNode.left)){
                    visited.add(currentNode.left);
                    qu.add(currentNode.left);
                }
                if(currentNode.right != null && !visited.contains(currentNode.right)){
                    visited.add(currentNode.right);
                    qu.add(currentNode.right);
                }
                if(parentTrack.get(currentNode) != null && !visited.contains(parentTrack.get(currentNode))){
                    visited.add(parentTrack.get(currentNode));
                    qu.add(parentTrack.get(currentNode));
                }
            }
        }

        // return result of poping queue date of distance k
        while(!qu.isEmpty()){
            result.add(qu.poll().data);
        }
        return result;
    }


    // iterative solution
    // linking parent node mapping as well, so node can travese left,right as well as parent node
    public static Map<BTNode, BTNode> makeParentMap(BTNode root){
        Map<BTNode,BTNode> parentTrack = new HashMap<>();
        if(root == null){
            return parentTrack;
        }

        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);
        BTNode current;
        while(!queue.isEmpty()){
            current = queue.poll();
            if(current.left != null){
                parentTrack.put(current.left, current);//mapping
                queue.add(current.left);
            }
            if(current.right != null){
                parentTrack.put(current.right, current);//mapping
                queue.add(current.right);
            }
        }
        return parentTrack;
    }
}
