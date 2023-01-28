package dev.brunoliveiradev.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoNumberSum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the target sum: ");
        int targetSum = input.nextInt();

        System.out.print("Enter the number of elements in the array: ");
        int numElements = input.nextInt();

        int[] array = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = input.nextInt();
        }

        int[] result = twoNumberSum(array, targetSum);

        if (result.length == 0) {
            System.out.println("No two numbers in the array sum up to the target sum.");
        } else {
            System.out.println("The two numbers that sum up to the target sum are: " + result[0] + " and " + result[1]);
        }
    }

    /**
     * Essentially this algorithm is trying to find a corresponding number Y
     * such that X + Y = targetSum. If no two numbers sum up to the target sum,
     * the function should return an empty array.
     *
     * @param array     int
     * @param targetSum int
     * @return result as int[]
     */
    // Time Complexity: O(n) | Space Complexity: O(n) - where n is the length of the array
    public static int[] twoNumberSum(int[] array, int targetSum) {
        List<Integer> result = new ArrayList<>(array.length);

        for (int currentElement : array) {
            if (result.contains(targetSum - currentElement)) {
                return new int[]{targetSum - currentElement, currentElement};
            } else {
                result.add(currentElement);
            }
        }
        return new int[0];
    }
}