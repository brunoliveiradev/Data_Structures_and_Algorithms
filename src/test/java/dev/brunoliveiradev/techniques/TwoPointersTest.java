package dev.brunoliveiradev.techniques;

import dev.brunoliveiradev.techniques.arraysAndStrings.TwoPointers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoPointersTest {

    @Test
    void isPalindromeWithEmptyString() {
        assertTrue(TwoPointers.isPalindrome(""));
    }

    @Test
    void isPalindromeWithSingleCharacter() {
        assertTrue(TwoPointers.isPalindrome("a"));
    }

    @Test
    void isPalindromeWithEvenLengthPalindrome() {
        assertTrue(TwoPointers.isPalindrome("abba"));
    }

    @Test
    void isPalindromeWithOddLengthPalindrome() {
        assertTrue(TwoPointers.isPalindrome("racecar"));
    }

    @Test
    void isPalindromeWithNonPalindrome() {
        assertFalse(TwoPointers.isPalindrome("hello"));
    }

    @Test
    void twoNumberSumWithPairExists() {
        assertTrue(TwoPointers.twoNumberSum(new int[]{1, 2, 3, 4, 5}, 9));
    }

    @Test
    void twoNumberSumWithPairDoesNotExist() {
        assertFalse(TwoPointers.twoNumberSum(new int[]{1, 2, 3, 4, 5}, 10));
    }

    @Test
    void twoNumberSumWithEmptyArray() {
        assertFalse(TwoPointers.twoNumberSum(new int[]{}, 5));
    }

    @Test
    void twoNumberSumWithSingleElementArray() {
        assertFalse(TwoPointers.twoNumberSum(new int[]{5}, 5));
    }

    @Test
    void twoNumberSumWithNegativeNumbers() {
        assertTrue(TwoPointers.twoNumberSum(new int[]{-3, -1, 0, 2, 4}, 1));
    }
}