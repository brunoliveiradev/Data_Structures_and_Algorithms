package dev.brunoliveiradev.hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {

    /**
     * Given an array of positive integers nums and an integer k.
     * A subarray is called nice if there are k odd numbers on it.
     * <p>
     *
     * @param nums array of integers
     * @param k    number of odd numbers
     * @return the number of nice sub-arrays
     * @implSpec 1 <= nums.length <= 50000, 1 <= nums[i] <= 10^5, 1 <= k <= nums.length
     * @apiNote Time complexity O(n) | Space complexity O(n) - where n is the length of the input array.
     * @implNote We use a hash map to store the current count of odd numbers and its frequency.
     */
    private static int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1); // this is the base case, the empty subarray (sum = 0)

        int curr = 0; // keeps track of the total count of odd
        int answer = 0;

        for (int num : nums) {
            curr += num % 2;

            answer += counts.getOrDefault(curr - k, 0);

            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] num1 = {1, 1, 2, 1, 1};
        int k1 = 3;

        int[] num2 = {2, 4, 6};
        int k2 = 1;

        int[] num3 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k3 = 2;

        System.out.println("The number of nice sub-arrays expected is 2 and got it: " + numberOfSubarrays(num1, k1));
        System.out.println("The number of nice sub-arrays expected is 0 and got it: " + numberOfSubarrays(num2, k2));
        System.out.println("The number of nice sub-arrays expected is 16 and got it: " + numberOfSubarrays(num3, k3));
    }
}
