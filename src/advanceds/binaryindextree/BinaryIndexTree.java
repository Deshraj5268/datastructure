package advanceds.binaryindextree;

/* https://www.youtube.com/watch?v=v_wj_mOAlig */

public class BinaryIndexTree {

    public static void main(String[] args) {
        int [] arr = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9,13,14,15,16,17};
        int [] binaryIndexTree = constructBinaryIndexTree(arr,arr.length);

        System.out.println("creation finish");
        System.out.println(getSum(binaryIndexTree,7));

        update(binaryIndexTree,3,arr.length,6);
        System.out.println(getSum(binaryIndexTree,5));
    }


    public static int [] constructBinaryIndexTree(int [] arr, int n){
        int [] binaryIndexArr = new int[n+1];

        for(int i=1;i<n;i++){
            System.out.print(i+" inirial  ");
            update(binaryIndexArr,i,n,arr[i-1]);
            System.out.println();
        }
        return binaryIndexArr;
    }

    /*2's complement (-index)
    and with original no , i.e. get the right most set bit
    subtract with original no get parent
    final : remove last set bit from current number
    * */
    private static int getParent(int index){
        return (index - (index & -index));
    }

    /*final : add last set bit in current number*/
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
            System.out.print(index+" ");
        }
    }


}
