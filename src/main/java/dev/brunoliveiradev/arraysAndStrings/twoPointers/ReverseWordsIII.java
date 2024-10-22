package dev.brunoliveiradev.arraysAndStrings.twoPointers;

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
     * @apiNote Time complexity: O(N), where N is the length of the string.
     * Space complexity: O(N) due to the character array used for manipulation.
     */
    public static String reverseWords(String s) {
        if (s.length() == 1) return s;

        char[] chArray = s.toCharArray();
        int len = s.length();
        int wordStartIndex = 0;

        for (int i = 0; i <= len; i++) {
            boolean isEndOfWord = (i == len || chArray[i] == ' ');

            if (isEndOfWord) {
                int wordEndIndex = i - 1;
                reverseWord(chArray, wordStartIndex, wordEndIndex);
                wordStartIndex = i + 1;
            }
        }
        return new String(chArray);
    }

    private static void reverseWord(char[] characters, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            char temp = characters[startIndex];
            characters[startIndex] = characters[endIndex];
            characters[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
