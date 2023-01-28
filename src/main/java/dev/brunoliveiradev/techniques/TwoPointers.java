package dev.brunoliveiradev.techniques;

import dev.brunoliveiradev.easy.SortedSquaredArray;
import dev.brunoliveiradev.easy.TwoNumberSum;

import java.util.ArrayList;
import java.util.List;

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
     * @apiNote Time complexity: O(n) | Space Complexity: O(1)
     * @return Return true if a given string is a palindrome, false otherwise.
     */
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
     * Given as input a sorted array of unique integers and a target integer,
     * return true if there exists a pair of numbers that sum to target, false otherwise.
     *
     * @param array     int[]
     * @param targetSum int
     * @return boolean - true if exist or false otherwise
     * @apiNote Because the array is sorted, we can use two pointers to an O(n) time complexity and
     * constant space O(1).
     * If we use brute force to iterate over all pairs of integers this would result at
     * time complexity of O(n^2).
     * @see TwoNumberSum
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

    /**
     * The following method is applicable when the problem has two iterables in the input,
     * for example, two arrays.
     * We should move along both inputs simultaneously until all elements have been visited.
     */
    static class TwoPointerUseCaseAtTwoArray {

        private static void pseudoCode(int[] array, int[] anotherArray) {
            int i = 0; // create two pointers one for each interable, should start at the first index
            int j = 0;

            // Use a while loop until one of the pointers reaches the end of its iterable
            while (i < array.length && j < anotherArray.length) {
                //do some logic here depending on the problem
                // do some more logic here to decide on one of the following:
                i++; // This means incrementing either one of the pointers
                j++;  // or both of the pointers.
            }

            // Sometimes, we need to iterate through all elements
            while (i < array.length) {
                // do some logic
                i++;
            }
            while (j < anotherArray.length) {
                // do some logic here
                j++;
            }
        }

        /**
         * Given two sorted integer arrays as input, return an array that combines both of them
         * and is also sorted.
         *
         * @param array        int[]
         * @param anotherArray int[]
         * @return int[] - sorted Array that combines both
         * @apiNote Time Complexity: O(n) | Space complexity: O(1)
         * @see SortedSquaredArray
         */
        private static List<Integer> twoSortedArray(int[] array, int[] anotherArray) {
            //Start two pointers at the first index of each array
            // and create a result array that will recieve one element at time.
            List<Integer> result = new ArrayList<>(array.length + anotherArray.length);
            int arrayCurrentIndex = 0;
            int anotherArrayCurrentIndex = 0;

            // Use a while loop until one of the pointers reaches the end of its iterable.
            while (arrayCurrentIndex < array.length && anotherArrayCurrentIndex < anotherArray.length) {
                if (array[arrayCurrentIndex] < anotherArray[anotherArrayCurrentIndex]) {
                    result.add(array[arrayCurrentIndex]);
                    arrayCurrentIndex++;

                } else {
                    result.add(anotherArray[anotherArrayCurrentIndex]);
                    anotherArrayCurrentIndex++;
                }
            }

            // we need to iterate through all elements, so this make sure both iterables are exhausted
            while (arrayCurrentIndex < array.length) {
                result.add(array[arrayCurrentIndex]);
                arrayCurrentIndex++;
            }

            while (anotherArrayCurrentIndex < array.length) {
                result.add(array[anotherArrayCurrentIndex]);
                anotherArrayCurrentIndex++;
            }

            return result;
        }
    }


}
