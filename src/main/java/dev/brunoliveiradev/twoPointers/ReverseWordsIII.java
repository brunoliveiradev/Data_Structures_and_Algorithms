package dev.brunoliveiradev.twoPointers;

import java.util.Scanner;

public class ReverseWordsIII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Reversed string: " + reverseWords(input));
    }

    /**
     * Given a string s, reverse the order of characters in each word within
     * a sentence while still preserving whitespace and initial word order.
     *
     * @param s String - Constraints:
     *          String with at least one word, does not contain any leading
     *          or trailing spaces, and contais printable ASCII characters.
     *          All the words in s are separated by a single space.
     * @return String with reversed words.
     * @apiNote Time complexity: O(N) | Space complexity O(1) |
     * Solved using TwoPointers approach. Finding the starting and ending position
     * of each word in the string. For each identified word, reverse the characters
     * of the word one by one.
     */
    public static String reverseWords(String s) {
        if (s.length() == 1) return s;

        char[] chArray = s.toCharArray();
        int lastSpaceIndex = -1;
        int len = s.length();

        for (int i = 0; i <= len; i++) {
            if (i == len || chArray[i] == ' ') {
                int startIndex = lastSpaceIndex + 1;
                int endIndex = i - 1;

                reverse(chArray, startIndex, endIndex);
                lastSpaceIndex = i;
            }
        }
        return new String(chArray);
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
