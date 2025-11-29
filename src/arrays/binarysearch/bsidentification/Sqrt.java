package arrays.binarysearch.bsidentification;

//https://leetcode.com/problems/sqrtx/description/
public class Sqrt {

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        int [] arr = {1,3,5,9,21,45,8,2147395599};
        for (int i = 0; i < arr.length; i++) {
            System.out.println("sqrt of :"+arr[i] +" -> "+sqrt.mySqrt(arr[i]));
        }
    }

    public int mySqrt(int x) {
        if(x < 2){
            return x;
        }
        int l = 0, h = x/2;
        int result = 0;
        int m;
        long temp;
        while(l <= h){
            m = l+(h-l)/2;
            temp = (long)m*m;
            if(temp == x){
                return m;
            }else if(temp < x){
                result = m;
                l = m+1;
            }else {
                h = m-1;
            }
        }
        return result;

    }
}
