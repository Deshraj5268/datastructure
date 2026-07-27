package stack.monotonicstack;


import java.util.Arrays;
import java.util.Stack;

/*
* https://leetcode.com/problems/number-of-visible-people-in-a-queue/description/
* */
public class NumberOfPeopleVisible {

    public static void main(String[] args) {
        NumberOfPeopleVisible s = new NumberOfPeopleVisible();

        int[] arr = {10, 6, 5, 8, 11, 9};
        System.out.println(Arrays.toString(s.canSeePersonsCount(arr)));
    }


    /*
    * Traverse from right to left.

        The stack maintains buildings that are still visible from the left.

        Whenever the current building is taller,

        while(current > stack.top())

        it pops shorter buildings.

        Each popped building is visible.

        After popping,

        if the stack is still not empty,
        then the first taller building is also visible.
    * */
    public int[] canSeePersonsCount(int[] heights) {

        int n = heights.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                ans[i]++;
                stack.pop();
            }

            if (!stack.isEmpty()) {
                ans[i]++;
            }

            stack.push(heights[i]);
        }

        return ans;
    }


    public static int[] visibleCountBruteForce(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            int maxBetween = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {

                if (Math.min(arr[i], arr[j]) > maxBetween) {
                    ans[i]++;
                }

                maxBetween = Math.max(maxBetween, arr[j]);
            }
        }

        return ans;
    }
}
