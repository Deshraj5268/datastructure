package tree.binarytree;

public class BTDriver {

    public static void main(String[] args) {
        BTTreeService btTreeService = new BTTreeService();
        BTNode root = null;
        root = btTreeService.insert(root,8);
        root = btTreeService.insert(root,5);
        root = btTreeService.insert(root,15);
        root = btTreeService.insert(root,3);
        root = btTreeService.insert(root,12);
        root = btTreeService.insert(root,6);
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
    }
}
