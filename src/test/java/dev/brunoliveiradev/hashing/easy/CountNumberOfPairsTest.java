package dev.brunoliveiradev.hashing.easy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountNumberOfPairsTest {

    @Test
    void countPairsReturnsCorrectCountForMultiplePairs() {
        assertEquals(2, CountNumberOfPairs.countPairs(7, List.of(1, 2, 1, 2, 1, 3, 2)));
    }

    @Test
    void countPairsReturnsZeroForNoPairs() {
        assertEquals(0, CountNumberOfPairs.countPairs(4, List.of(1, 2, 3, 4)));
    }

    @Test
    void countPairsHandlesSingleSock() {
        assertEquals(0, CountNumberOfPairs.countPairs(1, List.of(1)));
    }

    @Test
    void countPairsHandlesEmptyList() {
        assertEquals(0, CountNumberOfPairs.countPairs(0, List.of()));
    }

    @Test
    void countPairsHandlesAllSocksOfSameColor() {
        assertEquals(2, CountNumberOfPairs.countPairs(5, List.of(1, 1, 1, 1, 1)));
    }


}