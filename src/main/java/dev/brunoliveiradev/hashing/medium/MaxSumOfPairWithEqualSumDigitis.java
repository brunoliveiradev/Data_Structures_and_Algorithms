package dev.brunoliveiradev.hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfPairWithEqualSumDigitis {

    /**
     * Given an array of integers nums, find the maximum value of nums[i] + nums[j], where nums[i] and nums[j] have the same digit sum (the sum of their individual digits).
     *
     * @param nums positive integer array
     * @return Return -1 if there is no pair of numbers with the same digit sum.
     * @apiNote Time complexity and Space complexity is O(n)
     */
    private static int maximumSum(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int answer = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);

            if (hashMap.containsKey(digitSum)) {
                answer = Math.max(answer, num + hashMap.get(digitSum));
            }

            hashMap.put(digitSum, Math.max(hashMap.getOrDefault(digitSum, 0), num));
        }

        return answer;
    }

    private static int getDigitSum(int num) {
        int digitsum = 0;

        while (num != 0) {
            digitsum += num % 10;
            num /= 10;
        }
        return digitsum;
    }

    public static void main(String[] args) {
        int[] nums1 = {18, 43, 36, 13, 7};
        System.out.println(maximumSum(nums1));  // Expected output: 54

        int[] nums2 = {10, 12, 19, 14};
        System.out.println(maximumSum(nums2));  // Expected output: -1
    }
}
