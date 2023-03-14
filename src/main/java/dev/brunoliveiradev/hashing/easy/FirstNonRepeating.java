package dev.brunoliveiradev.hashing.easy;

import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeating {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();

        int result = firstNonRepeatingCharacter(inputString);

        System.out.println("The first non repeated character is at the index: " + result);
    }

    /**
     * Takes in a string of lowercase English-alphabet letters and
     * returns the index of the first non-repeating character.
     *
     * @param string input argument
     * @return index of the string's first non-repeating character
     * @apiNote Time complexity: O(n) | Space complexity: O(1) - where n is the length of the input string.
     * @implNote The constant space is because the input string only has lowercase english-alphabet letters;
     * thus, our hash table will never have more than 26 characters frequencies.
     */
    public static int firstNonRepeatingCharacter(String string) {
        HashMap<Character, Integer> lettersFrequencies = new HashMap<>(string.length());

        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            lettersFrequencies.put(letter, lettersFrequencies.getOrDefault(letter, 0) + 1);

        }

        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);

            if (lettersFrequencies.get(letter) == 1) {
                return i;
            }
        }

        return -1;
    }
}
