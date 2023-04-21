package dev.brunoliveiradev.hashing.easy;

import java.util.HashSet;
import java.util.Set;

public class CheckIfPangram {

    /**
     * A 'pangram' is a sentence where every letter of the English alphabet appears at least once.
     * <p>
     * Given a string sentence containing only lowercase English letters,
     * return true if sentence is a pangram, or false otherwise.
     *
     * @param sentence string containing only lowercase English letters
     * @return true if sentence is a pangram, or false otherwise
     * @apiNote Time Complexity: O(n) | Space Complexity: O(1)
     * @implNote We use a hash set to store all the unique letters in sentence, and then we check if the size of the set is 26.
     */
    public static boolean checkIfPangram(String sentence) {
        Set<Character> seenLetters = new HashSet<>();

        for (char letter : sentence.toCharArray()) {
            seenLetters.add(letter);
        }

        return seenLetters.size() == 26;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("leetcode"));
    }
}
