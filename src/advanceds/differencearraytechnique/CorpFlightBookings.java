package advanceds.differencearraytechnique;

import java.util.Arrays;


//https://leetcode.com/problems/corporate-flight-bookings/
public class CorpFlightBookings {

    public static void main(String[] args) {
        int[][][] allBookings = {
                {
                        {3, 3, 5},
                        {1, 3, 20},
                        {1, 2, 15}
                },
                {
                        {1, 2, 10},
                        {2, 3, 20},
                        {2, 5, 25}
                },
                {
                        {1, 2, 10},
                        {2, 2, 15}
                }
        };

        int[] n = {3, 5, 2};

        /*output

                 Test Case 1
                [35, 35, 25]
                --------------------
                Test Case 2
                [10, 55, 45, 25, 25]
                --------------------
                Test Case 3
                [10, 25]
                -------------------
        * */
        for (int i = 0; i < allBookings.length; i++) {
            System.out.println("Test Case " + (i + 1));

            int[] result = corpFlightBookings(allBookings[i], n[i]);

            System.out.println(Arrays.toString(result));
            System.out.println("--------------------");
        }
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
  // start index is 1 , we need to map it to 0 based index
        int [] result = new int[n];
        int s, e, val;
        for(int [] booking : bookings){
            s = booking[0];
            e = booking[1];
            val = booking[2];

            result[s-1] += val;
            if(e  < n){
                result[e] -= val;
            }
        }
        for(int i=0;i<n-1;i++){
            result[i+1] += result[i];
        }
        return result;
    }
}
