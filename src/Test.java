public class Test {



    /*
    *
    * Given a sorted array of distinct integers and a
    * target value, return the index if the target is found.
    * If not, return the index where it would be if it were inserted in order.
    * */
    public static void main(String[] args) {

       // System.out.println("hello world");

        int [] arr = {1,3,4,8};
        int target = 2;
        int result = findPosition(arr,target);
        System.out.println("position : "+result);
    }

    // O(n)
    // O(logn) BS

    public static int findPosition(int [] arr,int target){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int l=0,r=arr.length-1;
        if(arr[0] > target){
            return 0;
        }
        if(arr[r] < target){
            return arr.length;
        }

        int m;

        while (l<=r){
            m = l+(r-l)/2;//mid pos
            if(arr[m] == target){
                return m;
            }else if(arr[m] < target){
                l = m+1;
            }else {
                r = m-1;
            }
        }
        return l;
    }
}
