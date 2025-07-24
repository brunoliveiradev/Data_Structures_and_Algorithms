package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

public class LonelyInteger {


    public static int lonelyInteger(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }

        if (inputArray.length == 1) {
            return inputArray[0]; // If there's only one element, it is the lonely integer
        }

        // Using XOR operation to find the lonely integer
        // The XOR operation has the property that a ^ a = 0 and a ^ 0 = a.
        // Therefore, if we XOR all numbers in the array, the pairs will cancel each other out,
        // and the lonely integer will remain as the result.
        // This approach is efficient with O(n) time complexity and O(1) space complexity.
        //
        // XOR is a powerful operation for a pair of numbers where each number appears twice except for one number.
        int result = 0;
        for (int number : inputArray) {
            result ^= number; // XOR operation
        }

        return result; // The lonely integer will be the only one left after all XOR operations
    }
}
