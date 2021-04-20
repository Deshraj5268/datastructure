package arrays.subarray;

public class ArrSumDivByK {


    public static void main(String[] args) {

        int [] arr = {4, 5, 0, -2, -3, 1};
        int k = 4;
        System.out.println(countSumArrSumDivByKOptimize(arr,arr.length,k));
    }

    //brute force
    /*
    * take ith element and check sum divisibility with all n-i
    * and count it
    * */
    public static int countSubArrSumIsDivByK(int [] arr,int n,int k){
        if(k<1){
            return 0;
        }
        int sum = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            sum = 0;
            for(int j=i;j<n;j++){
                sum += arr[j];
                if(sum % k == 0){
                    count++;
                }
            }
        }
        return count;
    }

    //https://www.youtube.com/watch?v=u9m-hnlcydk

    /*
    *sum(i,j) = sum(0,j)-sum(0,i) : is divisible by k
    *  sum(0,j) and sum(0,i) has reminder(R) is same we got (i,J) sun array
    * we need to count those Same R, then find out the possible pair(min 2 point is required)
    * Rc2 for all 2 to n: for 1 ==0 and if R == 0 Rc2+ R ( i.e that point itself be sub arr)
    * T : O(n)
    * S: O(k)
    * */
    public static int countSumArrSumDivByKOptimize(int [] arr,int n,int k){
        if(k<1){
            return 0;
        }
        int sum = 0;
        int [] tempK = new int[k];
        int rem = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            rem = ((sum%k)+k)%k;// k = 5 for neg num S[0-3] = -2 , S[0-5] = 3 == 3-(-2) = 5
            tempK[rem]++;
        }
        int result = tempK[0]; // for 0 ->nC2 + n pair possible
        for(int reminderCount: tempK){
            result += (reminderCount*(reminderCount-1))/2;// nC2 = n*(n+1)/2 counting all pairs
        }
        return result;
    }

}
