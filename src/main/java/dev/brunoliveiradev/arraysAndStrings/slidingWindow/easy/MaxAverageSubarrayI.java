package dev.brunoliveiradev.arraysAndStrings.slidingWindow.easy;

import java.util.Scanner;

public class MaxAverageSubarrayI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array : ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter the value for element %d : ", i + 1);
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter an integer value for k: ");
        int k = sc.nextInt();

        System.out.println("Max Average: " + findMaxAverage(nums, k));
    }

    /**
     * Find a contiguous subarray whose length is equal to k that
     * has the maximum average value and return this value.
     *
     * @param nums the array of integers
     * @param k    the length of the subarray
     * @return the maximum average value of the subarray
     * @apiNote Time complexity: O(n) | Space complexity: O(1)
     */
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        // If the array length is smaller than k, no subarray of length k can exist.
        // Return 0 as there is no valid subarray.
        if (n < k) {
            return 0;
        }

        // Initialize the sum of the first window of size k.
        // This window represents the first subarray of length k.
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i]; // Accumulate the sum of the first k elements.
        }

        // Initialize maxSum to keep track of the maximum sum found.
        double maxSum = sum;

        // Slide the window across the array, starting from index k.
        for (int i = k; i < n; i++) {
            // Adjust the sum by adding the new element at the current index (i)
            // and removing the element that is no longer in the window (i - k).
            sum = sum + nums[i] - nums[i - k];

            // Update maxSum if the current window's sum is greater than the previous maxSum.
            maxSum = Math.max(maxSum, sum);
        }

        // Return the maximum average value by dividing maxSum by k.
        return (maxSum / k);
    }
}
