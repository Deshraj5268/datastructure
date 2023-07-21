package src.queue.slidingwindowvariation;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
* QU : https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
* */
public class FirstNegativeInEveryWinK {

    public static void main(String[] args) {

        int[] winSizes = {3};
        long[][] arrays = {{12, -1, -7, 8, -15, 30, 16, 28},
        };
        long[][] outputArr = {{-1, - 1, - 7, - 15, - 15, 0}
                              };
        long [] result;
        for(int i=0;i<arrays.length;i++){
            result = printFirstNegativeInteger(arrays[i],arrays[i].length,winSizes[i]);
            System.out.println("resultOpt : "+Arrays.toString(result)+ " \n expected :"+Arrays.toString(outputArr[i]));
        }
    }

    public static long[] printFirstNegativeInteger(long [] arr, int n, int k) {
        long [] result = new long[n-k+1];
        int j=0,i=0;
        long ZERO = 0;
        Deque<Integer> dq = new LinkedList<>();
        while(j<n){
            if(arr[j]< ZERO){
                dq.addLast(j);
            }
            if((j-i+1) < k){
                j++;
            }else {
                if(!dq.isEmpty()){
                    result[i] = arr[dq.peekFirst()];
                }else{
                    result[i] = ZERO;
                }
                if(!dq.isEmpty() && (j-dq.peekFirst()+1)>=k){
                    dq.removeFirst();
                }
                j++;
                i++;
            }
        }
        return result;

    }
}
