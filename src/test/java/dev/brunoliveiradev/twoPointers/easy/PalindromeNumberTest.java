package dev.brunoliveiradev.twoPointers.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeNumberTest {
    

    @Test
    void isPalindromeWithSingleDigit() {
        int input = 7;
        boolean result = new PalindromeNumber().isPalindromeNumber(input);
        assertTrue(result);
    }

    @Test
    void isPalindromeWithZero() {
        int input = 0;
        boolean result = new PalindromeNumber().isPalindromeNumber(input);
        assertTrue(result);
    }

    @Test
    void isPalindromeWithEvenDigits() {
        int input = 1221;
        boolean result = new PalindromeNumber().isPalindromeNumber(input);
        assertTrue(result);
    }

    @Test
    void isPalindromeWithOddDigits() {
        int input = 12321;
        boolean result = new PalindromeNumber().isPalindromeNumber(input);
        assertTrue(result);
    }

    @Test
    void isNotPalindromeSimple() {
        int input = 12;
        boolean result = new PalindromeNumber().isPalindromeNumber(input);
        assertFalse(result);
    }

    @Test
    void isNotPalindromeWithTrailingZero() {
        int input = 10;
        boolean result = new PalindromeNumber().isPalindromeNumber(input);
        assertFalse(result);
    }

    @Test
    void isNotPalindromeWithMultipleTrailingZeros() {
        int input = 100;
        boolean result = new PalindromeNumber().isPalindromeNumber(input);
        assertFalse(result);
    }

    @Test
    void isNotPalindromeWithNegativeNumber() {
        int input = -121;
        boolean result = new PalindromeNumber().isPalindromeNumber(input);
        assertFalse(result);
    }

    @Test
    void isPalindromeWithLargeNumber() {
        int input = 1000000001;
        boolean result = new PalindromeNumber().isPalindromeNumber(input);
        assertTrue(result);
    }

    @Test
    void isNotPalindromeWithLargeNumber() {
        int input = 123456789;
        boolean result = new PalindromeNumber().isPalindromeNumber(input);
        assertFalse(result);
    }
}