package arrays.sortingsearching.mergesortapps;

import java.util.ArrayList;
import java.util.List;


/*
*
*
* https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/*/
public class IntersectionThreeArray {

    public static void main(String[] args) {

        int ar1[] = { 1, 5, 10, 20, 40, 80 }; //{3,3,3}
        int ar2[] = { 6, 7, 20, 80, 100 };//{3,3,3}
        int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 120 }; //{3,3,3}

        System.out.print("Common elements are ");
        List<Integer> result = commonElements(ar1, ar2, ar3,ar1.length,ar2.length, ar3.length);
        result.stream().forEach(x-> System.out.print(x +" "));
    }


    /*
    *
    * all equal then move all
    * otherwise move index which has min element
    *
    *  move i with respect to second array (arr1[i]<arr2[j]) i++;
    * move j wrt third array
    * lse k
    * */
   public static List<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        // code here
        int i=0,j=0,k=0;
        ArrayList<Integer> result = new ArrayList<>();
        while(i<n1 && j<n2 && k<n3){

            // need to remove duplicate
            if(i+1 < n1 && A[i] == A[i+1]){
                i++;
                continue;
            }else if(j+1 < n2 && B[j] == B[j+1]){
                j++;
                continue;
            }else if(k+1 < n3 && C[k] == C[k+1]){
                k++;
                continue;
            }
            if(A[i] == B[j] && B[j] == C[k]){
                result.add(A[i]);
                i++;
                j++;
                k++;

            }else if(A[i] < B[j]){
                i++;
            }else if(B[j] < C[k]){
                j++;
            }else {
                k++;
            }
        }
        return result;
    }
}
