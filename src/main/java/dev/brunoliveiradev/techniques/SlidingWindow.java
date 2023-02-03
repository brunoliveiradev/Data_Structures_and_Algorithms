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
     *
     * @param array int[]
     * @apiNote 1. Define a pointer for the left and right bound that represents the current window,
     * usuallu both of them starting at 0.
     * 2. Iterate over the array with the right bound to "add" elements to the window.
     * 3. Whenever the constraint is broken, in this example if the sum of the window exceeds 'k',
     * then "remove" elements from the window by increment the left bound until the condition is satisfied again.
     * @implNote A sliding window guarantees a maximum of O(2n) window iterations
     * - the right pointer can move n times and the left pointer can move
     * n times. This means if the logic done for each window is
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
            while (left < right) { // && AND condition from problem not met
                //Do some logic to "remove" element at arr[left] from window
                left++;
            }
        }
    }

    static class findingTheLengthOfSubarray {
        /**
         * First example: Given an array of positive integers nums and an integer k,
         * find the length of the longest subarray whose sum is less than or equal to k.
         *
         * @param nums int[] - an argument
         * @param k    int - another argument
         * @return subarray whose sum is less than or equal to k.
         * @apiNote Time Complexity: O(n) | Space Complexity: O(1) - where n is the length of nums
         */
        public static int findLength(int[] nums, int k) {
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

        /**
         * Given a binary substring s, flip a "0"into "1" and return the length of
         * the longest substring containing only "1" after performing at MOST ONE operation.
         *
         * @param s an argument of a binary substring (string containing only "0" and "1")
         * @return length of the longest
         * @apiNote Because the string can only contain "1" and "0", another way to look at this problem is
         * "what is the longest substring that contains at most one "0"?"
         * @bigO this problem runs in O(n) time, where n is the length of s. Space complexity: O(1).
         */
        public static int findAnotherLenght(String s) {
            int current = 0;
            int left = 0;
            int answer = 0;

            for (int right = 0; right < s.length(); right++) {
                if (s.charAt(right) == '0') {
                    current++;
                }
                // While the constraint is broken, remove the elements from the current and increment left
                while (current > 1) {
                    if (s.charAt(left) == '0') {
                        current--;
                    }
                    left++;
                }
                //lenght of the substring = right - left + 1;
                answer = Math.max(answer, right - left + 1);
            }

            return answer;
        }
    }

    /**
     * If a problem asks for the number of subarrays that fit some constraint,
     * we can still use sliding window,
     * but we need to use a neat math trick to calculate the number of subarrays.
     *
     * @apiNote Whenever you see a problem asking for the number of subarray, think of this:
     * at each index, how many valid subarrays *end* at this index?
     */
    static class findingTheNumberOfSubarray {

        /**
         * Given an array of positive integers nums and an integer k,
         * return the number of contiguous subarrays where the product of all the elements in
         * the subarray is strictly less than k.
         *
         * @param nums int[] argument
         * @param k    int argument
         * @return int - length of subarray that is stricly less than k
         * @apiNote Time Complexity: O(n) | Space Complexity: O(1) - where n is the length os nums
         */
        public static int findNumberSubarray(int[] nums, int k) {
            //Do a normal sliding window with the constraint of the product being less than k, and at each index, add the length of the window (right - left + 1) to the answer.
            if (k <= 1) return 0;

            int current = 1; // because current will be used in a multiplication, cant be 0.
            int left = 0;
            int answer = 0;

            for (int right = 0; right < nums.length; right++) {
                current *= nums[right];
                // While the constraint is broken, remove the elements from the current window
                while (current >= k) {
                    current /= nums[left];
                    left++;
                }

                answer += right - left + 1;
            }

            return answer;
        }

    }

}
