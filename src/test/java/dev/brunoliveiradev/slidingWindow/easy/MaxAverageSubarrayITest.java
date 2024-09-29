package dev.brunoliveiradev.slidingWindow.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxAverageSubarrayITest {

    @Test
    void findMaxAverageWithExample1() {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double result = MaxAverageSubarrayI.findMaxAverage(nums, k);
        assertEquals(12.75, result, 0.00001);
    }

    @Test
    void findMaxAverageWithExample2() {
        int[] nums = {5};
        int k = 1;
        double result = MaxAverageSubarrayI.findMaxAverage(nums, k);
        assertEquals(5.0, result, 0.00001);
    }

    @Test
    void findMaxAverageWithAllNegativeNumbers() {
        int[] nums = {-10, -20, -30, -40};
        int k = 2;
        double result = MaxAverageSubarrayI.findMaxAverage(nums, k);
        assertEquals(-15.0, result, 0.00001);
    }

    @Test
    void findMaxAverageWithMixedNumbers() {
        int[] nums = {-1, 2, 3, -4, 5, -6};
        int k = 3;
        double result = MaxAverageSubarrayI.findMaxAverage(nums, k);
        assertEquals(1.33333, result, 0.00001);
    }

    @Test
    void findMaxAverageWithLargeK() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 10;
        double result = MaxAverageSubarrayI.findMaxAverage(nums, k);
        assertEquals(5.5, result, 0.00001);
    }
}