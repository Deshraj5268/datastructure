package leetcode.topinterviewquestion150;

import java.util.Arrays;

public class MajorityElement_169 {

    public static void main(String[] args) {

        int [][] mat = {{1,2,3,4,4,4,4},{3,2,3}};
        int result;
        for (int i=0;i<mat.length;i++){
            System.out.println("input : "+ Arrays.toString(mat[i]));
            result = majorityElement(mat[i]);
            System.out.println("result : "+result);
        }
    }

    public static int majorityElement(int[] nums) {
        int majority = nums[0];
        int count=1;
        for(int num:nums){
            if(majority == num){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                majority = num;
                count=1;
            }
        }
        return majority;
    }
}
