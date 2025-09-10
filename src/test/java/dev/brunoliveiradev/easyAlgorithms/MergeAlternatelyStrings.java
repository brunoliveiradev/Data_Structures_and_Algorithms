package dev.brunoliveiradev.easyAlgorithms;

public class MergeAlternatelyStrings {

    // Given two strings word1 and word2.
    // Merge the strings by adding letters in alternating order, starting with word1.
    // If a string is longer than the other, append the additional letters onto the end of the merged string.
    // Return the merged string.
    // Big(O) = O(n + m) time complexity and O(n + m) space complexity
    public String mergeAlternately(String word1, String word2) {
        int counterWord1 = 0;
        int counterWord2 = 0;
        StringBuilder merged = new StringBuilder(word1.length() + word2.length());

        while(counterWord1 < word1.length() && counterWord2 < word2.length()) {
            merged.append(word1.charAt(counterWord1++));
            merged.append(word2.charAt(counterWord2++));
        }
        // leftovers
        while (counterWord1 < word1.length()) {
            merged.append(word1.charAt(counterWord1++));
        }
        // leftovers
        while (counterWord2 < word2.length()) {
            merged.append(word2.charAt(counterWord2++));
        }

        return merged.toString();
    }
}
