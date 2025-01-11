package leetcode.topinterviewquestion150.arraysString;


import java.util.Arrays;

/*
 *
 * https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
 * */
public class RemoveDuplicate_27 {

    public static void main(String[] args) {
        int [][] matArr = {{3,2,2,3},
                {0,1,2,2,3,0,4,2}
        };
        int [] targets = {3, 2};
        for(int i=0;i<matArr.length;i++){
            System.out.println("original array "+Arrays.toString(matArr[i]) + " target element : "+targets[i]);
            int valIndex = removeTargetedDuplicateElement(matArr[i] , targets[i]);
            System.out.println("valIndex "+valIndex);
            System.out.print("result Array : ");
            printRemovedTargetedElement(matArr[i], valIndex);
            System.out.println();
        }
    }

    public static int removeTargetedDuplicateElement(int [] arr, int target ){
        int valIndex = 0;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] != target){
                arr[valIndex] = arr[i];
                valIndex++;
            }
        }
        return valIndex;
    }

    private static void printRemovedTargetedElement(int[] arr, int valIndex) {
        for(int i=0;i<valIndex;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
