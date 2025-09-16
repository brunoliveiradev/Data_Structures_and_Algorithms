package dev.brunoliveiradev.arraysAndStrings.twoPointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static dev.brunoliveiradev.arraysAndStrings.twoPointers.ReverseVowel.*;
import static org.junit.jupiter.api.Assertions.*;

class ReverseVowelTest {

    @Test
    @DisplayName("Exemplo 1: IceCreAm -> AceCreIm")
    void reverseVowels_example1() {
        assertEquals("AceCreIm", reverseVowels("IceCreAm"));
    }

    @Test
    @DisplayName("Exemplo 2: leetcode -> leotcede")
    void reverseVowels_example2() {
        assertEquals("leotcede", reverseVowels("leetcode"));
    }

    @Test
    @DisplayName("Sem vogais: deve retornar igual")
    void reverseVowels_noVowels() {
        assertEquals("bcdfg", reverseVowels("bcdfg"));
    }

    @Test
    @DisplayName("Apenas vogais (maiúsculas e minúsculas): inversão total")
    void reverseVowels_onlyVowelsMixedCase() {
        String input = "aAeEiIoOuU";
        String expected = "UuOoIiEeAa";
        assertEquals(expected, reverseVowels(input));
    }

    @Test
    @DisplayName("String vazia")
    void reverseVowels_empty() {
        assertEquals("", reverseVowels(""));
    }

    @Test
    @DisplayName("Um caractere")
    void reverseVowels_singleChar() {
        assertEquals("x", reverseVowels("x"));
        assertEquals("a", reverseVowels("a")); // vogal única permanece
    }

    @Test
    @DisplayName("Null deve retornar null (contrato do método)")
    void reverseVowels_null() {
        assertNull(reverseVowels(null));
    }

    @Test
    @DisplayName("Dígitos e símbolos permanecem: apenas vogais são trocadas")
    void reverseVowels_digitsAndSymbols() {
        assertEquals("H3ll0 W0rld!", reverseVowels("H3ll0 W0rld!")); // apenas 'o','o' -> inversão não muda
        assertEquals("C0d!ng *Is* fUn?", reverseVowels("C0d!ng *Us* fIn?"));
        //            vogais: U, I  -> invertidas
    }

    @Test
    @DisplayName("Reversão é involutiva: aplicar duas vezes retorna original")
    void reverseVowels_involutiveProperty() {
        String[] samples = {
                "IceCreAm",
                "leetcode",
                "aA",
                "bcdfg",
                "The quick brown fox jumps over the lazy dog"
        };
        for (String s : samples) {
            assertEquals(s, reverseVowels(reverseVowels(s)));
        }
    }

}