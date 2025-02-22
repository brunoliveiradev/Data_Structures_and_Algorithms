package dev.brunoliveiradev.arraysAndStrings.twoPointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoveZeroesTest {

    @Test
    void moveZeroes_shiftsZerosToEnd() {
        int[] input = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
        MoveZeroes.moveZeroes(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void moveZeroes_noZerosUnchanged() {
        int[] input = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};
        MoveZeroes.moveZeroes(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void moveZeroes_allZerosUnchanged() {
        int[] input = {0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0};
        MoveZeroes.moveZeroes(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void moveZeroes_singleElementArray() {
        int[] input = {7};
        int[] expected = {7};
        MoveZeroes.moveZeroes(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void moveZeroesWithTwoPointers_shiftsZerosToEnd() {
        int[] input = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
        MoveZeroes.moveZeroesWithTwoPointers(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void moveZeroesWithTwoPointers_noZerosUnchanged() {
        int[] input = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};
        MoveZeroes.moveZeroesWithTwoPointers(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void moveZeroesWithTwoPointers_allZerosUnchanged() {
        int[] input = {0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0};
        MoveZeroes.moveZeroesWithTwoPointers(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void moveZeroesWithTwoPointers_singleElementArray() {
        int[] input = {7};
        int[] expected = {7};
        MoveZeroes.moveZeroesWithTwoPointers(input);
        assertArrayEquals(expected, input);
    }
}