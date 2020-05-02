package tree.advancetree;

public class BinaryIndexTree {

    public static void main(String[] args) {
        int [] arr = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        int [] binaryIndexTree = constructBinaryIndexTree(arr,arr.length);

        System.out.println(getSum(binaryIndexTree,5));

        update(binaryIndexTree,3,arr.length,6);
        System.out.println(getSum(binaryIndexTree,5));
    }


    public static int [] constructBinaryIndexTree(int [] arr, int n){
        int [] binaryIndexArr = new int[n+1];

        for(int i=1;i<n;i++){
            update(binaryIndexArr,i,n,arr[i-1]);
        }
        return binaryIndexArr;
    }

    private static int getParent(int index){
        return (index - (index & -index));
    }

    private static int getNext(int index){
        return (index + (index & -index));
    }

    public static int getSum(int []binaryIndexArr,int index){
        int sum = 0;
        while (index>0){
            sum += binaryIndexArr[index];
            index = getParent(index);
        }
        return sum;
    }

    public static void update(int [] binaryIndexArr,int index,int n,int val){
        while (index < n){
            binaryIndexArr[index] += val;
            index = getNext(index);
        }
    }


}
