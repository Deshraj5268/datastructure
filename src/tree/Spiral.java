package tree;

import tree.binarytree.BTNode;
import tree.binarytree.BTTreeService;

import java.util.*;

public class Spiral {

    public static void main(String[] args) {

        BTTreeService btTreeService = new BTTreeService();
        BTNode root = null;
        int [] arr = {8,5,15,16,17,18,20,19,21,12,11,10};
        root = btTreeService.createBT(arr);
        Spiral spiral = new Spiral();
        List<Integer> list = spiral.findSpiral(root);
        System.out.println(list.toString());

        System.out.println("using deque ");

        list = spiral.findSpiralUsingDeque(root);
        System.out.println(list.toString());

    }


    //Function to return a list containing the level order
    //traversal in spiral form.

    /*
     * using two stack
     *  level = 0 , evenStack.push(root)
     * level is Odd = oddStack pushed from R-->L until evenstack is empty
     * else          = evenStack push from L--> R until oddStack is empty
     *
     * until either evenstack or odd stack is empty
     *
     * SC : O(N)
     * */
    public List<Integer> findSpiral(BTNode root){
        // Your code here
        List<Integer> resultList = new ArrayList<>();

        if(root == null){
            return resultList;
        }
        Stack<BTNode> evenStack = new Stack<>();
        Stack<BTNode> oddStack = new Stack<>();
        evenStack.push(root);
        int level = 1;
        BTNode temp;
        while(!evenStack.isEmpty() || !oddStack.isEmpty()){

            if(level % 2 != 0){
                while(!evenStack.isEmpty()){
                    temp = evenStack.pop();
                    resultList.add(temp.data);
                    // r->l
                    if(temp.right != null){
                        oddStack.push(temp.right);
                    }
                    if(temp.left != null){
                        oddStack.push(temp.left);
                    }
                }
            }else{
                while(!oddStack.isEmpty()){
                    temp = oddStack.pop();
                    resultList.add(temp.data);
                    if(temp.left != null){
                        evenStack.push(temp.left);
                    }
                    if(temp.right != null){
                        evenStack.push(temp.right);
                    }
                }
            }
            level++;
        }

        return resultList;


    }

    /*
    * Use Deque
    *  level = 0 , deque.addLast(root);
    *             deque.addLast(null); //dummy node
    * level is odd = adding element at head (first) until peekLast() != null
    *
    * else level is odd = adding element at tail (last) until peekFirst() != null
    * */
    public List<Integer> findSpiralUsingDeque(BTNode root){
        // Your code here
        List<Integer> resultList = new ArrayList<>();

        if(root == null){   // it prevent infanite loop
            return resultList;
        }
        Deque<BTNode> deque = new LinkedList<>();
        deque.addLast(null);
        deque.addLast(root);
        int level = 1;

        BTNode temp;
        //null->root 
        while(deque.size() > 1){

            if(level % 2 != 0){
                while(deque.peekLast() != null){
                    //r-l  in deque until get null
                    temp = deque.removeLast();
                    resultList.add(temp.data);
                    if(temp.right != null){
                        deque.addFirst(temp.right);
                    }
                    if(temp.left != null){
                        deque.addFirst(temp.left);
                    }
                }
            }else{
                while(deque.peekFirst() != null){
                    temp = deque.removeFirst();
                    //l-r
                    resultList.add(temp.data);
                    if(temp.left != null){
                        deque.addLast(temp.left);
                    }
                    if(temp.right != null){
                        deque.addLast(temp.right);
                    }
                }
            }
            level++;

        }


        return resultList;


    }

}
