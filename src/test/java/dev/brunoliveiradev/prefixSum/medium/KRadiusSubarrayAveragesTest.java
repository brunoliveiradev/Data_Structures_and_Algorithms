package dev.brunoliveiradev.prefixSum.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class KRadiusSubarrayAveragesTest {

    @Test
    void testKEqualsZero() {
        int[] nums = {7, 4, 3, 9, 1};
        int k = 0;
        int[] expected = {7, 4, 3, 9, 1};
        assertArrayEquals(expected, KRadiusSubarrayAverages.getAverages(nums, k));
    }

    @Test
    void testKGreaterThanArrayLength() {
        int[] nums = {5, 2, 6, 3};
        int k = 10; // k is larger than the array length
        int[] expected = {-1, -1, -1, -1}; // No averages can be calculated
        assertArrayEquals(expected, KRadiusSubarrayAverages.getAverages(nums, k));
    }

    @Test
    void testValidAverages() {
        int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
        int k = 3;
        int[] expected = {-1, -1, -1, 5, 4, 4, -1, -1, -1};
        assertArrayEquals(expected, KRadiusSubarrayAverages.getAverages(nums, k));
    }

    @Test
    void testSingleElementArray() {
        int[] nums = {100000};
        int k = 0;
        int[] expected = {100000}; // Single element, k=0, should return the element itself
        assertArrayEquals(expected, KRadiusSubarrayAverages.getAverages(nums, k));
    }

    @Test
    void testArrayWithLargerRadius() {
        int[] nums = {8};
        int k = 100000; // k is too large for any calculation
        int[] expected = {-1}; // Can't calculate averages with such a large k
        assertArrayEquals(expected, KRadiusSubarrayAverages.getAverages(nums, k));
    }

    @Test
    void testEdgeCaseEmptyArray() {
        int[] nums = {};
        int k = 1;
        int[] expected = {};
        assertArrayEquals(expected, KRadiusSubarrayAverages.getAverages(nums, k));
    }

    @Test
    void testAllSameElements() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1};
        int k = 2;
        int[] expected = {-1, -1, 1, 1, 1, -1, -1}; // All elements are the same
        assertArrayEquals(expected, KRadiusSubarrayAverages.getAverages(nums, k));
    }
}