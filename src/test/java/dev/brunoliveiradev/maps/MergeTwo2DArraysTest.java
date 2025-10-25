package dev.brunoliveiradev.maps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Unit tests for the MergeTwo2DArrays class.
 *
 * <p>
 * This class tests the functionality of the `mergeArrays` method. The method merges two 2D arrays
 * by combining rows with the same key and summing their values. If a key exists in only one of the
 * arrays, its corresponding row will be included as is.
 */
class MergeTwo2DArraysTest {

    @Test
    void testBothArraysNonEmptyWithOverlappingKeys() {
        // Setup
        MergeTwo2DArrays mergeTwo2DArrays = new MergeTwo2DArrays();
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{2, 4}, {3, 6}, {4, 1}};

        // Expected result
        int[][] expected = {{1, 2}, {2, 7}, {3, 6}, {4, 6}};

        // Execution
        int[][] result = mergeTwo2DArrays.mergeArrays(nums1, nums2);

        // Assertion
        assertArrayEquals(expected, result);
    }

    @Test
    void testDisjointKeysInBothArrays() {
        // Setup
        MergeTwo2DArrays mergeTwo2DArrays = new MergeTwo2DArrays();
        int[][] nums1 = {{1, 2}, {3, 4}};
        int[][] nums2 = {{2, 3}, {4, 5}};

        // Expected result
        int[][] expected = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};

        // Execution
        int[][] result = mergeTwo2DArrays.mergeArrays(nums1, nums2);

        // Assertion
        assertArrayEquals(expected, result);
    }

    @Test
    void testEmptyFirstArray() {
        // Setup
        MergeTwo2DArrays mergeTwo2DArrays = new MergeTwo2DArrays();
        int[][] nums1 = {};
        int[][] nums2 = {{1, 2}, {3, 4}};

        // Expected result
        int[][] expected = {{1, 2}, {3, 4}};

        // Execution
        int[][] result = mergeTwo2DArrays.mergeArrays(nums1, nums2);

        // Assertion
        assertArrayEquals(expected, result);
    }

    @Test
    void testEmptySecondArray() {
        // Setup
        MergeTwo2DArrays mergeTwo2DArrays = new MergeTwo2DArrays();
        int[][] nums1 = {{1, 2}, {3, 4}};
        int[][] nums2 = {};

        // Expected result
        int[][] expected = {{1, 2}, {3, 4}};

        // Execution
        int[][] result = mergeTwo2DArrays.mergeArrays(nums1, nums2);

        // Assertion
        assertArrayEquals(expected, result);
    }

    @Test
    void testBothArraysEmpty() {
        // Setup
        MergeTwo2DArrays mergeTwo2DArrays = new MergeTwo2DArrays();
        int[][] nums1 = {};
        int[][] nums2 = {};

        // Expected result
        int[][] expected = {};

        // Execution
        int[][] result = mergeTwo2DArrays.mergeArrays(nums1, nums2);

        // Assertion
        assertArrayEquals(expected, result);
    }

    @Test
    void testSingleElementArraysWithSameKey() {
        // Setup
        MergeTwo2DArrays mergeTwo2DArrays = new MergeTwo2DArrays();
        int[][] nums1 = {{1, 5}};
        int[][] nums2 = {{1, 10}};

        // Expected result
        int[][] expected = {{1, 15}};

        // Execution
        int[][] result = mergeTwo2DArrays.mergeArrays(nums1, nums2);

        // Assertion
        assertArrayEquals(expected, result);
    }

    @Test
    void testSingleElementArraysDifferentKeys() {
        // Setup
        MergeTwo2DArrays mergeTwo2DArrays = new MergeTwo2DArrays();
        int[][] nums1 = {{1, 5}};
        int[][] nums2 = {{2, 10}};

        // Expected result
        int[][] expected = {{1, 5}, {2, 10}};

        // Execution
        int[][] result = mergeTwo2DArrays.mergeArrays(nums1, nums2);

        // Assertion
        assertArrayEquals(expected, result);
    }

    @Test
    void testMixedLengths() {
        // Setup
        MergeTwo2DArrays mergeTwo2DArrays = new MergeTwo2DArrays();
        int[][] nums1 = {{1, 1}, {3, 3}, {5, 5}};
        int[][] nums2 = {{2, 2}, {3, 7}, {4, 4}};

        // Expected result
        int[][] expected = {{1, 1}, {2, 2}, {3, 10}, {4, 4}, {5, 5}};

        // Execution
        int[][] result = mergeTwo2DArrays.mergeArrays(nums1, nums2);

        // Assertion
        assertArrayEquals(expected, result);
    }
}