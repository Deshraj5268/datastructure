package dp.kadansAlgo;

import java.util.Arrays;

/*https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/*/
public class MaxSumWOSlct2 {

    public static int maxSubArrSumWOSelecting2ConEle(int [] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        if(arr.length == 1){
            return arr[0];
        }
        int [] arrSum = new int[arr.length];
        arrSum[0] = arr[0];
        arrSum[1] = Math.max(arr[0], arr[1]);
        for(int i=2;i<arr.length;i++){
            arrSum[i] = Math.max(arrSum[i - 1], (arrSum[i - 2] + arr[i]));
        }
        System.out.println(Arrays.toString(arrSum));
        return arrSum[arr.length-1];
    }

    public static void main(String[] args) {
        int [] arr = {5, 5, 10, 100, 10, 5};
        System.out.println(Arrays.toString(arr));
        System.out.println("array sum : "+maxSubArrSumWOSelecting2ConEle(arr));
    }
}
