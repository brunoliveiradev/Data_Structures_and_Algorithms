package dev.brunoliveiradev.techniques;

/**
 * Is a technique that can be used with  integer arrays.
 * The idea is to create an array 'PREFIX' where 'prefix[i]' is the sum of all elements
 * up to index 'i' (inclusive).
 * @apiNote Usually, it only costs O(n) to build but allows all future subarray queries to be O(1).
 */
public class PrefixSum {

    /**
     * If we want the sum of the subarray from 'i' to 'j' (inclusive), then the answer
     * is prefix[j] - prefix[i - 1], or prefix[j] - prefix[i] + nums[i] (out of bounds case when i = 0).
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


}
