package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TimeConversionTest {


    @Test
    void converts12HourFormatTo24HourFormat() {
        assertEquals("19:05:45", TimeConversion.Conversion("07:05:45PM"));
    }

    @Test
    void convertsMidnightTo24HourFormat() {
        assertEquals("00:00:00", TimeConversion.Conversion("12:00:00AM"));
    }

    @Test
    void convertsNoonTo24HourFormat() {
        assertEquals("12:00:00", TimeConversion.Conversion("12:00:00PM"));
    }

    @Test
    void handlesInvalidTimeFormat() {
        assertThrows(IllegalArgumentException.class, () -> TimeConversion.Conversion("25:00:00"));
    }

    @Test
    void handlesEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> TimeConversion.Conversion(""));
    }
}