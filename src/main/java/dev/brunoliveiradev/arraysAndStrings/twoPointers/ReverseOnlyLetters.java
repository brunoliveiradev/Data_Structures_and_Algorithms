package dev.brunoliveiradev.arraysAndStrings.twoPointers;

import java.util.Scanner;

public class ReverseOnlyLetters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Reversed only the letters of the string: " + reverseOnlyLetters(input));
    }

    /**
     * Return the reversed string but all the characters that are not English letters remain in the same position
     * @param s input array
     * @return return the reversed string
     * @apiNote Time Complexity: O(n) | Space complexity: O(1) - where N is the size of the array.
     * @implNote This solution use TwoPointers approach to solve.
     */
    public static String reverseOnlyLetters(String s) {
        if (s.length() == 1) return s;

        int left = 0;
        int right = s.length() - 1;
        char[] letters = s.toCharArray();

        while (left < right) {
            if (isSymbol(letters[left])) {
                left++;
            } else if (isSymbol(letters[right])) {
                right--;
            } else {
                reverse(letters, left, right);
                left++;
                right--;
            }
        }
        return new String(letters);
    }

    /**
     * Return a boolean that check is a char isn't a letter (if it is a symbol).
     * @param c char input
     * @return true if a char 'c' is a Symbol (not a letter), false otherwise
     * @apiNote Time and Space complexity: O(1) - performs constant number of opertations
     */
    private static boolean isSymbol(char c) {
        return !Character.isLetter(c);
    }

    /**
     * Reverse the array, swaping elements using two pointer approach
     * @param arr input array
     * @param left left pointer
     * @param right right pointer
     * @apiNote Time and Space Complexity: O(1) - performs constant number of operations
     */
    private static void reverse(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
