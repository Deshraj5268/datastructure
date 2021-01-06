package tree.binarytree;

import tree.binarytree.traversals.Traversals;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class BTDriver {

    public static void main(String[] args) {
        BTTreeService btTreeService = new BTTreeService();
        BTNode root = null;
        int [] arr = {8,5,15,16,17,18,20,19,21,12,11,10};
        root = btTreeService.makeBT(arr);

        btTraversals(root);

       // otherOps(root,btTreeService);


    }

    private static void otherOps(BTNode root, BTTreeService btTreeService) {
        System.out.println("max :"+btTreeService.findMax(root));
        System.out.println("min :"+btTreeService.findMin(root));

        int n1= 11;
        int n2 = 5;
        System.out.println("\n lca of "+n1+" and "+n2);
        BTNode btNode = btTreeService.findLca(root,n1,n2);
        if(btNode != null) {
            System.out.println(btNode.data);
        }

        int dmeterOfBt = btTreeService.diameter(root);
        System.out.print("\n diameter of bt : "+dmeterOfBt);

        dmeterOfBt = btTreeService.diameterWOHeight(root,new Height());
        System.out.print("\n diameter of bt WO Height : "+dmeterOfBt);

        Height minHeight = new Height();
        minHeight.h = Integer.MIN_VALUE;
        Height left = new Height();
        Height right = new Height();
        BTNode rootDm = new BTNode();
        dmeterOfBt = btTreeService.diameterUsingHeight(root,minHeight,rootDm,left,right);
        System.out.print("\n diameter of bt diameterUsingHeight : "+minHeight.h);
        System.out.println("\n "+rootDm.data + " left dm length :"+left.h+ " right dm length :"+right.h);
        int [] leftPathArr = btTreeService.printPath(rootDm.left,new int[left.h],0,left.h);
        int [] rightPathArr = btTreeService.printPath(rootDm.right,new int[right.h],0,right.h);
        btTreeService.printDiameter(leftPathArr,rightPathArr,rootDm);
    }

    private static void btTraversals(BTNode root) {
        Traversals traversals = new Traversals();

        System.out.println("pre-order : ");
        traversals.preOrderItr(root);
        System.out.println("\npre-order Rec: ");
        traversals.preOrderRec(root);

        System.out.println("\nIn-order : ");
        traversals.inOrderItr(root);
        System.out.println("\nIn-order Rec: ");
        traversals.inOrderRec(root);

        System.out.println("\nPost-order : ");
        traversals.postOrderItr(root);
        System.out.println("\nPost-order Rec: ");
        traversals.postOrderRec(root);

        System.out.println("\nLevel-order : ");
        traversals.levelOrderTrv(root);
        System.out.println("\niterative level order traversal : ");
        traversals.levelOrderRec(root);

        System.out.println("\n print Vertical view of the tree : ");
        Map<Integer, LinkedList<Integer>> verticalViewTreeMap = traversals.verticalViewItr(root);
        traversals.printTreeMap(verticalViewTreeMap);

        //{8,5,3,15,12,11,10,25,22,23,24,26}; incorrect output , so sort array based on HD->VD  (root,0,0,resultTree
        System.out.println("\n print Vertical order of the tree recursively : ");
        Map<Integer, LinkedList<Integer>> resultTree = new TreeMap<>();
        traversals.verticalOrderRec(root,0,resultTree);
        traversals.printTreeMap(resultTree);


        System.out.println("\n print Vertical order of the tree as data in tree order recursively : ");
        Map<Integer, LinkedList<DataWithVD>> resultTree1 = new TreeMap<>();
        traversals.verticalOrderWithVerticalDistanceRec(root,0,0,resultTree1);
        resultTree1.values().forEach(x-> x.stream().sorted((vd1,vd2)->(vd1.vd>vd2.vd)?1:-1).forEach(y->System.out.print(y.data+" ")));
        //btTreeService.printTreeMap(resultTree1);

        System.out.println("\nprint left view of the tree : ");
        traversals.leftView(root);

        System.out.println("\n print right view of the tree : ");
        traversals.rightView(root);

        System.out.println("\n print left diagonal  view of the tree : ");
        traversals.diagonalLeftView(root);

        System.out.println("\n print bottom view of the tree : ");
        traversals.bottomView(root);

        System.out.println("\n print Top view of the tree : ");
        traversals.topView(root);
    }
}
