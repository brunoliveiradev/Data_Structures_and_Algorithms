package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import java.util.List;

public class CountGreaterThanPreviousAverage {

    /**
     * Given an array of positive integers (responseTimes), return the number of elements that are
     * strictly greater than the average of all previous elements. The first element is skipped.
     * <p>
     * Example:
     * Input: [100, 200, 150, 300]
     * - Day 0: 100 (no previous days, skip)
     * - Day 1: 200 > average(100) = 100 → count = 1
     * - Day 2: 150 vs average(100, 200) = 150 → not greater (150 is equal, not greater) → count = 1
     * - Day 3: 300 > average(100, 200, 150) = 150 → count = 2
     * Output: 2
     * <p>
     * Constraints:
     * <p>
     * 0 <= responseTimes.length <= 1000
     * <p>
     * 1 <= responseTimes[i] <= 10^9
     * @param responseTimes A list of integers representing response times. It must contain at least one element.
     * @return The count of response times that are greater than the average of all previous times in the list.
     * @apiNote Time Complexity: O(n) where n is the size of responseTimes
     *          Space Complexity: O(1) - constant amount of extra space
     */
    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
        // Base case: if it has 0 or 1 element, no previous elements to compare, early return
        if (responseTimes.size() <= 1) return 0;

        int count = 0;
        long sum = responseTimes.getFirst();

        // Start from index 1 (skip first element as it has no previous elements)
        for (int i = 1; i < responseTimes.size(); i++) {
            // avg of all previous elements [0, i-1], int division is used (truncates decimal part)
            long avg = sum / i;

            // Check if current element is STRICTLY greater than average
            if (responseTimes.get(i) > avg) {
                count++;
            }

            // Add current element to running sum for next iteration
            sum += responseTimes.get(i);
        }

        return count;
    }

}
