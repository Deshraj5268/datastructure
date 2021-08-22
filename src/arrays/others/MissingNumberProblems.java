package arrays.others;

public class MissingNumberProblems {

    public static void main(String[] args) {
        System.out.println("testFirstMissingPositive");
        testFirstMissingPositive();
        System.out.println("testFindDuplicate");
        testFindDuplicate();
    }

    public static void testFirstMissingPositive(){
        int [][] matrix = {{1},
                {1,1},
                {3,4,-1,1},
                {7,8,9,11,12},
                {1,2,0}
        };
        int [] expectedArr = {2,2,2,1,3};
        int [] result = new int[expectedArr.length];
        for(int i=0;i<result.length;i++){
            result[i] = firstMissingPositive(matrix[i]);
        }
        for(int i=0;i<result.length;i++){
            if(result[i] != expectedArr[i]){
                System.out.println(result[i]+ " "+expectedArr[i]);
            }else {
                System.out.println("result is as expected for index matrix "+ i);
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
    * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive
    * All the integers in nums appear only once except for precisely one integer which appears two or more times.
    * solution : we start with index 0. Since all numbers are in the range [1, n][1,n], they will be mapped to indices 11 through nn inclusive, and hence no number will be mapped to index 00
    * https://leetcode.com/problems/find-the-duplicate-number/solution/
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

}
