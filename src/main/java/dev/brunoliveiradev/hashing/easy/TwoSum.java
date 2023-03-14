package dev.brunoliveiradev.hashing.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the int target sum: ");
        int targetSum = input.nextInt();

        int numElements;

        System.out.print("Enter the number of elements in the array (min 2):  ");
        numElements = input.nextInt();
        while (numElements < 2) {
            System.out.print("Enter the number of elements in the array (min 2):  ");
            numElements = input.nextInt();

        }

        int[] array = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = input.nextInt();
        }

        int[] result = twoSum(array, targetSum);

        if (result.length == 0) {
            System.out.println("No two numbers in the array sum up to the target sum.");
        } else {
            System.out.println("The two numbers that sum up to the target sum are at indices: " + result[0] + " and " + result[1]);
        }
    }

    /**
     * Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     *
     * @param nums   int[]
     * @param target int
     * @return int[] - indices position
     * @apiNote Time Complexity: O(n) | Space Complexity: O(n) -
     * We traverse the list containing n elements only once.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int index = 0; index < nums.length; index++) {
            int currentElement = nums[index];
            int value = target - currentElement;

            if (map.containsKey(value)) {
                return new int[]{map.get(value), index};
            }
            // if didn't find it, keep it to look up later
            map.put(currentElement, index);
        }

        return new int[0];
    }
}
