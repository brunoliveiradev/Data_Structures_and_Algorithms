package dev.brunoliveiradev.twoPointers.easy;

public class PalindromeNumber {

    // Given an integer x, return true if x is a palindrome, and false otherwise.
    // This solution takes the "two pointers" approach to turn the int into a char array and with that compares the
    // first element with the last element to check if it is a palindrome number.
    //
    // This run is O(n) space and time complexity. Where N is the number of digits in X, and due to the auxiliary space created to compare the number.
    public boolean isPalindromeNumber(int x) {
        char[] intToCharArray = String.valueOf(x).toCharArray();

        int left = 0;
        int right = intToCharArray.length - 1;

        while (left < right) {
            if (intToCharArray[left] != intToCharArray[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
