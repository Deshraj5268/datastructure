package arrays.binarysearch.bsidentification;

public class PackageShipping {

    public static void main(String[] args) {
        PackageShipping packageShipping = new PackageShipping();
        int [][] weightArr = {{1,2,3,4,5,6,7,8,9,10},
                {3,2,2,4,1,4},
                {1,2,3,1,1}
        };
        int [] days = {5, 3, 4};
        for (int i = 0; i < weightArr.length; i++) {
            System.out.println(packageShipping.shipWithinDays(weightArr[i], days[i]));
        }
    }

    public int shipWithinDays(int[] weights, int days) {
        int capacity = 0;
        int sum = weights[0];
        int max = weights[0];
        for (int i = 1; i < weights.length; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }

        int l = max, h = sum;
        int m;
        int result= l;
        boolean isWeightFeasible;
        while (l <= h){
            m = l + (h-l)/2;
            int minDays = feasible(weights, m);
             if(minDays <= days) {
                 result = m;
                l = m+1;
            }else {
                h = m-1;
            }
        }
        return result;
    }

    private int feasible(int[] weights, int capacity) {
        int totalWeight = 0;
        int minDays = 0;
        for(int weight : weights){
            totalWeight += weight;
            if(totalWeight >= capacity){
                minDays++;
                totalWeight = weight;
            }
        }
        return minDays;
    }
}
