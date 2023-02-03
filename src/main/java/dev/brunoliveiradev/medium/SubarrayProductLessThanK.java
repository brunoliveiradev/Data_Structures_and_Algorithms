package dev.brunoliveiradev.medium;

import java.util.Scanner;

public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter the value for element %d: ", i+1);
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter an integer value for k: ");
        int k = sc.nextInt();

        int result = numSubarrayProductLessThanK(nums, k);
        System.out.println("Result: " + result);
    }

    /**
     * Given an array of positive integers nums and an integer k,
     * return the number of contiguous subarrays where the product of all the elements in
     * the subarray is strictly less than k.
     *
     * @param nums int[] argument
     * @param k    int argument
     * @return int - length of subarray that is stricly less than k
     * @apiNote Used the SlidingWindow Technique - Time Complexity: O(n) | Space Complexity: O(1) - where n is the length os nums
     */
    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int product = 1; //will be used in a multiplication, cant be 0.
        int left = 0;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            // While the constraint is broken, remove the elements from the current window doing the opposite of a product
            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }
            //add the length of the window (right - left + 1) to the answer
            answer += right - left + 1;
        }

        return answer;
    }
}
