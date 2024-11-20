package dev.brunoliveiradev.arraysAndStrings.prefixSum.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheHighestAltitudeTest {

    @Test
    void largestAltitude_mixedGains() {
        int[] gain = {-5, 1, 5, 0, -7};
        assertEquals(1, FindTheHighestAltitude.largestAltitude(gain));
    }

    @Test
    void largestAltitude_allNegativeThenPositiveGains() {
        int[] gain = {-4, -3, -2, -1, 4, 3, 2};
        assertEquals(0, FindTheHighestAltitude.largestAltitude(gain));
    }
}