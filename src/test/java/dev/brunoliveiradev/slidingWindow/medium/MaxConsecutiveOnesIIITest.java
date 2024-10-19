package dev.brunoliveiradev.slidingWindow.medium;

import dev.brunoliveiradev.arraysAndStrings.slidingWindow.medium.MaxConsecutiveOnesIII;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxConsecutiveOnesIIITest {

    @Test
    void longestOnesWithExample1() {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int result = MaxConsecutiveOnesIII.longestOnes(nums, k);
        assertEquals(6, result);
    }

    @Test
    void longestOnesWithExample2() {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        int result = MaxConsecutiveOnesIII.longestOnes(nums, k);
        assertEquals(10, result);
    }

    @Test
    void longestOnesWithAllOnes() {
        int[] nums = {1, 1, 1, 1, 1};
        int k = 0;
        int result = MaxConsecutiveOnesIII.longestOnes(nums, k);
        assertEquals(5, result);
    }

    @Test
    void longestOnesWithAllZeros() {
        int[] nums = {0, 0, 0, 0, 0};
        int k = 5;
        int result = MaxConsecutiveOnesIII.longestOnes(nums, k);
        assertEquals(5, result);
    }

    @Test
    void longestOnesWithMixedNumbers() {
        int[] nums = {1, 0, 1, 0, 1, 0, 1, 0, 1};
        int k = 2;
        int result = MaxConsecutiveOnesIII.longestOnes(nums, k);
        assertEquals(5, result);
    }

    @Test
    void longestOnesWithNoFlipsAllowed() {
        int[] nums = {1, 0, 1, 0, 1};
        int k = 0;
        int result = MaxConsecutiveOnesIII.longestOnes(nums, k);
        assertEquals(1, result);
    }

    @Test
    void longestOnesWithLargeArray() {
        int[] nums = new int[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2;
        }
        int k = 50000;
        int result = MaxConsecutiveOnesIII.longestOnes(nums, k);
        assertEquals(100000, result);
    }
}