package dev.brunoliveiradev.arraysAndStrings.slidingWindow.medium;

import java.util.Scanner;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the array 'nums': ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter the value for element %d: ", i + 1);
            nums[i] = sc.nextInt();

        }
        System.out.println("Enter the value of 'k': ");
        int k = sc.nextInt();

        int result = longestOnes(nums, k);
        System.out.println("Result: " + result);
    }

    /**
     * Given a binary array `nums` and an integer `k`, this method returns the maximum number of consecutive 1's
     * in the array if you can flip at most `k` 0's.
     *
     * @param nums int[] binary array
     * @param k    int maximum number of 0's that can be flipped
     * @return int maximum number of consecutive 1's
     * @apiNote Time Complexity: O(n) | Space Complexity: O(1) - where n is the number of elements in the array
     */
    public static int longestOnes(int[] nums, int k) {
        int left = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                k--;
            }

            // If k becomes negative, it means we have more than the allowed number of 0s in the window.
            // Increment the left pointer to move the window forward until k is non-negative again.
            // (If we use a while k < 0 we will shrink the window instead of moving forward)
            if (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
            max = Math.max(max, (i - left + 1));
        }
        return max;
    }
}
