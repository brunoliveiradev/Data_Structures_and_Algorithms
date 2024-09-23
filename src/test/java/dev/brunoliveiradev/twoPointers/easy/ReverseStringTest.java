package dev.brunoliveiradev.twoPointers.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    @Test
    void reverseStringWithEmptyArray() {
        char[] input = {};
        ReverseString.reverseString(input);
        assertArrayEquals(new char[]{}, input);
    }

    @Test
    void reverseStringWithSingleCharacter() {
        char[] input = {'a'};
        ReverseString.reverseString(input);
        assertArrayEquals(new char[]{'a'}, input);
    }

    @Test
    void reverseStringWithEvenLength() {
        char[] input = {'a', 'b', 'c', 'd'};
        ReverseString.reverseString(input);
        assertArrayEquals(new char[]{'d', 'c', 'b', 'a'}, input);
    }

    @Test
    void reverseStringWithOddLength() {
        char[] input = {'a', 'b', 'c', 'd', 'e'};
        ReverseString.reverseString(input);
        assertArrayEquals(new char[]{'e', 'd', 'c', 'b', 'a'}, input);
    }

    @Test
    void reverseStringWithSpecialCharacters() {
        char[] input = {'!', '@', '#', '$', '%'};
        ReverseString.reverseString(input);
        assertArrayEquals(new char[]{'%', '$', '#', '@', '!'}, input);
    }

    @Test
    void reverseStringWithMixedCharacters() {
        char[] input = {'a', '1', 'b', '2', 'c'};
        ReverseString.reverseString(input);
        assertArrayEquals(new char[]{'c', '2', 'b', '1', 'a'}, input);
    }
}