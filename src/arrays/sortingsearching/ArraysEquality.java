package arrays.sortingsearching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
* Author : Deshraj Thakur
* GitHub link : https://github.com/Deshraj5268?tab=repositories
* */
/*
*Given two arrays A and B of equal size N, the task is to find if given arrays are equal or not. Two arrays are
* said to be equal if both of them contain same set of elements, arrangements (or permutation) of elements may be
* different though.
Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.
*/
public class ArraysEquality {


    //brute force
    //public int

    //using sorting
    public static int arraysEqualityUsingSorting(int [] arr1,int []arr2){
        if(arr1 == null && arr2 == null){
            return 1;
        }
        if(arr1 == null || arr2 == null){
            return 0;
        }
        if(arr1.length != arr2.length){
            return 0;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return 0;
            }
        }
        return 1;
    }

    public static int arraysEqualitySuingHashMap(int [] arr1,int []arr2){
        Map<Long,Long> map = new HashMap<>();
        Long value;
        for(long x:arr1){
            value = map.get(x);
            if(value == null){
                map.put(x,1L);
            }else{
                map.put(x,value+1);
            }
        }
        for(long y:arr2){
            value = map.get(y);
            if(value == null){
                return 0;
            }else{
                map.put(y,value-1);
            }
        }

        Collection<Long> valueSet = map.values();

        for(Long result:valueSet){
            if(result != 0){
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) throws Exception{
        int [] arr1 = {1,3,4,5,6,3,3};
        int [] arr2 = {6,5,1,4,3,3,3};
        System.out.println(arraysEqualityUsingSorting(arr1,arr2));
        System.out.println(arraysEqualitySuingHashMap(arr1,arr2));
       /* BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
        int t =Integer.parseInt(inp.readLine());
        while(t>0){
            int s= Integer.parseInt(inp.readLine());
            int [] arr1 = new int[s];
            int [] arr2 = new int[s];
            String [] str1 = inp.readLine().split("\\s+");
            String [] str2 = inp.readLine().split("\\s+");
            for(int i=0;i<s;i++){
                arr1[i] = Integer.parseInt(str1[i]);
            }
            for(int i=0;i<s;i++){
                arr2[i] = Integer.parseInt(str2[i]);
            }
            System.out.println(arraysEqualityUsingSorting(arr1,arr2));
            t--;
        }*/
        /*Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int l = sc.nextInt();
            int [] arr1 = new int[l];
            int [] arr2 = new int[l];
            for(int i=0;i<l;i++){
                arr1[i] = sc.nextInt();
            }
            for(int i=0;i<l;i++){
                arr2[i] = sc.nextInt();
            }
            System.out.println(arraysEqualityUsingSorting(arr1,arr2));
            t--;
        }*/

    }
}
