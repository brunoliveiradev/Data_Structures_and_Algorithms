package dev.brunoliveiradev.hashing.easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    /**
     * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
     * <p>
     * Each letter in magazine can only be used once in ransomNote.
     *
     * @param ransomNote string
     * @param magazine   string
     * @return return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
     * @apiNote Time Complexity: O(n) | Space Complexity: O(1) - because the space is never more than 26, which is a constant, it'd be reasonable to say that this algorithm requires O(1) space.
     * @implNote Solved using two HashMaps, can be optimized to one HashMap, but I keep it to two to improve readability of the code.
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        Map<Character, Integer> ransomFrequency = getFrequencyMap(ransomNote);
        Map<Character, Integer> magazineFrequency = getFrequencyMap(magazine);

        for (Character key : ransomFrequency.keySet()) {
            if (!magazineFrequency.containsKey(key) || ransomFrequency.get(key) > magazineFrequency.get(key)) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character, Integer> getFrequencyMap(String s) {
        Map<Character, Integer> frequency = new HashMap<>();

        for (char key : s.toCharArray()) {
            frequency.put(key, frequency.getOrDefault(key, 0) + 1);
        }
        return frequency;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));  // Expected: false
        System.out.println(canConstruct("aa", "ab"));  // Expected: false
        System.out.println(canConstruct("aa", "aab"));  // Expected: true
    }
}



