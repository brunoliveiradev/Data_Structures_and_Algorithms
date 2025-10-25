package dev.brunoliveiradev.arraysAndStrings.strings;

import org.junit.jupiter.api.Test;

import static dev.brunoliveiradev.arraysAndStrings.strings.RepeatedString.repeatedString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeatedStringTest {

    @Test
    void repeatedString_Ok() {
        assertEquals(7, repeatedString("aba", 10));
    }

    @Test
    void repeatedStringWhenZeroA() {
        assertEquals(0, repeatedString("bcd", 10));
    }

    @Test
    void repeatedString_WhenOnlyA() {
        assertEquals(1000000000000L, repeatedString("a", 1000000000000L));
    }

}