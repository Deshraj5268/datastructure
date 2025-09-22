package leetcode.topinterviewquestion150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Article
* https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/
* */
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

    /* Majority element always exist*/
    public static int majorityElement(int[] nums) {
        int majority = Integer.MAX_VALUE;
        int count=0;
        for(int num:nums){
            if(count == 0){
                majority = num;
                count=1;
            }else if(majority == num){
                count++;
            }else{
                count--;
            }
        }
        return majority;
    }

    //https://leetcode.com/problems/majority-element-ii/description/
    //https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/

    public static List<Integer> majorityElementNby3(int[] nums) {
        List<Integer> result  = new ArrayList<>(2);
        int count1 = 0, count2 = 0;
        int element1 = Integer.MAX_VALUE, element2 = Integer.MAX_VALUE;
        for(int val : nums){
            if(element1 == val){
                count1++;
            }else if(element2 == val){
                count2++;
            }else if(count1 == 0){
                count1 = 1;
                element1 = val;
            }else if(count2 == 0){
                count2 = 1;
                element2 = val;
            }else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for(int val : nums){
            if(element1 == val){
                count1++;
            }else if(element2 == val){
                count2++;
            }
        }

        if(count1>nums.length/3 ){
            result.add(element1);
        }
        if(count2>nums.length/3 ){
            result.add(element2);
        }

        return result;
    }
}
