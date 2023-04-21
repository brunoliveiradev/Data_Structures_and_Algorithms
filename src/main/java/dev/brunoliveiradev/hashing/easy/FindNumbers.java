package dev.brunoliveiradev.hashing.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindNumbers {

    /**
     * Given an integer array nums, find all the numbers x that satisfy the following:
     * x + 1 is not in nums, and x - 1 is not in nums.
     *
     * @param nums - int[]
     * @return List of Integers - the numbers that satisfy the condition
     * @apiNote Time Complexity: O(n) | Space Complexity: O(n) - where n is the length of the input array
     * @implNote Solved using Hashing
     */
    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : nums) {
            if (!numSet.contains(num + 1) && !numSet.contains(num - 1)) {
                answer.add(num);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // create a function that call the method findNumbers and print the result
        int[] nums = {1, 3, 5, 6, 7, 8};
        System.out.println(findNumbers(nums));
    }
}
