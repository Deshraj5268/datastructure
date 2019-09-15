package leetcode;

import java.util.Arrays;

public class DuplicateWnRange_prob287 {

    //duplicate must exist
    public static int findDuplicate(int[] arr) {
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] == arr[i+1]){
                return arr[i];
            }
        }
        return 0;
    }

    public static int findDuplicateUsingCyclingDetection(int [] arr){
        int tortoise = arr[0];
        int hare = arr[0];
        do{
            tortoise = arr[tortoise];
            hare = arr[arr[hare]];
        }while (tortoise != hare);

        int part1 = arr[0];
        int part2 = arr[tortoise];
        while (part1 != part2){
            part1 = arr[part1];
            part2 = arr[part2];
        }
        return part1;
    }


    public static void main(String[] args) {

        int [] arr = {1,4,6,6,6,2,3};
        int result = findDuplicate(arr);
        System.out.println(result);
        System.out.println("using floyd's algorithms "+findDuplicateUsingCyclingDetection(arr));
    }
}
