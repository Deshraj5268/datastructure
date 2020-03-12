package arrays.rearrange;

import java.util.Scanner;

public class RearrangeArrayIndexWthPos {

    public static void arrangeArray(int [] arr){

        if(arr == null || arr.length == 0){
            return;
        }
        int temp;
        for(int i=0;i<arr.length;i++){
            while(arr[i]>=0 && arr[i]!=i){
                temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
            }

        }
    }

    public static void main (String[] args) {
        //code

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            arrangeArray(arr);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            t--;
        }

    }
}
