package dev.brunoliveiradev.twoPointers.easy;

import java.util.Scanner;

public class ReversePrefixWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String word = scanner.nextLine();

        System.out.println("Enter a character:");
        char ch = scanner.nextLine().charAt(0);

        String result = reversePrefix(word, ch);
        System.out.println("Result: " + result);

        scanner.close();
    }

    /**
     * Given a 0-indexed string word and a character ch, reverse the segment of word that starts
     * at index 0 and ends at the index of the first occurrence of ch (inclusive).
     * If the character ch does not exist in word, do nothing.
     *
     * @param word String argument
     * @param ch   Character argument
     * @return String representation of word reversed if ch present in word
     * @apiNote Time complexity: O(n) | Space complexity O(1) - where n is the length of word
     * @implNote This method use two-pointers approach
     */
    private static String reversePrefix(String word, char ch) {
        if (word.length() == 1) return word;

        int left = 0;
        int right = word.indexOf(ch);

        char[] letters = word.toCharArray();

        while (left < right) {
            reverse(letters, left, right);
            left++;
            right--;
        }

        return new String(letters);
    }

    private static void reverse(char[] letters, int left, int right) {
        char temp = letters[left];
        letters[left] = letters[right];
        letters[right] = temp;
    }
}
