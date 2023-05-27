package dev.brunoliveiradev.hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBallons {

    /**
     * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
     * <p>
     * You can use each character in text at most once.
     * @param text string of lowercase English letters
     * @return Return the maximum number of instances that can be formed.
     * @apiNote  Time complexity: O(n) | Space complexity: O(1) - where n is the length of the input string.
     */
    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);

            if ("balloon".indexOf(letter) != -1) {
                frequency.put(letter, frequency.getOrDefault(letter, 0) + 1);
            }
        }

        return howManyBalloonsCanBeCreated(frequency);
    }

    private static int howManyBalloonsCanBeCreated(Map<Character, Integer> frequency) {
        int b = frequency.getOrDefault('b', 0);
        int a = frequency.getOrDefault('a', 0);
        int l = frequency.getOrDefault('l', 0) / 2;
        int o = frequency.getOrDefault('o', 0) / 2;
        int n = frequency.getOrDefault('n', 0);

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }


    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko")); // Should print 1
        System.out.println(maxNumberOfBalloons("loonbalxballpoon")); // Should print 2
        System.out.println(maxNumberOfBalloons("leetcode")); // Should print 0
    }

}
