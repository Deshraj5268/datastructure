package tree.binarytree;

public class PathSumExist {


    public static void main(String[] args) {
        int [] arr = {8,5,9,3};
        BTNode root = new BTTreeService().createBT(arr);
        boolean isPathSumExist = isPathSumExist(root,0);
        System.out.println("result : "+isPathSumExist);
    }
    public static boolean isPathSumExist(BTNode root,int targetSum){
        return hasPathSumUtil(root,0,targetSum);
    }

    public static boolean hasPathSumUtil(BTNode root,int sum,int targetSum){
        if(root == null){
            return false;
        }

        sum+= root.data;
        if(root.left == null && root.right == null){
            return (sum == targetSum);
        }
        return hasPathSumUtil(root.left,sum,targetSum) || hasPathSumUtil(root.right,sum,targetSum);
    }
}
