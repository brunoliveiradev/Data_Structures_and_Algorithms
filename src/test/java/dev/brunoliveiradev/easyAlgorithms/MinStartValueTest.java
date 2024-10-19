package dev.brunoliveiradev.easyAlgorithms;

import dev.brunoliveiradev.arraysAndStrings.easyAlgorithms.MinStartValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinStartValueTest {

    @Test
    void minStartValueExample1() {
        int[] nums = {-3, 2, -3, 4, 2};
        int result = MinStartValue.minStartValue(nums);
        assertEquals(5, result);
    }

    @Test
    void minStartValueExample2() {
        int[] nums = {1, 2};
        int result = MinStartValue.minStartValue(nums);
        assertEquals(1, result);
    }

    @Test
    void minStartValueExample3() {
        int[] nums = {1, -2, -3};
        int result = MinStartValue.minStartValue(nums);
        assertEquals(5, result);
    }
}