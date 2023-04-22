package dev.brunoliveiradev.hashing.easy;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    /**
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     *
     * @param nums int[] - All the numbers of nums are unique.
     * @return int - the missing number
     * @apiNote Time Complexity: O(n) | Space Complexity: O(n) - where n is the length of the input array
     * @implNote Solved using HashSet
     */
    public static int missingNumber(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int number : nums) {
            numbers.add(number);
        }

        for (int missingNumber = 0; missingNumber <= nums.length; missingNumber++) {
            if (!numbers.contains(missingNumber)) {
                return missingNumber;
            }
        }
        return -1;
    }

    /**
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     *
     * @param nums int[] - All the numbers of nums are unique.
     * @return int - the missing number
     * @apiNote Time Complexity: O(n) | Space Complexity: O(1) - where n is the length of the input array
     * @implNote Solved using Gauss' Formula
     */
    public static int missingNumberOptimized(int[] nums) {
        int expectedSum = 0;
        int actualSum = 0;

        // for can be replaced with Gauss' Formula
        // expectedSum = nums.length * (nums.length + 1) / 2;
        for (int i = 0; i <= nums.length; i++) {
            expectedSum += i;
        }

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        // create a function that call the method missingNumber and print the result
        int[] firstExample = {3, 0, 1};
        int[] secondExample = {0, 1};
        int[] thirdExample = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] fourExample = {0, 1, 2, 3};

        System.out.println("Expected 2, got: " + missingNumber(firstExample));
        System.out.println("Expected 2, got: " + missingNumber(secondExample));
        System.out.println("Expected 8, got: " + missingNumberOptimized(thirdExample));
        System.out.println("Expected 4, got: " + missingNumberOptimized(fourExample));
    }
}
