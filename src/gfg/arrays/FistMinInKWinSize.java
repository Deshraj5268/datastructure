package gfg.arrays;

public class FistMinInKWinSize {

    //First negative integer in every window of size k
    public static void firstMinInWindowSizeK(int [] arr,int n,int k){

        if(n<k){
            return ;
        }
        int min;
        for(int i=1;i<n-k;i++){
            min = arr[i-1];
            for(int j=i-1;j<(i+k-1);j++){
                if(min > arr[j]){
                    min  = arr[j];
                }
            }
            if(min < 0){
                System.out.print(min +" ");
            }else{
                System.out.println(0+" ");
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {-8, 2, 3, -6 ,10};
        int k = 3;

        firstMinInWindowSizeK(arr,arr.length,k);
    }
}
