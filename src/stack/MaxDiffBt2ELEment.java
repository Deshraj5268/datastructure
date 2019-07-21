package stack;

public class MaxDiffBt2ELEment {

    public static int maxDiffBtTwoElements(int [] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(max < (arr[j]-arr[i])){
                    max = arr[j]-arr[i];
                }
            }
        }
        return max;
    }

    

    public static void main(String[] args) {
        int [] arr = {1, 2, 90, 10, 110};
        System.out.println(maxDiffBtTwoElements(arr));
    }
}
