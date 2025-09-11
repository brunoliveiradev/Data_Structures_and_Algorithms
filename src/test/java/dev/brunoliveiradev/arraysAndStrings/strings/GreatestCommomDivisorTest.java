package dev.brunoliveiradev.arraysAndStrings.strings;

import org.junit.jupiter.api.Test;

import static dev.brunoliveiradev.arraysAndStrings.strings.GreatestCommomDivisor.gcdOfStrings;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GreatestCommomDivisorTest {

    @Test
    void gcdOfStringsCase1() {
        assertEquals("ABC",gcdOfStrings("ABCABC", "ABC"));
    }

    @Test
    void gcdOfStringsCase2() {
        assertEquals("AB",gcdOfStrings("ABABAB", "ABAB"));
    }

    @Test
    void gcdOfStringsCase3() {
        assertEquals("",gcdOfStrings("LEET", "CODE"));
    }

    @Test
    void gcdOfStringsCase4() {
        assertEquals("TAUXX",gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }
}