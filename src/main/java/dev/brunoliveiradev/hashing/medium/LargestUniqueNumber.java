package dev.brunoliveiradev.hashing.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LargestUniqueNumber {

    public static void main(String[] args) {
        int[] nums = {5, 7, 3, 9, 4, 9, 8, 3, 1};
        int[] anotherExample = {9, 9, 8, 8};

        System.out.println("The largest unique number in the array is: " + largestUniqueNumber(nums) + ". Expected: 8.");
        System.out.println("The largest unique number in the array is: " + largestUniqueNumber(anotherExample) + ". Expected: -1.");
    }

    /**
     * Given an array of integers A, return the largest integer that only occurs once.
     * If no integer occurs once, return -1.
     *
     * @param nums array of integers
     * @return the largest integer that only occurs once
     * @apiNote Time complexity: O(n) | Space complexity: O(n) - where n is the length of the input array.
     * @implNote We use a hash map to store the current number and its frequency.
     * Then, we iterate over the hash map and return the largest number that occurs once.
     * @implSpec In largestUniqueNumber(), you build the frequency map
     */
    public static int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        return maxUniqueNumber(frequency);
    }

    /**
     * Find the maximum unique number from this frequency map that only occurs once
     * @param frequency map
     * @return the largest integer that only occurs once
     */
    private static int maxUniqueNumber(Map<Integer, Integer> frequency) {
        AtomicInteger maxUniqueNum = new AtomicInteger(-1);

        frequency.forEach((key, value) -> {
            if (value == 1) {
                maxUniqueNum.set(Math.max(maxUniqueNum.get(), key));
            }
        });

        return maxUniqueNum.get();
    }
}
