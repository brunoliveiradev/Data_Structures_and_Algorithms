package dev.brunoliveiradev.arraysAndStrings.twoPointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseOnlyLettersTest {

    @Test
    void reverseOnlyLetters() {
        String input = "ab-cd";
        String expected = "dc-ba";
        assertEquals(expected, ReverseOnlyLetters.reverseOnlyLetters(input), "Should be dc-ba");

        input = "a-bC-dEf-ghIj";
        expected = "j-Ih-gfE-dCba";
        assertEquals(expected, ReverseOnlyLetters.reverseOnlyLetters(input), "Should be j-Ih-gfE-dCba");

        input = "Test1ng-Leet=code-Q!";
        expected = "Qedo1ct-eeLg=ntse-T!";
        assertEquals(expected, ReverseOnlyLetters.reverseOnlyLetters(input), "Should be Qedo1ct-eeLg=ntse-T!");
    }
}