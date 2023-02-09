package dev.brunoliveiradev.medium;

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
     * Given a binary array nums and an integer k, return the maximum number of consecutive 1's
     * in the array if you can flip at most k 0's.
     *
     * @param nums int[] binary array
     * @param k    int maximum number of consecutive 1's.
     * @return maximum number of consecutive 1's.
     * @apiNote Time Complexity: O(n) | Space Complexity: O(1) -
     * where n is the number of elements in the array
     */
    public static int longestOnes(int[] nums, int k) {
        int currentZeros = 0;
        int left = 0;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                currentZeros++;
            }

            // check if the constraints is broken, then remove elements and increment left
            while ((left <= right) && currentZeros > k) {
                if (nums[left] == 0) {
                    currentZeros--;
                }
                left++;
            }

            // keep track of the maximum number of consecutive elements. right - left + 1 = size of the window/subarray
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}
