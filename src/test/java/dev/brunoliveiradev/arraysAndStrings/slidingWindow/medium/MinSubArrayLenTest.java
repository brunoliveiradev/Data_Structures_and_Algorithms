package dev.brunoliveiradev.arraysAndStrings.slidingWindow.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinSubArrayLenTest {

    @Test
    void minSubArrayLen_minimalSubarrayLength() {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        assertEquals(2, MinSubArrayLen.minSubArrayLen(target, nums));
    }

    @Test
    void minSubArrayLen_singleElementSubarray() {
        int target = 4;
        int[] nums = {1, 4, 4};
        assertEquals(1, MinSubArrayLen.minSubArrayLen(target, nums));
    }

    @Test
    void minSubArrayLen_noValidSubarray() {
        int target = 11;
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        assertEquals(0, MinSubArrayLen.minSubArrayLen(target, nums));
    }

    @Test
    void minSubArrayLen_emptyArray() {
        int target = 5;
        int[] nums = {};
        assertEquals(0, MinSubArrayLen.minSubArrayLen(target, nums));
    }

    @Test
    void minSubArrayLen_singleElementEqualToTarget() {
        int target = 5;
        int[] nums = {5};
        assertEquals(1, MinSubArrayLen.minSubArrayLen(target, nums));
    }

    @Test
    void minSubArrayLen_singleElementLessThanTarget() {
        int target = 5;
        int[] nums = {3};
        assertEquals(0, MinSubArrayLen.minSubArrayLen(target, nums));
    }

    @Test
    void minSubArrayLen_largeNumbers() {
        int target = 1000000000;
        int[] nums = {100000000, 200000000, 300000000, 400000000};
        assertEquals(4, MinSubArrayLen.minSubArrayLen(target, nums));
    }

    @Test
    void minSubArrayLen_largeArray() {
        int target = 15;
        int[] nums = new int[100000];
        Arrays.fill(nums, 1);
        nums[99999] = 15;
        assertEquals(1, MinSubArrayLen.minSubArrayLen(target, nums));
    }
}