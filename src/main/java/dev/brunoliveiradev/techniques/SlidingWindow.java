package dev.brunoliveiradev.techniques;

/**
 * Sliding window is another common approach to solving problems related to arrays.
 * Like two pointers, sliding windows work the same with arrays and strings - the important thing is
 * that they're iterables with ordered elements. (Window==subarray).
 * This will be focusing on arrays. However, you can swap every instance of
 * "array" with "string" and it will make sense, all the logical is identical for strings.
 *
 * @see TwoPointers
 */
public class SlidingWindow {

    /**
     * Imagine that a problem wanted the length of the longest subarray with
     * a sum less than or equal to k for an array with positive numbers.
     * In this case, the constraint is 'sum(window) <= k', and the longer the window,
     * the better it is.
     * @param array int[]
     * @apiNote 1. Define a pointer for the left and right bound that represents the current window,
     * usuallu both of them starting at 0.
     * 2. Iterate over the array with the right bound to "add" elements to the window.
     * 3. Whenever the constraint is broken, in this example if the sum of the window exceeds 'k',
     * then "remove" elements from the window by increment the left bound until the condition is satisfied again.
     * @implNote  A sliding window guarantees a maximum of O(2n) window iterations
     * - the right pointer can move n times and the left pointer can move
     *  n times. This means if the logic done for each window is
     * O(1), sliding window algorithms run in linear time.
     */
    private static void pseucode(int[] array) {
        //1. Define a pointer for the left and right bound that represents the current window,
        // usuallu both of them starting at 0.
        int left = 0;

        // 2. Iterate over the array with the right bound to "add" elements to the window.
        for (int right = 0; right < array.length - 1; right++) {
            // Do some logic to "add" element at array[right] to window

            // 3. Whenever the constraint is broken, in this example if the sum of the window exceeds 'k',
            // then "remove" elements from the window by increment the left bound until the condition is satisfied again.
            while(left < right) { // && AND condition from problem not met
                //Do some logic to "remove" element at arr[left] from window
                left++;
            }
        }
    }

    /**
     * First example: Given an array of positive integers nums and an integer k,
     * find the length of the longest subarray whose sum is less than or equal to k.
     * @param nums int[]
     * @param k int
     * @apiNote Time Complexity:  | Space Complexity:
     * @return subarray whose sum is less than or equal to k.
     */
    private static int findLength(int[] nums, int k) {
        // Let's use an integer current that tracks the sum of the current window. current <= k.
        int current = 0;
        int left = 0;
        int answer = 0;

        // At each number, will add the number to the current window's sum
        for (int right = 0; right < nums.length; right++) {
            current += nums[right];

            // While the constraint is broken, remove the elements from the left and increment
            while (current > k) {
                current -= nums[left];
                left++;
            }
            // Updates the answer with the maximum length found.
            // Given a subarray starting at left and ending at right, the length is right - left + 1
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }


}
