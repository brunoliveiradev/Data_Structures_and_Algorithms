package dev.brunoliveiradev.arraysAndStrings.slidingWindow.medium;

import java.util.Scanner;

public class MaxVowelsInSubString {

    /**
     * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
     *
     * @param s String input that consists of lowercase English letters.
     * @param k int argument that represent the window size
     * @return int - Maximum Number of Vowels in a Substring of Given Length
     * @apiNote Time Complexity: O(n), where n is the length of the string s.
     * Space Complexity: O(1), as the space used is constant.
     * Solved using sliding window technique.
     */
    public static int maxVowels(String s, int k) {
        //
        int vowelCount = 0;
        int maxVowels = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                vowelCount++;
            }
            // if constraint is broken (i >= k), the function checks if the character at the left end of the window is a vowel
            // If so, the variable vowelCount is decremented by one to account for the removal of that character from the window.
            if (i >= k && isVowel(s.charAt(i - k))) {
                vowelCount--;
            }
            maxVowels = Math.max(maxVowels, vowelCount);
        }
        return maxVowels;
    }

    private static boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = scanner.nextLine();

        System.out.print("Enter a window size: ");
        int k = scanner.nextInt();

        int max = maxVowels(s, k);
        System.out.println("Max number of vowels in any window of size " + k + " is " + max);
    }
}
