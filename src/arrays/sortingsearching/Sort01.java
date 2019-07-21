package arrays.sortingsearching;

public class Sort01 {


    public static void sort01(int [] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        int p=0;
        int i=0;
        int x= 1;
        int l = arr.length-1;
        for(int j = 0;j<=l;){
            if(arr[j] == 1){
                i = arr[j];
                arr[j] = arr[l];
                arr[l] = i;
                l--;
                continue;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        int [] arr = {0, 0, 1, 1, 0};
        sort01(arr);
       for(int i:arr){
           System.out.print(i+" ");
       }
    }
}
