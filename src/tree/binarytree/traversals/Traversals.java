package tree.binarytree.traversals;

import tree.binarytree.*;

import java.util.*;

public class Traversals {

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

    public void preOrderRec(BTNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");

        if(root.left!=null) {
            preOrderRec(root.left);
        }
        if(root.right!=null){
            preOrderRec(root.right);
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

    public void inOrderRec(BTNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            inOrderRec(root.left);
        }
        System.out.print(root.data +" ");
        if(root.right != null){
            inOrderRec(root.right);
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

    //LRN
    public void postOrderRec(BTNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            postOrderRec(root.left);
        }
        if(root.right != null){
            postOrderRec(root.right);
        }
        System.out.print(root.data +" ");
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
        BTTreeService btTreeService = new BTTreeService();
        int height = btTreeService.heightRec(root);
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

    /*
     * perform level order traversal (L->R insertion in queue)
     * print data after at each level ( after marker point)
     * */
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
        while (!queue.isEmpty()){
            temp = queue.poll();
            if(temp == null){
                if(!queue.isEmpty()){
                    System.out.print(queue.peek().data+" ");
                    queue.offer(null);
                }
            }else {
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
            }
        }
    }

    public void bottomView(BTNode root){
        if(root == null){
            System.out.println("empty tree ");
            return ;
        }
        Queue<LeftDiagonalNode> queue = new LinkedList<>();
        LeftDiagonalNode temp = null;
        LeftDiagonalNode leftNode = null;
        LeftDiagonalNode rightNode = null;
        LeftDiagonalNode leftDiagonalNode = new LeftDiagonalNode(root,0);
        queue.offer(leftDiagonalNode);
        Map<Integer,Integer> treeMap = new TreeMap<>();

        while (!queue.isEmpty()){
            temp =  queue.poll();
            treeMap.put(temp.hd,temp.btNode.data);
            if(temp.btNode.left != null){
                leftNode = new LeftDiagonalNode(temp.btNode.left,temp.hd - 1);
                queue.offer(leftNode);
            }
            if(temp.btNode.right != null){
                rightNode = new LeftDiagonalNode(temp.btNode.right,temp.hd + 1);
                queue.offer(rightNode);
            }
        }
        System.out.println(treeMap.values());

        /*Map<Integer,LinkedList<Integer>> map = verticalViewItr(root);
        Collection<LinkedList<Integer>> set = map.values();
        System.out.println("vertical order ");
        set.forEach(x-> System.out.print(x.getLast()+" "));*/
    }

    public void topView(BTNode root){
        if(root == null){
            System.out.println("empty tree ");
            return ;
        }
        Queue<LeftDiagonalNode> queue = new LinkedList<>();
        LeftDiagonalNode temp = null;
        LeftDiagonalNode leftNode = null;
        LeftDiagonalNode rightNode = null;
        LeftDiagonalNode leftDiagonalNode = new LeftDiagonalNode(root,0);
        queue.offer(leftDiagonalNode);
        Map<Integer,Integer> treeMap = new TreeMap<>();

        while (!queue.isEmpty()){
            temp =  queue.poll();
            treeMap.putIfAbsent(temp.hd,temp.btNode.data);
            if(temp.btNode.left != null){
                leftNode = new LeftDiagonalNode(temp.btNode.left,temp.hd - 1);
                queue.offer(leftNode);
            }
            if(temp.btNode.right != null){
                rightNode = new LeftDiagonalNode(temp.btNode.right,temp.hd + 1);
                queue.offer(rightNode);
            }
        }
        System.out.println(treeMap.values());

        /*Map<Integer,LinkedList<Integer>> map = verticalViewItr(root);
        Collection<LinkedList<Integer>> set = map.values();
        System.out.println("vertical order 2 ");
        set.forEach(x-> System.out.print(x.getFirst()+" "));*/
    }

    /*
     * perform level order traversal
     * put node data in tree map with hd as key
     * put left node with hd-1 ( horizontal distance)
     * put right node with hd+1
     * */
    public Map<Integer,LinkedList<Integer>> verticalViewItr(BTNode root) {
        Queue<LeftDiagonalNode> queue = new LinkedList<>();
        LeftDiagonalNode temp = null;
        LeftDiagonalNode leftNode = null;
        LeftDiagonalNode rightNode = null;
        LeftDiagonalNode leftDiagonalNode = new LeftDiagonalNode(root, 0);
        queue.offer(leftDiagonalNode);
        Map<Integer, LinkedList<Integer>> treeMap = new TreeMap<>();//Collections.reverseOrder() for reverse order

        while (!queue.isEmpty()) {
            temp = queue.poll();
            LinkedList<Integer> list;
            if(treeMap.get(temp.hd) == null){
                list = new LinkedList();
            }else {
                list = treeMap.get(temp.hd);
            }
            list.addLast(temp.btNode.data);
            treeMap.put(temp.hd,list);

            if (temp.btNode.left != null) {
                leftNode = new LeftDiagonalNode(temp.btNode.left, temp.hd - 1);
                queue.offer(leftNode);
            }
            if (temp.btNode.right != null) {
                rightNode = new LeftDiagonalNode(temp.btNode.right, temp.hd + 1);
                queue.offer(rightNode);
            }
        }
        return treeMap;
    }

    /*
  *        1
        /     \
       2       3
      /  \    /  \
     4    5  6    7
              \  /  \
               8 10  9
                   \
                   11
                     \
                      12
  *
  * we need to take care Hd + VD (vertical distance )
  * */
    public void verticalOrderRec(BTNode root,int hd,Map<Integer,LinkedList<Integer>> treeMap){
        if(root == null){
            return;
        }
        LinkedList<Integer> list;
        if(treeMap.get(hd) == null){
            list = new LinkedList<>();
        }else {
            list = treeMap.get(hd);
        }
        list.addLast(root.data);
        treeMap.put(hd,list);
        verticalOrderRec(root.left,hd-1,treeMap);
        verticalOrderRec(root.right,hd+1,treeMap);
    }

    //need to improve as per above diagram
    public void verticalOrderWithVerticalDistanceRec(BTNode root,int hd,int vd,Map<Integer,LinkedList<DataWithVD>> treeMap){
        if(root == null){
            return;
        }
        LinkedList<DataWithVD> list;
        if(treeMap.get(hd) == null){
            list = new LinkedList<>();
        }else {
            list = treeMap.get(hd);
        }
        list.addLast(new DataWithVD(root.data,vd));
        treeMap.put(hd,list);
        verticalOrderWithVerticalDistanceRec(root.left,hd-1,vd+1,treeMap);
        verticalOrderWithVerticalDistanceRec(root.right,hd+1,vd+1,treeMap);
    }

    public void printTreeMap(Map<Integer,LinkedList<Integer>> verticalViewTreeMap){
        verticalViewTreeMap.values().forEach(x-> x.stream().forEach(y->System.out.print(y+" ")));
    }

    /*
     * perform level order traversal (R->L insertion in queue)
     * print data after at each level
     * */
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
        while (!queue.isEmpty()){
            temp = queue.poll();
            if(temp == null){
                if(!queue.isEmpty()){
                    System.out.print(queue.peek().data+" ");
                    queue.offer(null);
                }
            }else {
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
            if(hashMap.get(temp.hd) == null){
                hashMap.put(temp.hd,temp.btNode.data);
            }
            if(temp.btNode.left != null){
                leftNode = new LeftDiagonalNode(temp.btNode.left,temp.hd +1);
                queue.offer(leftNode);
            }
            if(temp.btNode.right != null){
                rightNode = new LeftDiagonalNode(temp.btNode.right,temp.hd);
                queue.offer(rightNode);
            }
        }
        if(hashMap != null) {
            for (Integer value : hashMap.values()){
                System.out.print(value+" ");
            }
        }
    }

}
