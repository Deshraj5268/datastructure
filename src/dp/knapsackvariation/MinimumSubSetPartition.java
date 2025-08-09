package dp.knapsackvariation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10*/
public class MinimumSubSetPartition {

    public static void main(String[] args) {
        int [] arr = {1, 6, 11, 5};//{5,100,200,-10,-10,-50}
        System.out.println("input : "+ Arrays.toString(arr));
        int minSum = minimumSubsetPartition(arr,arr.length);
        System.out.println("minSum : "+minSum);
    }

   /*
   * s1-s2 = minimum
   * 0------sum
   * s1+s2 = sum
   * 
   * s1-(sum-s1)= minimum
   * abs(2*s1-sum) == minimum
   * */
    public static int minimumSubsetPartition(int [] arr,int n){
        int sum = SubSetSum.calculateSum(arr);
        List<Integer> result = getAllPossibleMinSubSet(arr,n,sum);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<result.size();i++){
            min = Math.min(min,(sum-2*result.get(i)));
            System.out.println(min);
        }
        return min;
    }

    public static List<Integer> getAllPossibleMinSubSet(int [] arr,int n,int sum){
        List<Integer> result = new ArrayList<>();
        boolean [][] tab = SubSetSum.subSetSumTable(arr,n,sum);

        for(int s=0;s<(sum/2);s++){
            if(tab[n][s]){
                result.add(s);
            }
        }
        return result;
    }
}
