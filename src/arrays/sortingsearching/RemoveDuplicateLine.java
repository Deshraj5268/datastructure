package arrays.sortingsearching;

import java.util.*;

public class RemoveDuplicateLine {

    public static void main(String[] args) {
        // Example input lines
        List<String> inputLines = Arrays.asList(
                "1 23 1 34",
                "23 1 1 34",
                "1 2 3",
                "4 5 6 7 8 9",
                "11 23 34"
        );

        // Set to track unique line signatures
        Set<String> uniqueSignatures = new HashSet<>();
        List<String> outputLines = new ArrayList<>();

        for (String line : inputLines) {
            String[] parts = line.trim().split(" ");
            int[] numbers = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }

            Arrays.sort(numbers);  // Normalize the line content
            String signature = Arrays.toString(numbers);  // Unique signature per line ignoring order

            if (!uniqueSignatures.contains(signature)) {
                uniqueSignatures.add(signature);
                outputLines.add(line);
            }
        }

        // Print output
        System.out.println("Output after removing duplicate lines:");
        for (String line : outputLines) {
            System.out.println(line);
        }
    }
}
