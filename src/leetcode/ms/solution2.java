package leetcode.ms;

import java.util.*;

public class solution2 {
    public static int[] solution(String[] S) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int M = S[0].length();

        // Iterate through each position in the strings
        for (int pos = 0; pos < M; pos++) {
            // Clear the map for each position
            map.clear();

            // Iterate through each string in the array
            for (int i = 0; i < S.length; i++) {
                char ch = S[i].charAt(pos);

                // If the current character is already in the map
                if (map.containsKey(ch)) {
                    // Get the list of positions where this character occurred before
                    List<Integer> positions = map.get(ch);

                    // Return the pair of strings and the position
                    return new int[]{positions.get(0), i, pos};
                } else {
                    // Otherwise, add the character and its position to the map
                    List<Integer> positions = new ArrayList<>();
                    positions.add(i);
                    map.put(ch, positions);
                }
            }
        }

        // If no pair found, return an empty array
        return new int[]{};
    }

    public static void main(String[] args) {
        String[] S1 = {"abc", "bca", "dbe"};
        String[] S2 = {"zzzz", "ferz", "zds", "fgtd"};
        String[] S3 = {"gr", "sd", "rg"};
        String[] S4 = {"bdafg", "ceagi"};

        System.out.println(Arrays.toString(solution(S1))); // Output: [0, 2, 1]
        System.out.println(Arrays.toString(solution(S2))); // Output: [0, 1, 3] or [1, 3, 0]
        System.out.println(Arrays.toString(solution(S3))); // Output: []
        System.out.println(Arrays.toString(solution(S4))); // Output: [0, 1, 2]
    }

}