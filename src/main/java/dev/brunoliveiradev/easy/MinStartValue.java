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
        int minValue = 0;
        int total = 0;

        for (int num : nums) {
            total += num;
            minValue = Math.min(minValue, total);
        }

        return 1 - minValue;
    }

}
