package dev.brunoliveiradev.easyAlgorithms;

import dev.brunoliveiradev.arraysAndStrings.easyAlgorithms.MaxLengthBetweenStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MaxLengthBetweenStringsTest {

    @Test
    void returnsCorrectMaxLengthCombinedForNonEmptyStrings() {
        assertEquals(10, MaxLengthBetweenStrings.getMaxLengthCombined("hello", "world"));
    }

    @Test
    void returnsCorrectMaxLengthCombinedForEmptyAndNonEmptyString() {
        assertEquals(5, MaxLengthBetweenStrings.getMaxLengthCombined("", "world"));
    }

    @Test
    void returnsCorrectMaxLengthCombinedForTwoEmptyStrings() {
        assertEquals(0, MaxLengthBetweenStrings.getMaxLengthCombined("", ""));
    }

    @Test
    void returnsCorrectMaxLengthBetweenForNonEmptyStrings() {
        assertEquals(5, MaxLengthBetweenStrings.getMaxLengthBetween("hello", "world"));
    }

    @Test
    void returnsCorrectMaxLengthBetweenForEmptyAndNonEmptyString() {
        assertEquals(5, MaxLengthBetweenStrings.getMaxLengthBetween("", "world"));
    }

    @Test
    void returnsCorrectMaxLengthBetweenForTwoEmptyStrings() {
        assertEquals(0, MaxLengthBetweenStrings.getMaxLengthBetween("", ""));
    }

    @Test
    void returnsTrueForNullStringInIsNullOrBlank() {
        assertTrue(MaxLengthBetweenStrings.isNullOrBlank(null));
    }

    @Test
    void returnsTrueForEmptyStringInIsNullOrBlank() {
        assertTrue(MaxLengthBetweenStrings.isNullOrBlank(""));
    }

    @Test
    void returnsTrueForBlankStringInIsNullOrBlank() {
        assertTrue(MaxLengthBetweenStrings.isNullOrBlank("   "));
    }

    @Test
    void returnsFalseForNonEmptyStringInIsNullOrBlank() {
        assertFalse(MaxLengthBetweenStrings.isNullOrBlank("hello"));
    }
}