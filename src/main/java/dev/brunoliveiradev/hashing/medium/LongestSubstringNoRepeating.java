package dev.brunoliveiradev.hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeating {

    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     *
     * @param s String s consists of English letters, digits, symbols and spaces.
     * @return length of the longest substring without repeating characters.
     * @apiNote Time and Space complexity: O(n) - where n is the length  of the string.
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        Map<Character, Integer> indexMap = new HashMap<>(s.length());
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            if (indexMap.containsKey(currentChar)) {
                start = Math.max(start, indexMap.get(currentChar) + 1);
            }

            indexMap.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "abcabcbb";
        System.out.println("Example 1: \nInput: s = " + s1);
        System.out.println("Output: " + lengthOfLongestSubstring(s1));
        System.out.println("Expected: 3\n");

        // Example 2
        String s2 = "bbbbb";
        System.out.println("Example 2: \nInput: s = " + s2);
        System.out.println("Output: " + lengthOfLongestSubstring(s2));
        System.out.println("Expected: 1\n");

        // Example 3
        String s3 = "pwwkew";
        System.out.println("Example 3: \nInput: s = " + s3);
        System.out.println("Output: " + lengthOfLongestSubstring(s3));
        System.out.println("Expected: 3\n");
    }
}
