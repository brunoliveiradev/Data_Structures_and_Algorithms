package dev.brunoliveiradev.techniques;

public class TwoPointers {

    /**
     * TwoPointers checks if the given string is a palindrome using the two-pointers technique.
     * This technique compares characters from the beginning and end of the string, moving
     * towards the center. If all characters match, the function returns true, indicating
     * the string is a palindrome; otherwise, it returns false.
     * <p>
     * Time Complexity: O(n) - where n is the length of the string.
     * Space Complexity: O(1) - constant space is used.
     *
     * @param s - Input string to check if it is a palindrome.
     * @return boolean - true if the string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String s) {
        int left = 0; // left pointer starts at the beginning of the string
        int right = s.length() - 1; // right pointer starts at the end of the string

        // Iterate until both pointers meet in the middle
        while (left < right) {
            // If characters do not match, it is not a palindrome
            if (s.charAt(left) != s.charAt(right)) {
                System.out.println(s + " is not a palindrome");
                return false;
            }
            // Move the pointers closer to the center
            left++;
            right--;
        }
        System.out.println(s + " is a palindrome");
        return true;
    }

    /**
     * TwoPointersSum checks if a sorted array has two numbers whose sum equals the target.
     * This method utilizes two pointers, one starting at the beginning and one at the end,
     * moving towards each other until the target sum is found or all possibilities are exhausted.
     * <p>
     * Time Complexity: O(n) - where n is the length of the array.
     * Space Complexity: O(1) - constant space is used.
     *
     * @param array     - Sorted array of integers.
     * @param targetSum - The target sum to find.
     * @return boolean - true if two numbers add up to the target, false otherwise.
     */
    public static boolean twoNumberSum(int[] array, int targetSum) {
        int left = 0; // left pointer starts at the first element
        int right = array.length - 1; // right pointer starts at the last element

        // Iterate until both pointers meet
        while (left < right) {
            int currentSum = array[left] + array[right];

            if (currentSum == targetSum) {
                System.out.println("Pair found: " + array[left] + " + " + array[right] + " = " + targetSum);
                return true;
            }

            if (currentSum < targetSum) {
                left++; // move left pointer to the right to increase the sum
            } else {
                right--; // move right pointer to the left to decrease the sum
            }
        }

        System.out.println("No pair found that sums to " + targetSum);
        return false;
    }

}
