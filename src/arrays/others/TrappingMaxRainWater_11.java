package arrays.others;

public class TrappingMaxRainWater_11 {

    /*input length 3 to n
    * */
    protected static int width = 1;
    public static void main(String[] args) {
        int [][] arr = {{1,8,6,2,5,4,8,3,7},
                {1,2,3,4,5,6},
                {4,3,2,1},
                        {1,2,3,4},
                        {3, 0, 2, 0, 4},
                        {4,0,1,6,2,5}
                      }; // non negative numbers
        for(int i=0;i<arr.length;i++) {
            int result1 = trappingRainWater(arr[i]);
            int result3 = trappingRainWaterSpaceOptimize(arr[i]);
            System.out.println(result1 + " "+result3);
        }
    }

    /*
    * find two bars and take min i.e (min(maxInleft,maxInright))*width
    * TC O(n2)
    * SC O(1)
    * */
    public static int trappingRainWater(int [] arr){
        int resultantWater = 0;
        int currentWater=0;
        if(arr == null || arr.length < 3){
            return resultantWater;
        }
        int l = arr.length;
        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                if(resultantWater < (j-i)*Math.min(arr[i],arr[j])){
                    resultantWater = (j-i)*Math.min(arr[i],arr[j]);
                }
            }
        }
        return resultantWater;
    }


    /*
    *At every index , The amount of rain water stored is the difference between
    * two max line -- max height of two line and width should be high
    *
    * https://www.youtube.com/watch?v=UuiTKBwPgAo
    *
    * */
    public static int trappingRainWaterSpaceOptimize(int [] arr){
            int n = arr.length;
            int l=0,r=n-1,leftMax=arr[0],rightMax=arr[n-1],maxWater=0;

            int currentWater=0;
            while(l<r){
                if(leftMax<=rightMax){
                    currentWater = (r-l)*Math.min(leftMax,rightMax);
                    l++;
                    leftMax = arr[l];
                }else{
                    currentWater = (r-l)*Math.min(leftMax,rightMax);
                    r--;
                    rightMax = arr[r];
                }
                if(maxWater < currentWater){
                    maxWater = currentWater;
                }
            }
            return maxWater;
    }

    private static int findMax(int[] arr, int l, int r) {
        int max = arr[l];
        for(int i=l+1;i<=r;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}