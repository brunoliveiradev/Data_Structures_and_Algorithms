package dev.brunoliveiradev.techniques;

/**
 * An extremaly common technique used to solve array and string problems.
 * It involves having two integers variables that both move along an iterable.
 * Usually named something like 'i' and 'j', or 'left' and 'right'
 * which each represent an index of the array of string.
 */
public class TwoPointers {

    // Time Complexity: O(n) | Space Complexity: O(1)
    private static void pseudoCode(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // do some logic here
            System.out.println("example");
            // do some more logic here to decide on one of the following:
            left++;
            right--;
            // or both
            left++;
            right--;
        }
    }

    /**
     * A string is a palindrome if it reads the same forwards as backwards.
     * That means, after reversing it, it is still the same string.
     * For example: "abcdcba", or "racecar".
     * @param input String
     * @return Return true if a given string is a palindrome, false otherwise.
     */
    // Time complexity: O(n) | Space Complexity: O(1)
    private static boolean isPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;

        while(left < right) {
            if(input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
