package dev.brunoliveiradev.techniques;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortAlgorithmTest {

    @Test
    void mergeSortSortsArrayWithMultipleElements() {
        long[] array = {5, 2, 9, 1, 5, 6};
        MergeSortAlgorithm.mergeSort(array);
        assertArrayEquals(new long[]{1, 2, 5, 5, 6, 9}, array);
    }

    @Test
    void mergeSortHandlesEmptyArray() {
        long[] array = {};
        MergeSortAlgorithm.mergeSort(array);
        assertArrayEquals(new long[]{}, array);
    }

    @Test
    void mergeSortHandlesSingleElementArray() {
        long[] array = {42};
        MergeSortAlgorithm.mergeSort(array);
        assertArrayEquals(new long[]{42}, array);
    }

    @Test
    void mergeSortHandlesAlreadySortedArray() {
        long[] array = {1, 2, 3, 4, 5};
        MergeSortAlgorithm.mergeSort(array);
        assertArrayEquals(new long[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void mergeSortHandlesArrayWithDuplicateElements() {
        long[] array = {4, 2, 4, 2, 4};
        MergeSortAlgorithm.mergeSort(array);
        assertArrayEquals(new long[]{2, 2, 4, 4, 4}, array);
    }

    @Test
    void mergeSortHandlesArrayWithNegativeNumbers() {
        long[] array = {-3, -1, -7, -2};
        MergeSortAlgorithm.mergeSort(array);
        assertArrayEquals(new long[]{-7, -3, -2, -1}, array);
    }

    @Test
    void mergeSortHandlesArrayWithMixedPositiveAndNegativeNumbers() {
        long[] array = {-3, 5, -1, 7, -2};
        MergeSortAlgorithm.mergeSort(array);
        assertArrayEquals(new long[]{-3, -2, -1, 5, 7}, array);
    }
}