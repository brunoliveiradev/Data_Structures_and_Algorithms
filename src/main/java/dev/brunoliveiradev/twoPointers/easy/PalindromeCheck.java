package dev.brunoliveiradev.twoPointers.easy;

import java.util.Scanner;

public class PalindromeCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();

        boolean isPalin = isPalindrome(inputString);

        if (isPalin) {
            System.out.println("The input string is a palindrome");
        } else {
            System.out.println("The input string is not a palindrome");
        }
    }

    /**
     * Returns a  boolean representing whether the string is a palindrome.
     * A palindrome is defined as a string that's written the same forward and backward.
     *
     * @param str input argument
     * @return boolean representing whether the string is a palindrome.
     * @apiNote Time Complexity: O(n) | Space Complexity: O(1).
     * @implNote Approach: It uses a two-pointer approach to compare the characters
     * of the input string from the start and the end, and retuns false if there is
     * a mimatch. If the entire string has been compared without finding any
     * mismatches, the function returns true, indicating that the input string
     * is a palindrome.
     */
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
