package arrays.sortingsearching.mergesortapps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *https://takeuforward.org/plus/dsa/problems/union-of-two-sorted-arrays
 *  https://takeuforward.org/data-structure/union-of-two-sorted-arrays/
 * */
public class UnionTwoArray {

    public static void main(String[] args) {
        int [] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int [] nums2 = {2, 3, 4, 4, 5, 11, 12};
        System.out.println(Arrays.toString(unionOfTwoArray(nums1, nums2)));
    }


    /*
    * mergeSort way
    * There may be cases like the element to be inserted is already present in the union, in that case,
    * we are inserting duplicates which is not desired. So while inserting always check whether the last element
    * in the union vector is equal or not to the element to be inserted. If equal we are trying to insert
    * duplicates, so don’t insert the element, else insert the element in the union.
    * This makes sure that we are not inserting any duplicates in the union because we are inserting
    * elements in sorted order.*/
    public static int [] unionOfTwoArray(int [] nums1, int [] nums2){
        List<Integer> result = new ArrayList<>();
        int i=0,j=0,n= nums1.length, m = nums2.length;
        while (i < n && j < m){

            if(nums1[i] <= nums2[j]){
                if(result.size() == 0 || result.get(result.size()-1) != nums1[i]){
                    result.add(nums1[i]);
                }
                i++;
            }else {
                if(result.size() == 0 || result.get(result.size()-1) != nums2[j]){
                    result.add(nums2[j]);
                }
                j++;
            }
        }

        while (i < n){
            if(result.size() == 0 || result.get(result.size()-1) != nums1[i]){
                result.add(nums1[i]);
            }
            i++;
        }
        while (j < m){
            if(result.size() == 0 || result.get(result.size()-1) != nums2[j]){
                result.add(nums2[j]);
            }
            j++;
        }

        return result.stream().mapToInt(Integer:: intValue).toArray();
    }
}
