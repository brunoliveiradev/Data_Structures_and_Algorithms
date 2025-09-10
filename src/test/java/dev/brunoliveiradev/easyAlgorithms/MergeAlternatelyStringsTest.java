package dev.brunoliveiradev.easyAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeAlternatelyStringsTest {

    private final MergeAlternatelyStrings sut = new MergeAlternatelyStrings();

    @Test
    void mergeEqualLength() {
        String result = sut.mergeAlternately("abc", "pqr");
        assertEquals("apbqcr", result);
    }

    @Test
    void word2Longer_suffixFromWord2() {
        String result = sut.mergeAlternately("ab", "pqrs");
        assertEquals("apbqrs", result);
    }

    @Test
    void word1Longer_suffixFromWord1() {
        String result = sut.mergeAlternately("abcd", "pq");
        assertEquals("apbqcd", result);
    }

    @Test
    void singleCharEach() {
        String result = sut.mergeAlternately("a", "z");
        assertEquals("az", result);
    }

    @Test
    void minimalVsLonger_word1Minimal() {
        String result = sut.mergeAlternately("a", "bcdef");
        assertEquals("abcdef", result);
    }

    @Test
    void minimalVsLonger_word2Minimal() {
        String result = sut.mergeAlternately("mnopq", "r");
        assertEquals("mrnopq", result);
    }

    @Test
    void repeatedLetters() {
        String result = sut.mergeAlternately("aaaa", "bbbbbb");
        assertEquals("ababababbb", result);
    }

    @Test
    void alternatingPatternPreserved() {
        String result = sut.mergeAlternately("xyz", "uvw");
        // x u y v z w
        assertEquals("xuyvzw", result);
        // sanity: tamanho = n+m
        assertEquals(6, result.length());
    }

    @Test
    void longButBalanced() {
        String a = "abcdefghijkl";
        String b = "mnopqrstuvwx";
        String result = sut.mergeAlternately(a, b);
        assertEquals(24, result.length());
        // primeiros 6 pares
        assertEquals("ambnco", result.substring(0, 6)); // a m b n c o
        // últimos 6 caracteres alternados
        assertEquals("vwx", b.substring(9, 12));
    }

    @Test
    void confirmsNoIndexOutOfBoundsWhenSizesDiffer() {
        assertDoesNotThrow(() -> sut.mergeAlternately("abc", "p"));
        assertEquals("apbc", sut.mergeAlternately("abc", "p"));
        assertDoesNotThrow(() -> sut.mergeAlternately("k", "xyz"));
        assertEquals("kxyz", sut.mergeAlternately("k", "xyz"));
    }
}