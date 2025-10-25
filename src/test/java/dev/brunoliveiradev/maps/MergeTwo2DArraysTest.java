package dev.brunoliveiradev.maps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Should merge maps with common keys by summing their values")
    void shouldMergeMapsWithCommonKeys() {
        // Arrange
        Map<Integer, Integer> mapA = new HashMap<>();
        mapA.put(1, 10);
        mapA.put(2, 20);
        mapA.put(3, 30);

        Map<Integer, Integer> mapB = new HashMap<>();
        mapB.put(2, 5);
        mapB.put(3, 15);
        mapB.put(4, 40);

        // Act
        Map<Integer, Integer> result = MergeTwo2DArrays.mergeSum(mapA, mapB);

        // Assert
        assertEquals(4, result.size());
        assertEquals(10, result.get(1));
        assertEquals(25, result.get(2)); // 20 + 5
        assertEquals(45, result.get(3)); // 30 + 15
        assertEquals(40, result.get(4));
    }

    @Test
    @DisplayName("Should merge maps with no common keys")
    void shouldMergeMapsWithNoCommonKeys() {
        // Arrange
        Map<Integer, Integer> mapA = new HashMap<>();
        mapA.put(1, 100);
        mapA.put(2, 200);

        Map<Integer, Integer> mapB = new HashMap<>();
        mapB.put(3, 300);
        mapB.put(4, 400);

        // Act
        Map<Integer, Integer> result = MergeTwo2DArrays.mergeSum(mapA, mapB);

        // Assert
        assertEquals(4, result.size());
        assertEquals(100, result.get(1));
        assertEquals(200, result.get(2));
        assertEquals(300, result.get(3));
        assertEquals(400, result.get(4));
    }

    @Test
    @DisplayName("Should return copy of first map when second map is empty")
    void shouldReturnCopyOfFirstMapWhenSecondMapIsEmpty() {
        // Arrange
        Map<Integer, Integer> mapA = new HashMap<>();
        mapA.put(1, 10);
        mapA.put(2, 20);

        Map<Integer, Integer> mapB = new HashMap<>();

        // Act
        Map<Integer, Integer> result = MergeTwo2DArrays.mergeSum(mapA, mapB);

        // Assert
        assertEquals(2, result.size());
        assertEquals(10, result.get(1));
        assertEquals(20, result.get(2));
    }

    @Test
    @DisplayName("Should return all elements from second map when first map is empty")
    void shouldReturnAllElementsFromSecondMapWhenFirstMapIsEmpty() {
        // Arrange
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        mapB.put(1, 10);
        mapB.put(2, 20);

        // Act
        Map<Integer, Integer> result = MergeTwo2DArrays.mergeSum(mapA, mapB);

        // Assert
        assertEquals(2, result.size());
        assertEquals(10, result.get(1));
        assertEquals(20, result.get(2));
    }

    @Test
    @DisplayName("Should return empty map when both maps are empty")
    void shouldReturnEmptyMapWhenBothMapsAreEmpty() {
        // Arrange
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();

        // Act
        Map<Integer, Integer> result = MergeTwo2DArrays.mergeSum(mapA, mapB);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Should not mutate the original first map")
    void shouldNotMutateOriginalFirstMap() {
        // Arrange
        Map<Integer, Integer> mapA = new HashMap<>();
        mapA.put(1, 10);
        mapA.put(2, 20);

        Map<Integer, Integer> mapB = new HashMap<>();
        mapB.put(2, 5);
        mapB.put(3, 30);

        Map<Integer, Integer> originalCopy = new HashMap<>(mapA);

        // Act
        MergeTwo2DArrays.mergeSum(mapA, mapB);

        // Assert
        assertEquals(originalCopy, mapA, "Original map 'a' should not be mutated");
    }

    @Test
    @DisplayName("Should not mutate the original second map")
    void shouldNotMutateOriginalSecondMap() {
        // Arrange
        Map<Integer, Integer> mapA = new HashMap<>();
        mapA.put(1, 10);
        mapA.put(2, 20);

        Map<Integer, Integer> mapB = new HashMap<>();
        mapB.put(2, 5);
        mapB.put(3, 30);

        Map<Integer, Integer> originalCopy = new HashMap<>(mapB);

        // Act
        MergeTwo2DArrays.mergeSum(mapA, mapB);

        // Assert
        assertEquals(originalCopy, mapB, "Original map 'b' should not be mutated");
    }

    @Test
    @DisplayName("Should handle negative values correctly")
    void shouldHandleNegativeValuesCorrectly() {
        // Arrange
        Map<Integer, Integer> mapA = new HashMap<>();
        mapA.put(1, 10);
        mapA.put(2, -5);

        Map<Integer, Integer> mapB = new HashMap<>();
        mapB.put(2, -10);
        mapB.put(3, 15);

        // Act
        Map<Integer, Integer> result = MergeTwo2DArrays.mergeSum(mapA, mapB);

        // Assert
        assertEquals(3, result.size());
        assertEquals(10, result.get(1));
        assertEquals(-15, result.get(2)); // -5 + (-10)
        assertEquals(15, result.get(3));
    }

    @Test
    @DisplayName("Should handle zero values correctly")
    void shouldHandleZeroValuesCorrectly() {
        // Arrange
        Map<Integer, Integer> mapA = new HashMap<>();
        mapA.put(1, 0);
        mapA.put(2, 10);

        Map<Integer, Integer> mapB = new HashMap<>();
        mapB.put(1, 5);
        mapB.put(3, 0);

        // Act
        Map<Integer, Integer> result = MergeTwo2DArrays.mergeSum(mapA, mapB);

        // Assert
        assertEquals(3, result.size());
        assertEquals(5, result.get(1)); // 0 + 5
        assertEquals(10, result.get(2));
        assertEquals(0, result.get(3));
    }
}