package arrays.optimizations;

import java.util.Arrays;

public class ProductArray {

    public static int [] productArrayExceptCurrentElement(int [] arr,int n){
        int [] resultProdArr = new int[n];
        if(arr == null || arr.length ==0){
            return resultProdArr;
        }
        if(arr.length == 1){
            resultProdArr[0] = 1;
            return resultProdArr;
        }
        int [] leftProArr = new int[n];
        int [] rightProArr = new int[n];
        leftProArr[0] = 1;
        rightProArr[n-1]= 1;
        for(int i=1;i<n;i++){
            leftProArr[i] =  arr[i-1]*leftProArr[i-1];
        }
        for(int j=n-2;j>=0;j--){
            rightProArr[j] = arr[j+1]*rightProArr[j+1];
        }

        for(int k=0;k<n;k++){
            resultProdArr[k] = leftProArr[k]*rightProArr[k];
        }
        return resultProdArr;
    }

    public static int [] productArrayExceptCurrentElement1(int [] arr,int n){
        int [] resultProdArr = new int[n];
        if(arr == null || arr.length ==0){
            return resultProdArr;
        }
        if(arr.length == 1){
            resultProdArr[0] = 1;
            return resultProdArr;
        }
        resultProdArr[0] = 1;
        for(int i=1;i<n;i++){
            resultProdArr[i] = arr[i-1]*resultProdArr[i-1];
        }
        int temp = arr[n-1];
        for(int j=n-2;j>=0;j--){
            resultProdArr[j] = resultProdArr[j]*temp;
            temp *= arr[j];
        }
        return resultProdArr;
    }

    public static void main(String[] args) {
        int [] arr = {2,3,4};
        int [] resultProdArr = productArrayExceptCurrentElement(arr,arr.length);
        System.out.println(Arrays.toString(resultProdArr));

        int [] resultProdArr1 = productArrayExceptCurrentElement1(arr,arr.length);
        System.out.println(Arrays.toString(resultProdArr1));
    }
}
