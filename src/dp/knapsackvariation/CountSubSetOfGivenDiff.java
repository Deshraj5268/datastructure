package dp.knapsackvariation;

import java.util.Arrays;


/*
* https://www.geeksforgeeks.org/count-of-subsets-with-given-difference/
* */
public class CountSubSetOfGivenDiff {

    public static void main(String[] args) {
        int [][] mat = {{5, 2, 6, 4},
                {1, 2, 3, 3},
                {1, 2, 3, 1, 2}
                };
        // {-3, 1, 3, 5}, 6
        int [] diffArr = {3,6,1};
        for(int i=0;i<mat.length;i++) {
            System.out.println("input array : " + Arrays.toString(mat[i]) + " sum : " + diffArr[i]);
            int result = countSubSetWithGivenSum(mat[i], diffArr[i]);
            System.out.println("count of subset sum " + result);
        }
    }


    /*
    * s1-s2 = diff
    * s1+s2 = sum
    * s1= (sum+diff)/2
    * find subSet count(s1)
    * */
    public static int countSubSetWithGivenSum(int [] arr,int setDiff){
       int sum = SubSetSum.calculateSum(arr);
       int subSetSum = (setDiff+sum)/2;
       int result = CountOfSubSetSum.countSubSetSum(arr,arr.length,subSetSum);
       return result;
    }
}
