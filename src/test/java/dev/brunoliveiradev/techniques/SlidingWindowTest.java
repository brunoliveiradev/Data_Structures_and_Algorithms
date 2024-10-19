package dev.brunoliveiradev.techniques;

import dev.brunoliveiradev.techniques.arraysAndStrings.SlidingWindow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SlidingWindowTest {

    @Test
    void findMaxLength() {
        // Test normal case
        assertEquals(3, SlidingWindow.findMaxLength(new int[]{1, 2, 3, 4, 5}, 8));

        // Test with single element matching the target
        assertEquals(1, SlidingWindow.findMaxLength(new int[]{10}, 10));

        // Test with no valid subarray
        assertEquals(0, SlidingWindow.findMaxLength(new int[]{10, 20, 30}, 5));

        // Test with all elements less than k
        assertEquals(5, SlidingWindow.findMaxLength(new int[]{1, 1, 1, 1, 1}, 5));

        // Test with k = 0 (no valid subarray since all elements are > 0)
        assertEquals(0, SlidingWindow.findMaxLength(new int[]{1, 2, 3, 4}, 0));

        // Test with large k
        assertEquals(5, SlidingWindow.findMaxLength(new int[]{2, 4, 1, 3, 2}, 100));

        // Test empty array
        assertEquals(0, SlidingWindow.findMaxLength(new int[]{}, 5));
    }

    @Test
    void findLength() {
        // Test normal case
        assertEquals(6, SlidingWindow.findLength("110110111"));

        // Test with all ones
        assertEquals(5, SlidingWindow.findLength("11111"));

        // Test with all zeros
        assertEquals(1, SlidingWindow.findLength("00000"));

        // Test single character string
        assertEquals(1, SlidingWindow.findLength("0"));
        assertEquals(1, SlidingWindow.findLength("1"));

        // Test with alternating zeros and ones
        assertEquals(3, SlidingWindow.findLength("0101010"));

        // Test with flipping the first '0'
        assertEquals(5, SlidingWindow.findLength("011110"));
    }

    @Test
    void numSubarrayProductLessThanK() {
        // Test normal case
        assertEquals(8, SlidingWindow.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));

        // Test with all elements greater than k
        assertEquals(0, SlidingWindow.numSubarrayProductLessThanK(new int[]{10, 15, 20}, 5));

        // Test with product of all elements equal to k
        assertEquals(0, SlidingWindow.numSubarrayProductLessThanK(new int[]{10, 5, 2}, 1));

        // Test with k = 0
        assertEquals(0, SlidingWindow.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));

        // Corrected expected value
        assertEquals(4, SlidingWindow.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 6));

        // Test with k = 1 (since all products must be strictly less than 1, no valid subarray exists)
        assertEquals(0, SlidingWindow.numSubarrayProductLessThanK(new int[]{1, 1, 1}, 1));

        // Test empty array
        assertEquals(0, SlidingWindow.numSubarrayProductLessThanK(new int[]{}, 10));
    }

    @Test
    void findBestSubarray() {
        // Test normal case
        assertEquals(9, SlidingWindow.findBestSubarray(new int[]{2, 1, 5, 1, 3, 2}, 3));

        // Test subarray of size 1 (maximum element)
        assertEquals(3, SlidingWindow.findBestSubarray(new int[]{1, 2, 3}, 1));

        // Test with array length equal to k (sum of the whole array)
        assertEquals(10, SlidingWindow.findBestSubarray(new int[]{2, 3, 5}, 3));

        // Corrected expected value for negative array test
        assertEquals(-5, SlidingWindow.findBestSubarray(new int[]{-2, -3, -5}, 2));

        // Test with mixed positive and negative values
        assertEquals(5, SlidingWindow.findBestSubarray(new int[]{2, -3, 5, 1, -1, 3}, 3));

        // Test with empty array
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SlidingWindow.findBestSubarray(new int[]{}, 1));

        // Test with k greater than the array size (invalid)
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SlidingWindow.findBestSubarray(new int[]{1, 2, 3}, 4));
    }
}
