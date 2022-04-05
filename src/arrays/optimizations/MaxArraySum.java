package arrays.optimizations;


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

    public int maxSubArray(int[] nums) {
        int [] maxSubArr = new int[nums.length];
        int max = maxSubArr[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            if(maxSubArr[i-1] > 0){
                maxSubArr[i] = maxSubArr[i-1]+nums[i];

            }else{
                maxSubArr[i] = nums[i];
            }
            if(max < maxSubArr[i]){
                max = maxSubArr[i];
            }
        }
        return max;
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

    /*
    *  max ( (fun(i-1) + A[i]),A[i])
    * */
    public static int maxContiguousSubArrSumDp(int [] arr){
        if(arr == null || arr.length == 0){
            return Integer.MIN_VALUE;
        }
        int [] mArr = new int[arr.length];
        mArr[0] = arr[0];
        int n = arr.length;
        int maxSum = arr[0];
        int startP = 0;
        int endP = 0;
        for (int i=1;i<n;i++){
            if(mArr[i-1] + arr[i] > arr[i]){
                mArr[i] = mArr[i-1] + arr[i];
                if(maxSum < mArr[i]){
                    maxSum = mArr[i];
                    endP = i;
                }
            }else {
                mArr[i] = arr[i];
                startP = i;
                endP = i;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(startP + " to "+endP);
        return maxSum;
    }

    public static int maxContiguousSubArrSumDpWOSpace(int [] arr){
        if(arr == null || arr.length == 0){
            return Integer.MIN_VALUE;
        }
        int n = arr.length;
        int maxSum = arr[0];
        int currentSum = arr[0];
        int startP = 0;
        int endP = 0;
        for (int i=1;i<n;i++){
            if(currentSum + arr[i] > arr[i]){
                currentSum = currentSum + arr[i];
                if(maxSum < currentSum){
                    maxSum = currentSum;
                    endP = i;
                }
            }else {
                currentSum = arr[i];
                startP = i;
                endP = i;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(startP + " to "+endP);
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

        /*int [] arr =  {-2, -3, 4, -1, -2, 1, 5, -8,9,120,8};
        System.out.println(Arrays.toString(arr));
        //System.out.println(maxSubArraySumDp(arr));
        System.out.println("maxSum : "+maxSubArraySumDp(arr));

        System.out.println("max sum for negative num : "+maxSubArraySumWithNegNumCase(arr));*/
        int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxContiguousSubArrSumDp(arr));
        System.out.println(maxContiguousSubArrSumDpWOSpace(arr));
    }
}