package dev.brunoliveiradev.techniques;

/**
 * Sliding window is a common approach to solving problems related to arrays and strings.
 * The sliding window technique helps in tracking a subset (or window) of elements in a sequence
 * and dynamically adjusting its size by moving pointers (left and right).
 * This technique is useful for problems like finding the maximum sum of subarrays, counting valid subarrays,
 * or determining the longest sequence that satisfies a condition.
 * <p>
 * The key idea is:
 * 1. Expand the window by moving the right pointer and adding elements to the window.
 * 2. Shrink the window by moving the left pointer when the window breaks the problem's constraint.
 * 3. Maximize or optimize the result as per the problem's requirements.
 * <p>
 * Time Complexity: O(n) for most sliding window problems, as each element is processed once (added and removed from the window at most once).
 * Space Complexity: O(1), as only a few integer variables are used to maintain the window.
 */
public class SlidingWindow {

    /**
     * Given an array of positive integers nums and a positive integer k, return the length of the longest subarray whose sum is less than or equal to k.
     * <p>
     * Time Complexity: O(n) - Each element is added and removed from the window at most once.
     * Space Complexity: O(1) - Only a few integer variables are used.
     */
    public static int findMaxLength(int[] nums, int k) {
        int left = 0, currSum = 0, maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right]; // Add the current element to the window sum.

            // If the current sum exceeds k, shrink the window from the left.
            while (currSum > k) {
                currSum -= nums[left]; // Remove the left element from the window sum.
                left++;
            }

            // Update the maximum window size.
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Given a binary string s, return the length of the longest substring that contains at most one '0' that can be flipped to '1'.
     * <p>
     * Time Complexity: O(n) - Each character is added and removed from the window at most once.
     * Space Complexity: O(1) - Only a few integer variables are used.
     */
    public static int findLength(String s) {
        int left = 0, zeroCount = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                zeroCount++; // Count the number of '0's in the current window.
            }

            // If there are more than one '0' in the window, shrink the window from the left.
            while (zeroCount > 1) {
                if (s.charAt(left) == '0') {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum window size.
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Given an array of positive integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
     * <p>
     * Time Complexity: O(n) - Each element is multiplied into and divided out of the window product at most once.
     * Space Complexity: O(1) - Only a few integer variables are used.
     */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int count = 0, left = 0;
        long currProduct = 1;

        for (int right = 0; right < nums.length; right++) {
            currProduct *= nums[right]; // Multiply the current element into the window product.

            // If the current product exceeds or equals k, shrink the window from the left.
            while (currProduct >= k) {
                currProduct /= nums[left]; // Divide the left element out of the window product.
                left++;
            }

            // Count the valid subarrays ending at the current right index.
            count += right - left + 1;
        }

        return count;
    }

    /**
     * FindBestSubarray finds the sum of the subarray with the largest sum and of a fixed length k.
     * <p>
     * Time Complexity: O(n) - Each element is added to and subtracted from the running sum once.
     * Space Complexity: O(1) - Only a few integer variables are used.
     */
    public static int findBestSubarray(int[] nums, int k) {
        int currSum = 0;

        // Build the sum of the first window of size k.
        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }

        int maxSum = currSum;

        // Slide the window across the array and update the sum.
        for (int i = k; i < nums.length; i++) {
            currSum += nums[i] - nums[i - k]; // Add the new element and remove the old one from the sum.
            maxSum = Math.max(maxSum, currSum); // Update the maximum sum.
        }

        return maxSum;
    }

}
