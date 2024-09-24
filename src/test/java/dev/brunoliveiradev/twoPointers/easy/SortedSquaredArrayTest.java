package dev.brunoliveiradev.twoPointers.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedSquaredArrayTest {


    @Test
    void sortedSquaresWithEmptyArray() {
        int[] input = {};
        int[] result = SortedSquaredArray.sortedSquares(input);
        assertArrayEquals(new int[]{}, result);
    }

    @Test
    void sortedSquaresWithSingleElement() {
        int[] input = {3};
        int[] result = SortedSquaredArray.sortedSquares(input);
        assertArrayEquals(new int[]{9}, result);
    }

    @Test
    void sortedSquaresWithAllPositiveNumbers() {
        int[] input = {1, 2, 3, 4};
        int[] result = SortedSquaredArray.sortedSquares(input);
        assertArrayEquals(new int[]{1, 4, 9, 16}, result);
    }

    @Test
    void sortedSquaresWithAllNegativeNumbers() {
        int[] input = {-4, -3, -2, -1};
        int[] result = SortedSquaredArray.sortedSquares(input);
        assertArrayEquals(new int[]{1, 4, 9, 16}, result);
    }

    @Test
    void sortedSquaresWithMixedNumbers() {
        int[] input = {-7, -3, 2, 3, 11};
        int[] result = SortedSquaredArray.sortedSquares(input);
        assertArrayEquals(new int[]{4, 9, 9, 49, 121}, result);
    }

    @Test
    void sortedSquaresWithZeros() {
        int[] input = {-2, 0, 0, 2};
        int[] result = SortedSquaredArray.sortedSquares(input);
        assertArrayEquals(new int[]{0, 0, 4, 4}, result);
    }

    @Test
    void sortedSquaresWithLargeNumbers() {
        int[] input = {-10000, -5000, 0, 5000, 10000};
        int[] result = SortedSquaredArray.sortedSquares(input);
        assertArrayEquals(new int[]{0, 25000000, 25000000, 100000000, 100000000}, result);
    }
}