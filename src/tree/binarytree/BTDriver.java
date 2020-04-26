package tree.binarytree;

public class BTDriver {

    public static void main(String[] args) {
        BTTreeService btTreeService = new BTTreeService();
        BTNode root = null;
        root = btTreeService.insert(root,8);
        root = btTreeService.insert(root,5);
        root = btTreeService.insert(root,15);
        root = btTreeService.insert(root,16);
        root = btTreeService.insert(root,17);
        root = btTreeService.insert(root,18);
        root = btTreeService.insert(root,20);
        root = btTreeService.insert(root,19);
        root = btTreeService.insert(root,21);
        root = btTreeService.insert(root,3);
        root = btTreeService.insert(root,12);
        root = btTreeService.insert(root,11);
        root = btTreeService.insert(root,10);
        System.out.println("pre-order : ");
        btTreeService.preOrderItr(root);
        System.out.println("\nIn-order : ");
        btTreeService.inOrderItr(root);
        System.out.println("\nPost-order : ");
        btTreeService.postOrderItr(root);
        System.out.println("\nLevel-order : ");
        btTreeService.levelOrderTrv(root);

        System.out.println("max :"+btTreeService.findMax(root));
        System.out.println("min :"+btTreeService.findMin(root));

        System.out.println("iterative level order traversal : ");
        btTreeService.levelOrderRec(root);

        System.out.println("print left view of the tree : ");
        btTreeService.leftView(root);

        System.out.println("\n print right view of the tree : ");
        btTreeService.rightView(root);

        System.out.println("\n print left diagonal  view of the tree : ");
        btTreeService.diagonalLeftView(root);

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
}
