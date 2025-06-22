package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAtSameLevel {

    public static void main(String[] args) {

    }


    public BTWithRightNode connect(BTWithRightNode root) {
        if(root == null){
            return null;
        }
        Queue<BTWithRightNode> qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        BTWithRightNode temp;
        while(!qu.isEmpty()){
            temp = qu.poll();
            if(temp == null){
                if(!qu.isEmpty()){
                    qu.add(null);
                }
            }else{
                temp.next = qu.peek();
                if(temp.left != null){
                    qu.add(temp.left);
                }
                if(temp.right != null){
                    qu.add(temp.right);
                }
            }
        }

        return root;
    }
}
