package dev.brunoliveiradev.easy;

import java.util.Scanner;

public class MinStartValue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ": ");
            nums[i] = scanner.nextInt();
        }

        int minStartValue = minStartValue(nums);
        System.out.println("The minimum start value is: " + minStartValue);
    }

    /**
     * Given an array of integers nums, calculate the step by step sum of startValue (initial positive value)
     * plus elements in nums (left to right).
     * Returns the minimum positive value of startValue such that the step by step sum is never less than 1.
     *
     * @param nums int array argument
     * @return minimum positive value of startValue >= 1.
     * @apiNote Space Complexity: O(1) | Time Complexity: O(n), where n is the length of the input array
     */
    public static int minStartValue(int[] nums) {
        int sum = 0; // Current cumulative sum of the array elements
        int minSum = 0; // Minimum cumulative sum encountered

        for (int num : nums) {
            sum += num;

            // Update minSum if the current cumulative sum is less than minSum
            minSum = Math.min(minSum, sum);
        }

        // Calculate the minimum start value to ensure the step-by-step sum is never less than 1
        // If minSum is negative, we need at least 1 - minSum to make the sum positive
        // If minSum is non-negative, we need at least 1
        return 1 - minSum;
    }

}
