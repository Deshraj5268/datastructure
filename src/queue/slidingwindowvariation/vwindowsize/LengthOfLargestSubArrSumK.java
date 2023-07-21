package src.queue.slidingwindowvariation.vwindowsize;

import java.util.Arrays;

public class LengthOfLargestSubArrSumK {

    public static void main(String[] args) {

        int [] arr = { 10, 5, 2, 7, 1, 9 };
        int n = arr.length;
        int k = 15;
        int result = lengthOfLargestSubArrSumK(arr,n,k);
        System.out.println("input "+ Arrays.toString(arr)+
                "sum : "+k+"\nLength = "+result);

    }

    public static int lengthOfLargestSubArrSumK(int [] arr,int n,int k){
        int sum = 0;
        int i=0,j=0;
        int maxLen = 0;
        while(j<n){
            sum += arr[j];
            if(sum < k){
                j++;
            }else {
                while(sum > k){
                    sum -= arr[i];
                    i++;
                }
                if(sum == k){
                    if(maxLen < (j-i+1)){
                        maxLen = (j-i+1);
                    }
                }
                j++;
            }
        }
        return maxLen;
    }
}
