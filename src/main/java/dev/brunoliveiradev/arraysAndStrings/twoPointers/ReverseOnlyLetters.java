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
     * @implNote This solution uses the Two Pointers approach to solve.
     *
     * Additional note: The space complexity is (O(1)) because the function uses a constant amount of extra space regardless of the input size. The char[] letters array is a direct transformation of the input string and does not count towards extra space complexity. The only additional space used is for a few variables (left, right, and temp), which do not scale with the input size.
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
     * Return a boolean that checks if a char isn't a letter (if it is a symbol).
     * @apiNote Time and Space complexity: O(1) - performs a constant number of operations
     */
    private static boolean isSymbol(char c) {
        return !Character.isLetter(c);
    }

    /**
     * Reverse the array, swapping elements using two pointer approach
     * Time and Space Complexity: O(1) - performs constant number of operations
     */
    private static void reverse(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
