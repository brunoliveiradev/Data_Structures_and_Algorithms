package dev.brunoliveiradev.techniques.arraysAndStrings;

import dev.brunoliveiradev.arraysAndStrings.prefixSum.easy.RunningSum;

/**
 * Is a technique that can be used with  integer arrays.
 * The idea is to create an array 'PREFIX' where 'prefix[i]' is the sum of all elements
 * up to index 'i' (inclusive).
 *
 * @apiNote Usually, it only costs O(n) to build but allows all future subarray queries to be O(1).
 * @see RunningSum
 */
public class PrefixSum {

    /**
     * If we want the sum of the subarray from 'i' to 'j' (inclusive), then the answer
     * is prefix[j] - prefix[i - 1], or prefix[j] - prefix[i] + nums[i] (out of bounds case when i = 0).
     *
     * @param nums int[] array nums
     */
    public static void pseudoCode(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0]; // we start with just the first element

        // Iterate with 'i' starting from index 1.
        // At any given point, the last element of 'prefix' will represent the sum of all elements
        // but not including index i.
        for (int i = 1; i < nums.length - 1; i++) {
            prefix[i] = nums[i] + prefix[prefix.length - 1];
        }
    }

    /**
     * Given an integer array nums, an array queries where queries[i] = [x,y] and
     * an integer limit, return a boolean array that represents the answer to each query.
     * A query is true if the sum of the subarray from x to y is less than limite, or false otherwise.
     *
     * @param nums    int[] array
     * @param queries int[][] array - where queries[i] = [x, y]
     * @param limit   int argument
     * @return boolean[] array, return true if the sum of the subarray from x to y is less than limite,
     * or false otherwise.
     * @apiNote Time complexity: O(1), Space Complexity: O(n) to build the prefix sum.
     */
    public boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
        boolean[] answer = new boolean[queries.length];
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];

            int current = prefix[y] - prefix[x] + nums[x];

            answer[i] = current < limit;
        }

        return answer;
    }

    /**
     * Given an integer array, find the number of ways to split the array into two parts
     * so that the first section has a sum greater than or equal to the sum of the second section.
     * The second section should have at least one number.
     *
     * @param num int[] array
     * @return int - number ways to split into two parts
     */
    public int waysToSplitArray(int[] num) {
        // create a new array to hold the first value
        long[] prefix = new long[num.length];
        prefix[0] = num[0];

        // iterate through the rest of the array
        for (int i = 1; i < num.length; i++) {
            prefix[i] = num[i] + prefix[i - 1];
        }

        // iterate through the all the possible splits
        int answer = 0;
        for (int i = 0; i < num.length; i++) {
            long leftSection = prefix[i];
            long rightSection = prefix[num.length - 1] - prefix[i]; // sum all the elements - prefix

            // constraint condition
            if (leftSection >= rightSection) {
                answer++;
            }
        }
        return answer;
    }

    // Space complexity improved to O(1) while still leveraging the idea of a prefix sum by
    // simply calculating leftSection on the fly.
    public int waysToSplitArraySpaceImproved(int[] nums) {
        // create a new array to hold the first value
        int answer = 0;
        long leftSection = 0;
        long total = 0;

        // iterate through the rest of the array
        for (int num : nums) {
            total += num;
        }

        // iterate through the all the possible splits
        for (int i = 0; i < nums.length - 1; i++) {
            leftSection += nums[i]; //calculate the left section on the fly
            long rightSection = total - leftSection;
            // constraint condition
            if (leftSection >= rightSection) {
                answer++;
            }
        }
        return answer;
    }
}
