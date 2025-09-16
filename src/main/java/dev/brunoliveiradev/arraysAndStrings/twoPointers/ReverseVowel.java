package dev.brunoliveiradev.arraysAndStrings.twoPointers;

import java.util.Set;

public class ReverseVowel {
    /**
     * <p>Reverses only the vowels in the given string and returns the resulting string.</p>
     *
     * <p>The vowels are 'a', 'e', 'i', 'o', and 'u' and can appear in both lower- and upper-case.</p>
     *
     * <p>Constraints:</p>
     * <ul>
     *   <li>1 <= s.length <= 3 * 10^5</li>
     *   <li>s consists of printable ASCII characters</li>
     * </ul>
     *
     * @param s the input string
     * @return a new string with only the vowels reversed; non-vowel characters remain in their original positions
     * @apiNote Big(O): O(n) time complexity, O(1) extra space (excluding the output array).
     */
    public static String reverseVowels(String s) {
        if (s == null || s.length() < 2) return s;

        final Set<Character> VOWELS = Set.of(
                'a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U'
        );

        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        // Two pointers
        while (left < right) {
            // find the first vowel at left and the last vowel at right
            while (left < right && !VOWELS.contains(chars[left])) left++;
            while (left < right && !VOWELS.contains(chars[right])) right--;

            // swap
            if (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
