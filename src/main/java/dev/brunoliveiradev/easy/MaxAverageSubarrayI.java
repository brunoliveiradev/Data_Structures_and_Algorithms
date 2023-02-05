package dev.brunoliveiradev.easy;

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
     * has the maximum average value and return this value
     *
     * @param nums int[]
     * @param k    int
     * @return Maximum average value
     * @apiNote Time complexity: O(n) | Space complexity: O(1)
     */
    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        double answer = sum;
        double maxAvegare = 0.0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        answer = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            answer = Math.max(answer, sum);
        }
        maxAvegare = answer / k;

        return maxAvegare;
    }
}
