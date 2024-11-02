package dev.brunoliveiradev.arraysAndStrings.slidingWindow.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxVowelsInSubStringTest {

    @Test
    void maxVowels_allVowels() {
        String s = "abciiidef";
        int k = 3;
        assertEquals(3, MaxVowelsInSubString.maxVowels(s, k));
    }

    @Test
    void maxVowels_entireStringIsVowels() {
        String s = "aeiou";
        int k = 2;
        assertEquals(2, MaxVowelsInSubString.maxVowels(s, k));
    }

    @Test
    void maxVowels_mixedVowelsAndConsonants() {
        String s = "leetcode";
        int k = 3;
        assertEquals(2, MaxVowelsInSubString.maxVowels(s, k));
    }

    @Test
    void maxVowels_noVowels() {
        String s = "bcdfgh";
        int k = 2;
        assertEquals(0, MaxVowelsInSubString.maxVowels(s, k));
    }

    @Test
    void maxVowels_singleCharacterString() {
        String s = "a";
        int k = 1;
        assertEquals(1, MaxVowelsInSubString.maxVowels(s, k));
    }

    @Test
    void maxVowels_windowSizeEqualsStringLength() {
        String s = "aeiou";
        int k = 5;
        assertEquals(5, MaxVowelsInSubString.maxVowels(s, k));
    }

    @Test
    void maxVowels_emptyString() {
        String s = "";
        int k = 1;
        assertEquals(0, MaxVowelsInSubString.maxVowels(s, k));
    }
}