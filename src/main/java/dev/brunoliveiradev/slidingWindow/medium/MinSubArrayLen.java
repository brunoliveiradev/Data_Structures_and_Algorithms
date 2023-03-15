package dev.brunoliveiradev.slidingWindow.medium;

import java.util.Scanner;

public class MinSubArrayLen {

    /**
     * Given an array of positive integers nums and a positive integer target,
     * return the minimal length of a subarray whose sum is greater than or equal to target.
     * If there is no such subarray, return 0 instead.
     * @param target int argument
     * @param nums int array of positive numbers
     * @return minimal length
     * @apiNote Time compelxity: O(n) | Space complexity: O(1)
     * @implNote Solved using Sliding Window approach - similiar to Two Pointers.
     */
    public static int minSubArrayLen(int target, int[] nums) {
        // Let's use an integer 'window' that tracks the sum of the current window.
        int left = 0;
        int window = 0;
        int minLength = Integer.MAX_VALUE;

        // At each number, will add the number to the current window's sum
        for (int right = 0; right < nums.length; right++) {
            window += nums[right];

            // While the window exceeds the target, descrease the window by removing the elements from the left
            while(window >= target) {
                // Given a subarray starting at left and ending at right, the length is: right - left + 1
                int length = right - left + 1;
                minLength = Math.min(minLength, length);

                window -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter a positive value for element %d: ", i+1);
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter a positive integer value for target: ");
        int target = sc.nextInt();

        int minLength = minSubArrayLen(target, nums);
        System.out.printf("The minimum length of a subarray whose sum is greater than or equal to %d is %d.", target, minLength);
    }
}
