package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for CountGreaterThanPreviousAverage.
 * <p>
 * The countResponseTimeRegressions method calculates the number of elements in a list of integers
 * that are strictly greater than the average of all previous elements.
 */
class CountGreaterThanPreviousAverageTest {

    @Test
    void testWithIncreasingNumbers() {
        List<Integer> responseTimes = List.of(100, 200, 300, 400, 500);
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(responseTimes);
        assertEquals(4, result, "Expected 4 response times to be greater than the average of previous times.");
    }

    @Test
    void testWithDecreasingNumbers() {
        List<Integer> responseTimes = List.of(500, 400, 300, 200, 100);
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(responseTimes);
        assertEquals(0, result, "Expected 0 response times to be greater than the average of previous times.");
    }

    @Test
    void testWithMixedNumbers() {
        List<Integer> responseTimes = List.of(100, 200, 150, 300);
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(responseTimes);
        assertEquals(2, result, "Expected 2 response times to be greater than the average of previous times.");
    }

    @Test
    void testWithAllEqualNumbers() {
        List<Integer> responseTimes = List.of(100, 100, 100, 100);
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(responseTimes);
        assertEquals(0, result, "Expected 0 response times to be greater than the average of previous times.");
    }

    @Test
    void testWithSingleElement() {
        List<Integer> responseTimes = List.of(100);
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(responseTimes);
        assertEquals(0, result, "Expected 0 response times to be greater than the average of previous times when only one element is provided.");
    }

    @Test
    void testWithEmptyList() {
        List<Integer> responseTimes = List.of();
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(responseTimes);
        assertEquals(0, result, "Expected 0 response times for an empty list.");
    }

    @Test
    void testWithAlternatingHighAndLowValues() {
        List<Integer> responseTimes = List.of(100, 300, 100, 300, 100);
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(responseTimes);
        assertEquals(2, result, "Expected 2 response times to be greater than the average of previous times.");
    }

    @Test
    void testWithLargeNumbers() {
        List<Integer> responseTimes = List.of(1_000_000_000, 999_999_999, 1_000_000_001, 1_000_000_002);
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(responseTimes);
        assertEquals(2, result, "Expected 2 response times to be greater than the average of previous times for large numbers.");
    }

    @Test
    void testWithZeros() {
        List<Integer> responseTimes = List.of(0, 0, 0, 0, 0);
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(responseTimes);
        assertEquals(0, result, "Expected 0 response times to be greater than the average of previous times when all elements are zero.");
    }

    @Test
    void testWithHighVariance() {
        List<Integer> responseTimes = List.of(100, 1000, 10, 10000, 1);
        int result = CountGreaterThanPreviousAverage.countResponseTimeRegressions(responseTimes);
        assertEquals(2, result, "Expected 2 response times to be greater than the average of previous times for a high variance dataset.");
    }

}