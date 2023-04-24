package dev.brunoliveiradev.hashing.easy;

import java.util.HashSet;
import java.util.Set;

public class CountingElements {

    /**
     * Given an integer array arr, count how many elements x there are,
     * such that x + 1 is also in arr.
     * If there are duplicates in arr, count them separately.
     *
     * @param arr int[] - array of integers to be counted, where:
     *            <p>
     *            1 <= arr.length <= 1000 and 0 <= arr[i] <= 1000
     * @return int - the number of elements x such that x + 1 is also in arr
     * @apiNote Time Complexity: O(n) | Space Complexity: O(n) - where n is the length of the input array
     * @implNote Solved using HashSet, looking up items in a HashSet has a cost of O(1)
     */
    private static int countElements(int[] arr) {
        Set<Integer> integerHashSet = new HashSet<>();
        int numberCount = 0;

        for (int number : arr) {
            integerHashSet.add(number);
        }

        for (int x : arr) {
            if (integerHashSet.contains(x + 1)) {
                numberCount++;
            }
        }

        return numberCount;
    }

    public static void main(String[] args) {
        // create a function that call the method countElements and print the result
        int[] example1 = {1, 2, 3};
        int[] example2 = {1, 1, 3, 3, 5, 5, 7, 7, 8};
        int[] example3 = {1, 1, 2, 3, 3, 4, 7, 7, 8};

        System.out.println("Expected: 2, got: " + countElements(example1));
        System.out.println("Expected: 0, got: " + countElements(example2));
        System.out.println("Expected: 7, got: " + countElements(example3));
    }
}
