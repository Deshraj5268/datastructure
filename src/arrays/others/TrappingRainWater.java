package arrays.others;


/*https://www.youtube.com/watch?v=C8UjlJZsHBw*/
public class TrappingRainWater {

    /*input length 3 to n
    * */
    protected static int width = 1;
    public static void main(String[] args) {
        int [][] arr = {{4,3,2,1},
                        {1,2,3,4},
                        {3, 0, 2, 0, 4},
                        {4,0,1,6,2,5}
                      }; // non negative numbers
        for(int i=0;i<arr.length;i++) {
            int result1 = trappingRainWater(arr[i]);
            int result2 = trappingRainWaterUsingSpace(arr[i]);
            int result3 = trappingRainWaterSpaceOptimize(arr[i]);
            System.out.println(result1 +" "+result2+ " "+result3);
        }
    }

    /*
    * find two bars and take min i.e (min(maxInleft,maxInright)-currentHeight)*width
    * TC O(n2)
    * SC O(1)
    * */
    public static int trappingRainWater(int [] arr){
        int resultantWater = 0;
        if(arr == null || arr.length < 3){
            return resultantWater;
        }
        int l = arr.length;
        for(int i=1;i<l-1;i++){
            int leftMax = findMax(arr,0,i);
            int rightMax = findMax(arr,i,l-1);
            int waterLevel = Math.min(leftMax,rightMax);
            resultantWater += (waterLevel - arr[i])*width;
        }
        return resultantWater;
    }

    /*
    *
    * first calculate leftMax(0 to n) and rightMax(n to 0) of array
    *
    *
    * */
    public static int trappingRainWaterUsingSpace(int [] arr){
        int l = arr.length;
        int [] leftMaxArr = new int[l];
        leftMaxArr[0] = arr[0];
        for(int lIndex=1;lIndex<l;lIndex++){
            leftMaxArr[lIndex] = Math.max(leftMaxArr[lIndex-1],arr[lIndex]);
        }
       //right to left
        int [] rightMaxArr = new int[l];
        rightMaxArr[l-1] = arr[l-1];
        for (int rIndex=l-2;rIndex>=0;rIndex--){
            rightMaxArr[rIndex] = Math.max(rightMaxArr[rIndex+1],arr[rIndex]);
        }
        int resultantWater = 0;
        int waterLevel;
        for(int i=1;i<l-1;i++){
            waterLevel = Math.min(leftMaxArr[i],rightMaxArr[i]);
            resultantWater += (waterLevel - arr[i])*width;
        }
        return resultantWater;
    }

    /*
    *At every index , The amount of rain water stored is the difference between
    * current index height and minimum of left max height and right max height
    *
    * left right two bars
    * if left bars<= right Bar  then increment left
    *   water += max(0,waterLevel) //waterLevel= leftBar-arr[i]
    *   leftBar = max(leftBar,arr[i])
    *
    * else move right bars
    *    water += max(0,waterLevel) //waterLevel= rightBar-arr[i]
     *   rightBar = max(rightBar,arr[i])
    *
    * */
    public static int trappingRainWaterSpaceOptimize(int [] arr){
        int resultantWater = 0;
        int lMax = 0;
        int rMax = 0;
        int l = 0;
        int r = arr.length-1;
        while (l<=r){
            //left -->right
            if(lMax <= rMax){
                resultantWater += Math.max(0,lMax-arr[l]);//level-arr[i]
                lMax = Math.max(lMax,arr[l]);
                l++;
            }else {
                resultantWater += Math.max(0,rMax-arr[r]);
                rMax = Math.max(rMax,arr[r]);
                r--;
            }
        }
        return resultantWater;
    }

    private static int findMax(int[] arr, int l, int r) {
        int max = arr[l];
        for(int i=l+1;i<=r;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}