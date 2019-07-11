package arrays.sortingsearching;

public class QuickSort {

    public static int pivot(int [] arr,int p,int q){
        int pv = arr[p];
        int i = p;
        for(int j = p+1;j<=q;j++){
            if(pv >= arr[j]){
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i];
        arr[i] = arr[p];
        arr[p] = temp;
        return i;
    }

    public static void quickSort(int [] arr,int s,int e){
        if(s<e){
            int m = pivot(arr,s,e);
            quickSort(arr,s,m-1);
            quickSort(arr,m+1,e);
        }
    }

    public static void main(String[] args) {
        int [] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length-1;
        quickSort(arr,0,n);
        for(int i = 0;i<=n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
