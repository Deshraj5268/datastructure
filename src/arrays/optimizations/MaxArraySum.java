package arrays.optimizations;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
* In another word . we have to find maximum difference between two elements with i<j condition
* */

class MaxArraySum
{
    public static int maxSubArraySum(int [] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum = 0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum>maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }


    public static int maxSubArraySumDp(int [] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int maxSum = arr[0];
        int sum = arr[0];
        int maxIndex = 0;
        int start = 0;
        int minIndex = 0;
        for(int i=1;i<arr.length;i++){
            sum += arr[i];
            if(sum>0){
                if(maxSum < sum){
                    maxSum = sum;
                    maxIndex = i;
                    minIndex = start;
                }
            }else{
                sum = 0;
                start = i+1;
            }
        }
        System.out.println("minIndex "+minIndex+" maxIndex "+maxIndex);
        return maxSum;
    }


    public static int maxSubArrSumTabDp(int [] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int [] arrSum = new int[arr.length+1];
        int maxSum = 0;
        int negSum = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i=0;i<arr.length;i++){
            //arrSum[i+1] = ;
            if(arrSum[i]+arr[i]>0){
                arrSum[i+1] = arrSum[i]+arr[i];
                if(maxSum<arrSum[i+1]){
                    maxSum = arrSum[i+1];
                }
                flag = true;
            }else {
                if(arr[i]<0){
                    if(negSum<arr[i]){
                        negSum = arr[i];
                    }
                }
            }
        }
        return (flag?maxSum:negSum);
    }


    public static int maxSubArrSumWOSpace(int [] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int sum = 0;
        int maxSum = 0;
        int negSum = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i=0;i<arr.length;i++){
            sum +=arr[i];
            if(sum>0){
                if(maxSum<sum){
                    maxSum = sum;
                    flag = true;
                }
            }else {
                if(arr[i]<0){
                    sum = 0;           //-2 5 -3
                    if(negSum<arr[i]){
                        negSum = arr[i];      //for all -Ve
                    }
                }
            }
        }
        return (flag? maxSum: negSum);
    }

    public static int maxSubSumArrayTLFree(int [] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        int sum = 0;
        int maxSum = 0;
        int c =0;
        for(int i=0;i<arr.length;i++){
            sum +=arr[i];
            if(sum<0) {
                sum = 0;
                c++;
            }
            else if(maxSum<sum){
                maxSum = sum;
            }
        }
        if(c!=arr.length){
            return maxSum;
        }else{
            Arrays.sort(arr);
            return arr[arr.length-1];
        }
    }

    public static int maxSubArraySumWithNegNumCase(int [] arr){
        if(arr == null || arr.length == 0){
            return Integer.MIN_VALUE;
        }
        int maxSum = arr[0];
        int currentSum = arr[0];
        for(int i=1;i<arr.length;i++){
            currentSum = Math.max(arr[i],currentSum+arr[i]);
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }

    public static void main (String[] args) {
        //code
        /*int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while(t>0){
            t--;
            int s= sc.nextInt();
            int [] arr = new int[s];
            for(int i=0;i<s;i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(maxSubArraySumDp(arr));


             int t;
        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
        t =Integer.parseInt(inp.readLine());
        while(t>0){
            int s= Integer.parseInt(inp.readLine());
            int [] arr = new int[s];
            String [] str = inp.readLine().split("\\s+");
            for(int i=0;i<s;i++){
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(maxSubArraySum(arr));
            t--;
        }
        }*/


        /*BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
        int T= Integer.parseInt(inp.readLine());*/

        int [] arr =  {-2, -3, 4, -1, -2, 1, 5, -8,9,120,8};
        System.out.println(Arrays.toString(arr));
        //System.out.println(maxSubArraySumDp(arr));
        System.out.println("maxSum : "+maxSubArraySumDp(arr));

        System.out.println("max sum for negative num : "+maxSubArraySumWithNegNumCase(arr));
    }
}