package dev.brunoliveiradev.hashing.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckEqualOccurrences {

    public static void main(String[] args) {
        String firstExample = "abacbc";
        System.out.println("Example 1: abacbc. The string has equal occurrences of a and b: " + checkEqualOccurrences(firstExample));

        String secondExample = "aaabb";
        System.out.println("Example 2: aaabb. The string has equal occurrences of a and b: " + checkEqualOccurrences(secondExample));

    }

    /**
     * Given a string s containing only lowercase English letters,
     * return true if s has equal frequency of all the characters that appear in s.
     *
     * @param s String - lowercase English letters.
     * @return boolean - true if s has equal frequency of all the characters that appear in s
     * @apiNote Time Complexity: O(n) | Space Complexity: O(n) - where n is the length of the input string.
     * @implNote We use a hash map to store the frequency of each character. And then we use a hash set to see if all the frequencies are the same.
     */
    private static boolean checkEqualOccurrences(String s) {
        Map<Character, Integer> counts = new HashMap<>();

        // count the occurrences of each letter
        for (char currentLetter : s.toCharArray()) {
            counts.put(currentLetter, counts.getOrDefault(currentLetter, 0) + 1);
        }

        // since set does not allow duplicates, if the size of the set is 1, it means that all the letters have the same frequency
        Set<Integer> frequencies = new HashSet<>(counts.values());
        return frequencies.size() == 1;
    }

}
