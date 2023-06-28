package dev.brunoliveiradev.hashing.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     *
     * @param nums integer array, -109 <= nums[i] <= 109, 1 <= nums.length <= 105
     * @return return true if any value appears at least twice in the array, and return false if every element is distinct
     * @apiNote Time and Space complexity O(n): in the worst case will be O(n) since we will need to transverse the
     * entire array and storage all elements.
     * @implNote Choose Set datastructures since only accept distinct elements, so once we try to add an existing
     * element the add will return false, meaning that is a know value.
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();

        for (int number : nums) {
            if (isNotDistinct(integerSet, number)) return true;
        }

        return false;
    }

    private static boolean isNotDistinct(Set<Integer> integerSet, int number) {
        return !integerSet.add(number);
    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 1};
        int[] input2 = {1, 2, 3, 4};
        int[] input3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println("Exptected true. Got: " + containsDuplicate(input1));
        System.out.println("Exptected false. Got:" + containsDuplicate(input2));
        System.out.println("Exptected true. Got: " + containsDuplicate(input3));
    }
}
