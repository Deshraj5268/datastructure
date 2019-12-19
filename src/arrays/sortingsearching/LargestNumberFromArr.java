package arrays.sortingsearching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumberFromArr {


    public static void main(String[] args) {

        //String [] arr = {"54", "546", "548", "60"};

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            //int k = sc.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = String.valueOf(sc.nextInt());
            }
            System.out.println();
            Arrays.sort(arr,new Comparator<String>(){

                @Override
                public int compare(String x,String y){
                    StringBuilder sbXY = new StringBuilder(x).append(y);
                    StringBuilder sbYX = new StringBuilder(y).append(x);
                    return (sbXY.toString().compareTo(sbYX.toString())>0?-1:1);
                }
            });
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<arr.length;i++){
                sb.append(arr[i]);
            }
            System.out.println(sb.toString());
        }



    }
}
