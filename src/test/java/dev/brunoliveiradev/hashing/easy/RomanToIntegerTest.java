package dev.brunoliveiradev.hashing.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanToIntegerTest {

    private final RomanToInteger converter = new RomanToInteger();

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource({
            "III,3",
            "LVIII,58",
            "MCMXCIV,1994",
            "I,1",
            "II,2",
            "XXVII,27",
            "VIII,8",
            "XL,40",
            "XC,90",
            "CD,400",
            "CM,900",
            "MMMCMXCIX,3999",
            "MDCLXVI,1666",
            "MMXXV,2025"
    })
    void convertsKnownExamples(String roman, int expected) {
        assertEquals(expected, converter.romanToInt(roman));
    }

    @Test
    @DisplayName("Handles multiple subtractive pairs in one numeral")
    void multipleSubtractivePairs() {
        // MCMXCIV is already covered; add another like CMXCIX (999)
        assertEquals(999, converter.romanToInt("CMXCIX"));
    }

    @Nested
    @DisplayName("Subtractive cases individually")
    class SubtractiveCases {
        @Test void iv() { assertEquals(4, converter.romanToInt("IV")); }
        @Test void ix() { assertEquals(9, converter.romanToInt("IX")); }
        @Test void xl() { assertEquals(40, converter.romanToInt("XL")); }
        @Test void xc() { assertEquals(90, converter.romanToInt("XC")); }
        @Test void cd() { assertEquals(400, converter.romanToInt("CD")); }
        @Test void cm() { assertEquals(900, converter.romanToInt("CM")); }
    }
}
