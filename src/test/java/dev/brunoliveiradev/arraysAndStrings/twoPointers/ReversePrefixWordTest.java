package dev.brunoliveiradev.arraysAndStrings.twoPointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReversePrefixWordTest {

    @Test
    void reversePrefix_firstOccurrence() {
        String word = "abcdefd";
        char ch = 'd';
        String expected = "dcbaefd";
        assertEquals(expected, ReversePrefixWord.ReversePrefix(word, ch));
    }

    @Test
    void reversePrefix_singleOccurrence() {
        String word = "xyxzxe";
        char ch = 'z';
        String expected = "zxyxxe";
        assertEquals(expected, ReversePrefixWord.ReversePrefix(word, ch));
    }

    @Test
    void reversePrefix_characterNotPresent() {
        String word = "abcd";
        char ch = 'z';
        String expected = "abcd";
        assertEquals(expected, ReversePrefixWord.ReversePrefix(word, ch));
    }

    @Test
    void reversePrefix_reverseEntireString() {
        String word = "rzwuktxcjfpamlonbgyieqdvhs";
        char ch = 's';
        String expected = "shvdqeiygbnolmapfjcxtkuwzr";
        assertEquals(expected, ReversePrefixWord.ReversePrefix(word, ch));
    }

    @Test
    void reversePrefix_emptyString() {
        String word = "";
        char ch = 'a';
        String expected = "";
        assertEquals(expected, ReversePrefixWord.ReversePrefix(word, ch));
    }

    @Test
    void reversePrefix_singleCharacterString() {
        String word = "a";
        char ch = 'a';
        String expected = "a";
        assertEquals(expected, ReversePrefixWord.ReversePrefix(word, ch));
    }

    @Test
    void reversePrefix_characterAtStart() {
        String word = "abcdef";
        char ch = 'a';
        String expected = "abcdef";
        assertEquals(expected, ReversePrefixWord.ReversePrefix(word, ch));
    }

    @Test
    void reversePrefix_characterAtEnd() {
        String word = "abcdef";
        char ch = 'f';
        String expected = "fedcba";
        assertEquals(expected, ReversePrefixWord.ReversePrefix(word, ch));
    }
}