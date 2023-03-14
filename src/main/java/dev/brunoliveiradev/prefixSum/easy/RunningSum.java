package dev.brunoliveiradev.prefixSum.easy;

import java.io.IOException;
import java.util.Scanner;

public class RunningSum {

    /**
     * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i])
     *
     * @param nums - int nums
     * @return int - the running sum of num
     * @apiNote Time and Space Complexity: O(N) - where N is the length of the input array
     */
    private static int[] runningSum(int[] nums) {
        int[] results = new int[nums.length];
        results[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            results[i] = nums[i] + results[i - 1];
        }
        return results;
    }

    // Time complexity: O(n) | Space complexity O(1) - where n is the length of the input array.
    private static int[] runningSumOptimized(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // increase nums[i] by the previous index's running sum. Which is stored at index i - 1.
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
