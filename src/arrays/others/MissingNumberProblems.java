package arrays.others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumberProblems {

    public static void main(String[] args) {
        System.out.println("testFirstMissingPositive");
        testFirstMissingPositive();
        System.out.println("testFindDuplicate");
        testFindDuplicate();
    }

    public static void testFirstMissingPositive(){
        int [][] matrix = {{1,2,0},
                {1},
                {1,1},
                {3,4,-1,1},
                {7,8,9,11,12},
                {1,2,0},
                {0,2,2,1,1}

        };
        int [] expectedArr = {3,2,2,2,1,3,3};
        int [] result = new int[expectedArr.length];
        int [] resultSorting = new int[expectedArr.length];
        for(int i=0;i<result.length;i++){
            result[i] = firstMissingPositive(matrix[i]);
            resultSorting[i] = firstMissingPositiveHashing(matrix[i]);
                   // firstMissingPositiveSorting(matrix[i]);
        }
        for(int i=0;i<result.length;i++){
            if(result[i] != expectedArr[i] && resultSorting[i] != expectedArr[i]){
                System.out.println(result[i]+ " "+expectedArr[i] + " "+resultSorting[i]);
            }else {
                System.out.println("input : "+Arrays.toString(matrix[i]));
                System.out.println("result is as expected for input "+ expectedArr[i]);
            }
        }
    }

    public static void testFindDuplicate(){
        int [][] matrix = {{3,1,3,4,2},
                {1,3,4,2,2},
                {1,1},
                {1,4,4,2,4},
                {1,1,2},
                {1,1,1},
                {1,2,2,2}
        };
        int [] expectedArr = {3,2,1,4,1,1,2};
        int [] result = new int[expectedArr.length];
        for(int i=0;i<result.length;i++){
            result[i] = findDuplicate(matrix[i]);
        }
        for(int i=0;i<result.length;i++){
            if(result[i] != expectedArr[i]){
                System.out.println(result[i]+ " "+expectedArr[i]);
            }else {
                System.out.println("result is as expected for index matrix "+ i);
            }
        }
    }


    public static int firstMissingPositiveSorting(int[] nums) {

        Arrays.sort(nums);
        int prev = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] <= 0 || (i+1<n && nums[i] == nums[i+1])){
                continue;
            }else if(nums[i] > 0 && nums[i]-prev == 1){
                prev = nums[i];
            }else{
                return prev+1;
            }
        }
        return prev+1;
    }

    //2nd way

    public static int firstMissingPositiveHashing(int [] arr){
        Set<Integer> set = new HashSet<>();
        for(int x:arr){
            set.add(x);
        }
        int n = arr.length;
        for(int i=1;i<n+1;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return n+1;
    }
    /*
    *
    * */
    public static int firstMissingPositive(int[] nums) {

        int i=0;
        int n = nums.length;
        int val;
        while(i<n){
            val = nums[i];
            if(val > n || val <= 0){
                nums[i] = -1;
            }else if(val-1 != i && (val != nums[val-1])){ // (val != nums[val-1]) forming the circle
                nums[i] = nums[val-1];
                nums[val-1] = val;
                continue;
            }
            i++;
        }
        i=1;
        while(i-1<n && nums[i-1] == i){
            i++;
        }
        return i;
    }


    /*
    * https://www.youtube.com/watch?v=L1u-R_s2Mok&t=41s
    * */
    public int firstMissingPositiveNegativeArray(int[] arr) {
        int n = arr.length;
        boolean onePresent = false;
        for(int i=0;i<n;i++){
            if(arr[i] == 1){
                onePresent = true;
                break;
            }
        }
        //not present
        if(!onePresent){
            return 1;
        }
        if(n == 1){
            return 2;
        }

        // make 1  all use less less than 0 or greater than n
        for(int i=0;i<n;i++){
            if(arr[i]<=0 || arr[i]>n){
                arr[i] = 1;
            }
        }

        // negating value if present
        int x;
        for(int i=0;i<n;i++){
            x = Math.abs(arr[i]);
            if(arr[x-1] >0){
                arr[x-1] *= -1;
            }

        }

        for(int i=0;i<n;i++){
            if(arr[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }

    /*
    * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive
    * All the integers in nums appear only once except for precisely one integer which appears two or more times.
    * solution : we start with index 0. Since all numbers are in the range [1, n][1,n], they will be mapped to indices 11
    *  through nn inclusive, and hence no number will be mapped to index 00
    * https://leetcode.com/problems/find-the-duplicate-number/solution/
    *
    * [1,4,4,2,4] n = 5 , [1,n] = [1,4] it wont solve using xor approach , output 4
    * */
    public static int findDuplicate(int[] nums) {
        int temp;
        while(nums[0] != nums[nums[0]]){
            temp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = temp;

        }
        return nums[0];
    }

    public int findDuplicateUsingFloydAlgo(int[] nums) {

        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];

        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];

        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }

    public int findDuplicateSloFastPointer(int[] nums) {

        int s,f;
        s = f = 0;
        while(true){
            s = nums[s];
            f = nums[nums[f]];
            if(s == f){
                break;
            }
        }
        int s1 = 0;
        while(true){
            s = nums[s];
            s1 = nums[s1];
            if(s1 == s){
                break;
            }
        }
        return s1;

    }
}
