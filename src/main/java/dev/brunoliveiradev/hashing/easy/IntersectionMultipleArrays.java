package dev.brunoliveiradev.hashing.easy;

import java.util.*;

public class IntersectionMultipleArrays {

    /**
     * Given a 2D integer array nums where nums[i] is a non-empty array of distinct positive integers,
     * return the list of integers that are present in each array of nums sorted in asceding order.
     *
     * @param nums int[][] - nums[i] is a non-empty array of distinct positive integers
     * @return List of Integers - the list of integers that are present in each array of nums sorted in asceding order
     * @apiNote Time Complexity: O(n) | Space Complexity: O(n) - where n is the length of the input array
     * @implNote Solved using Hashing
     */
    public static List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> counts = countOccurrences(nums);

        TreeSet<Integer> commonIntegers = findCommonIntegers(counts, nums.length);

        return new ArrayList<>(commonIntegers);
    }

    /**
     * Count the occurrences of each integer value across all arrays
     *
     * @param nums int[][] - nums[i] is a non-empty array of distinct positive integers
     * @return the frequency that each number appears in the array
     */
    private static Map<Integer, Integer> countOccurrences(int[][] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        // for each iteration, if the key does not exist, it assigns the value of the key to 0 + 1
        // if the key exists, it assigns the value of the key to the current value + 1
        for (int[] arr : nums) {
            for (int current : arr) {
                counts.put(current, counts.getOrDefault(current, 0) + 1);
            }
        }
        return counts;
    }

    /**
     * Find the common integers present in each array and store them in a sorted set
     *
     * @param counts     - the frequency that each number appears in the array
     * @param arrayCount - the number of arrays
     * @return a sorted set of integers that are present in each array
     * @implNote Solved using a TreeSet to keep the numbers sorted.
     */
    private static TreeSet<Integer> findCommonIntegers(Map<Integer, Integer> counts, int arrayCount) {
        TreeSet<Integer> commonIntegers = new TreeSet<>();
        // if the number of times a number appears in the array is equal to the length of the array
        // it means that the number is present in each array, so, we add it to the answer
        for (int key : counts.keySet()) {
            if (counts.get(key) == arrayCount) {
                commonIntegers.add(key);
            }
        }
        return commonIntegers;
    }

    public static void main(String[] args) {
        // create a function that call the method intersection and print the result
        int[][] example1 = {{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}};
        System.out.println("Expected: [3,4]. Got : " + intersection(example1));

        int[][] example2 = {{1, 2, 3}, {3, 4, 5}, {3, 9, 10}};
        System.out.println("Expected: [3]. Got : " + intersection(example2));

        int[][] example3 = {{1, 2, 3}, {4, 5, 6,}};
        System.out.println("Expected: []. Got : " + intersection(example3));

        int[][] example4 = {{1, 2, 3}, {1, 2, 4}, {1, 2, 5}};
        System.out.println("Expected: [1,2]. Got : " + intersection(example4));

    }
}
