package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static dev.brunoliveiradev.arraysAndStrings.easyAlgorithms.GreatestNumberOfCandies.kidsWithCandies;
import static org.junit.jupiter.api.Assertions.*;

class GreatestNumberOfCandiesTest {

    @Test
    void kidsWithCandiesCase1() {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> expected = Arrays.asList(true, true, true, false, true);
        List<Boolean> actual = kidsWithCandies(candies, extraCandies);
        assertEquals(expected, actual);
    }

    @Test
    void kidsWithCandiesCase2() {
        int[] candies = {4, 2, 1, 1, 2};
        int extraCandies = 1;
        List<Boolean> expected = Arrays.asList(true, false, false, false, false);
        List<Boolean> actual = kidsWithCandies(candies, extraCandies);
        assertEquals(expected, actual);
    }

    @Test
    void kidsWithCandiesCase3() {
        int[] candies = {12, 1, 12};
        int extraCandies = 10;
        List<Boolean> expected = Arrays.asList(true, false, true);
        List<Boolean> actual = kidsWithCandies(candies, extraCandies);
        assertEquals(expected, actual);
    }
}