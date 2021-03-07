package arrays.subarray;

import java.util.HashMap;
import java.util.Map;

public class LongestArrSumDivByK {

    static class MinMax{
        int min;
        int max;
        public MinMax(int min,int max){
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        int [] arr =  {-2, 2, -5, 12, -11, -1, 7};// 20 13 11 14 2 7 4 2 6 7 6 1 , k=1 , output 13
        int k=3;
        System.out.println(longSubarrWthSumDivByK(arr,arr.length,k));
    }

    public static int longSubarrWthSumDivByK(int arr[], int n, int k) {
        if(k<1){
            return 0;
        }
        int sum = 0;
        int max = 0;
        MinMax val;
        Map<Integer,MinMax> map = new HashMap<>(k);

        int rem = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            rem = ((sum%k)+k)%k;// k = 5 for neg num S[0-3] = -2 , S[0-5] = 3 == 3-(-2) = 5

            if(rem == 0){
                max = i+1;  // individual also be sub arr
            }else{
                val = map.get(rem);
                if(val == null){
                    map.put(rem,new MinMax(i,i));
                }else{
                    val.max = i;
                    if(max < (val.max-val.min)){  //sub arr min+1 to max : min> <=max
                        max = val.max-val.min;
                    }
                    map.put(rem,val);
                }
            }
        }
        return max;
    }
}
