package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoutingSortUsingList {

    /**
     * Problem Statement:
     * <p>
     * Given a list of integers, count the number of times each value appears
     * and return a frequency array of size 100. Each element `i` in the result
     * should represent how many times the integer `i` appears in the input list.
     * <p>
     * Constraints (from problem statement):
     * <p>
     * - All integers are in the range [0, 99]
     * - The input list size can be up to 10^6
     * <p>
     * This is part of a counting sort algorithm.
     * <p>
     * While traditional sorting algorithms have a time complexity of O(n log n),
     * this counting approach exploits the fact that the domain (0–99) is fixed
     * and small. So we can count occurrences directly using array indexing.
     * <p>
     * Approach:
     * <p>
     * 1. Initialize a frequency list of size 100 filled with zeros.
     *    - We use `Collections.nCopies(100, 0)` to create a fixed-size list of 100 zeros.
     *    - Then wrap it in a mutable `ArrayList` so we can update counts.
     * <p>
     * 2. For each integer `i` in the input list:
     *    - Increment the value at index `i` in the frequency list.
     *    - This represents how many times value `i` has occurred so far.
     * <p>
     * 3. Return the frequency list.
     *    - The result will contain 100 integers where each index maps to a value
     *      in the original domain, and the value at that index is the count.
     * <p>
     * Time Complexity: O(n)
     * <p>
     * - We iterate through the input list exactly once.
     * - All operations inside the loop are O(1).
     * <p>
     * Space Complexity: O(1)
     * <p>
     * - We use constant additional space (a list of fixed size 100).
     * - The output size does not grow with the input size `n`.
     */
    public static List<Integer> countingSort(List<Integer> arr) {
        // Initialize a frequency list of size 100, all set to 0
        List<Integer> freq = new ArrayList<>(Collections.nCopies(100, 0));

        // Count occurrences of each number
        for (Integer i : arr) {
            freq.set(i, freq.get(i) + 1);
        }

        // Return the final frequency list
        return freq;
    }
}
