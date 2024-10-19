package dev.brunoliveiradev.arraysAndStrings.twoPointers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SortedSquaredArray {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next().trim());

        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(scanner.next().trim());
        }
        scanner.close();

        int[] results = sortedSquares(array);
        System.out.println(Arrays.toString(results));
    }

    /**
     * Given as input a sorted array return the sorted squared array
     *
     * @param nums int[]
     * @return int[] sorted array
     * @apiNote O(n) time | O(n) space - where n is the length of the input array
     */
    public static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1, curr = nums.length - 1;
        int[] answer = new int[nums.length];

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                answer[curr--] = nums[left] * nums[left];
                left++;
            } else {
                answer[curr--] = nums[right] * nums[right];
                right--;
            }
        }

        return answer;
    }

}