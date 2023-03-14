package dev.brunoliveiradev.hashing.easy;

import java.util.HashMap;
import java.util.Scanner;

public class StringConstruct {

    /**
     * Given two strings return true if the first one can be constructed using the letters from the other.
     * Each letter can only be used once.
     * || Time Complexity O(n.m) | Space Complexity O(m)
     * @param ransomNote String
     * @param magazine String
     * @return boolean
     */
    private static boolean verifyIfCanConstruct(String ransomNote, String magazine) {
        for(int i = 0; i < ransomNote.length(); i++) {
            char letter = ransomNote.charAt(i);

            int matchingIndex = magazine.indexOf(letter);
            if (matchingIndex == -1) {
                return false;
            }
            magazine = magazine.substring(0, matchingIndex) + magazine.substring(matchingIndex + 1);
        }
        return true;
    }

    /**
     * Same as the previous method, but using HashMap under the hood.
     * || Time complexity O(m) | Space complexity O(1)
     * @param ransomNote String
     * @param magazine String
     * @return boolean
     */
    private static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()){
            return false;
        }

        HashMap<Character, Integer> magazineLetters = new HashMap<>();

        //interate to populate with mazagine letters
        for(int i = 0; i < magazine.length(); i++) {
            char charAt = magazine.charAt(i);

            int frequencyOfCurrentLetter = magazineLetters.getOrDefault(charAt, 0);
            magazineLetters.put(charAt, frequencyOfCurrentLetter + 1);
        }

        // Go over each ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {
            char charAt = ransomNote.charAt(i);

            int currentCount = magazineLetters.getOrDefault(charAt, 0);

            if(currentCount == 0) {
                return false;
            }
            magazineLetters.put(charAt, currentCount - 1);

        }
        return true;

    }


    public static void main(String[] args) {
        String ransomNote;
        String magazine;

        try (Scanner scanner = new Scanner(System.in)) {
            ransomNote = scanner.next().toLowerCase().trim();
            magazine = scanner.next().toLowerCase().trim();

            System.out.println("Output method 1: " + verifyIfCanConstruct(ransomNote, magazine));
            System.out.println("Output method 2: " + canConstruct(ransomNote, magazine));
        }
    }

}
