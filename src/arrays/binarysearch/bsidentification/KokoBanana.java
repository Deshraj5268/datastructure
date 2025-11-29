package arrays.binarysearch.bsidentification;


//https://leetcode.com/problems/koko-eating-bananas/description/
public class KokoBanana {

    public static void main(String[] args) {
        KokoBanana kokoBanana = new KokoBanana();
        int [][] mat = {{3,6,7,11},
                {30,11,23,4,20},
                {30,11,23,4,20},
                {312884470},
                {805306368,805306368,805306368}
        };
        int [] hArr = {8, 5, 6,312884469, 1000000000};
        for (int i = 0; i < mat.length; i++) {
            int k = kokoBanana.minEatingSpeed(mat[i],hArr[i]);
            System.out.println("min banana eating speed "+k);
        }
    }


    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int p : piles) {
            right = Math.max(right, p);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int k, int h) {
        int hours = 0;
        for (int p : piles) {
            hours += (p + k - 1) / k;   // ceil(p/k)
            if (hours > h) return false;
        }
        return hours <= h;
    }
}
