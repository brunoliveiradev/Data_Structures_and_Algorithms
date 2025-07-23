package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FindMedianTest {

    @Test
    void findMedianReturnsMedianForOddLengthArray() {
        long[] array = {3, 1, 4, 1, 5};
        assertEquals(3, FindMedian.FindMedian(array));
    }

    @Test
    void findMedianReturnsMedianForEvenLengthArray() {
        long[] array = {3, 1, 4, 1};
        assertEquals(2, FindMedian.FindMedian(array));
    }

    @Test
    void findMedianThrowsExceptionForEmptyArray() {
        long[] array = {};
        assertThrows(IllegalArgumentException.class, () -> FindMedian.FindMedian(array));
    }

    @Test
    void findMedianReturnsSingleElementForSingleElementArray() {
        long[] array = {42};
        assertEquals(42, FindMedian.FindMedian(array));
    }

    @Test
    void findMedianHandlesArrayWithNegativeNumbers() {
        long[] array = {-3, -1, -7, -2};
        assertEquals(-2, FindMedian.FindMedian(array));
    }

    @Test
    void findMedianHandlesArrayWithDuplicateElements() {
        long[] array = {4, 2, 4, 2, 4};
        assertEquals(4, FindMedian.FindMedian(array));
    }

    @Test
    void findMedianHandlesArrayWithMixedPositiveAndNegativeNumbers() {
        long[] array = {-3, 5, -1, 7, -2};
        assertEquals(-1, FindMedian.FindMedian(array));
    }
}