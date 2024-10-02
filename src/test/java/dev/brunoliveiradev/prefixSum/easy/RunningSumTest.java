package dev.brunoliveiradev.prefixSum.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunningSumTest {

    @Test
    void runningSumWithEmptyArray() {
        int[] nums = {};
        int[] result = RunningSum.runningSum(nums);
        assertArrayEquals(new int[]{}, result);
    }

    @Test
    void runningSumWithSingleElement() {
        int[] nums = {5};
        int[] result = RunningSum.runningSum(nums);
        assertArrayEquals(new int[]{5}, result);
    }

    @Test
    void runningSumWithMultipleElements() {
        int[] nums = {1, 2, 3, 4};
        int[] result = RunningSum.runningSum(nums);
        assertArrayEquals(new int[]{1, 3, 6, 10}, result);
    }

    @Test
    void runningSumWithNegativeNumbers() {
        int[] nums = {-1, -2, -3, -4};
        int[] result = RunningSum.runningSum(nums);
        assertArrayEquals(new int[]{-1, -3, -6, -10}, result);
    }

    @Test
    void runningSumWithMixedNumbers() {
        int[] nums = {1, -2, 3, -4, 5};
        int[] result = RunningSum.runningSum(nums);
        assertArrayEquals(new int[]{1, -1, 2, -2, 3}, result);
    }

    @Test
    void runningSumWithZeros() {
        int[] nums = {0, 0, 0, 0};
        int[] result = RunningSum.runningSum(nums);
        assertArrayEquals(new int[]{0, 0, 0, 0}, result);
    }
}