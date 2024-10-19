package dev.brunoliveiradev.arraysAndStrings.prefixSum.easy;

import java.io.IOException;
import java.util.Scanner;

public class RunningSum {

    /**
     * Given an array nums, this method calculates the running sum of the array.
     * The running sum is defined as runningSum[i] = sum(nums[0]…nums[i]).
     *
     * @param nums an array of integers
     * @return an array of integers representing the running sum
     * @implNote Time Complexity: O(N) - where N is the length of the input array
     * @implNote Space Complexity: O(1) - in-place modification of the input array
     */
    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the array: ");
        int length = scanner.nextInt();

        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Enter element " + (i + 1) + ": ");
            nums[i] = scanner.nextInt();

        }
        int[] result = runningSum(nums);

        System.out.println("The running sum of the array is: ");
        for (int j : result) {
            System.out.print(j + " ");
        }
    }
}
