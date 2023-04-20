package dev.brunoliveiradev.hashing.easy;

import java.util.HashSet;
import java.util.Set;

public class FirstLetterToRepeat {

    public static void main(String[] args) {
        String firstExample = "leetcode";
        System.out.println("The first letter to repeat is: " + repeatedCharacter(firstExample));

        String secondExample = "abccbaacz";
        System.out.println("The first letter to repeat is: " + repeatedCharacter(secondExample));

    }

    /**
     * Given a string s consisting of lowercase English letters,
     * return the first letter to appear twice in s.
     *
     * @param s String - lowercase English letters. Must contain at least one letter that appears twice.
     * @return char - the first letter to appear twice in s
     * @apiNote Time Complexity: O(n) | Space Complexity: O(1)
     * @implNote We use a hash table to store the last index of each character.
     */
    private static char repeatedCharacter(String s) {
        Set<Character> lastSeen = new HashSet<>();

        for (int index = 0; index < s.length(); index++) {
            char letter = s.charAt(index);
            if (lastSeen.contains(letter)) {
                return letter;
            }

            lastSeen.add(letter);
        }

        return ' ';
    }

}
