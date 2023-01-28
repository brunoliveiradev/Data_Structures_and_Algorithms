package dev.brunoliveiradev.techniques;

import dev.brunoliveiradev.easy.TwoNumberSum;

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
     *
     * @param input String
     * @return Return true if a given string is a palindrome, false otherwise.
     */
    // Time complexity: O(n) | Space Complexity: O(1)
    private static boolean isPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Given a sorted array of unique integers and a target integer,
     * return true if there exists a pair of numbers that sum to target, false otherwise.
     * Because the array is sorted, we can use two pointers to an O(n) time complexity and
     * constant space O(1).
     * If we use brute force to iterate over all pairs of integers this would result at
     * time complexity of O(n^2).
     *
     * @param array     int[]
     * @param targetSum int
     * @return boolean - true if exist or false otherwise
     * @apiNote The reason this alforithm works is that the numbers are sorted
     * @see TwoNumberSum This is similar to TwoNumberSum.
     */
    private static boolean twoNumberSumOfSortedArray(int[] array, int targetSum) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int currentElemnt = array[left] + array[right];

            if (currentElemnt == targetSum) {
                return true;
            }

            if (currentElemnt > targetSum) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

}
