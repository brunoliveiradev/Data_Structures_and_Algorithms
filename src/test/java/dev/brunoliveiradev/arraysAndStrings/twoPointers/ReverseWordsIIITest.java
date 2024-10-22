package dev.brunoliveiradev.arraysAndStrings.twoPointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsIIITest {

    @Test
    void testMultipleWords() {
        String input = "Let's take LeetCode contest";
        String expected = "s'teL ekat edoCteeL tsetnoc";
        assertEquals(expected, ReverseWordsIII.reverseWords(input), "Should reverse each word in the sentence");
    }

    @Test
    void testSingleWord() {
        String input = "Hello";
        String expected = "olleH";
        assertEquals(expected, ReverseWordsIII.reverseWords(input), "Should reverse a single word");
    }

    @Test
    void testMultipleWordsWithSpaces() {
        String input = "Mr Ding";
        String expected = "rM gniD";
        assertEquals(expected, ReverseWordsIII.reverseWords(input), "Should reverse multiple words separated by spaces");
    }

    @Test
    void testSingleLetter() {
        String input = "A";
        String expected = "A";
        assertEquals(expected, ReverseWordsIII.reverseWords(input), "Should return the single letter as is");
    }

    @Test
    void testNumbersAndSpecialCharacters() {
        String input = "123 456 789";
        String expected = "321 654 987";
        assertEquals(expected, ReverseWordsIII.reverseWords(input), "Should reverse each group of numbers");

        String input2 = "Go! is fun!";
        String expected2 = "!oG si !nuf";
        assertEquals(expected2, ReverseWordsIII.reverseWords(input2), "Should reverse each word and preserve special characters");
    }

    @Test
    void testStringWithOnlySpaces() {
        String input = "    ";
        String expected = "    ";
        assertEquals(expected, ReverseWordsIII.reverseWords(input), "Should return the same string of spaces, no words to reverse");
    }

    @Test
    void testEmptyString() {
        String input = "";
        String expected = "";
        assertEquals(expected, ReverseWordsIII.reverseWords(input), "Should return an empty string when input is empty");
    }

    @Test
    void testStringWithSingleCharacterWords() {
        String input = "a b c";
        String expected = "a b c";
        assertEquals(expected, ReverseWordsIII.reverseWords(input), "Should return the same string when words consist of single characters");
    }
}