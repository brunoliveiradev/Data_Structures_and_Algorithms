package dev.brunoliveiradev.hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;

        int[] anotherExample = {1, -1, 1, -1};
        int anotherK = 0;

        System.out.println("The number of subarrays that sum to " + k + " is: " + subarraySum(nums, k));
        System.out.println("The number of subarrays that sum to " + anotherK + " is: " + subarraySum(anotherExample, anotherK));
    }

    /**
     * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
     *
     * @param nums array of integers non-empty
     * @param k    integer
     * @return the total number of continuous subarrays whose sum equals to k
     */
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1); // this is the base case, the empty subarray (sum = 0)

        int currSum = 0;
        int answer = 0;

        for (int number : nums) {
            currSum += number;

            // check if the current sum minus the constraint is in the hash map (is equal to the constraint)
            answer += counts.getOrDefault(currSum - k, 0);

            // check the hash map for curr minus the constraint. Add this frequency to the answer
            counts.put(currSum, counts.getOrDefault(currSum, 0) + 1);
        }

        return answer;
    }

}
