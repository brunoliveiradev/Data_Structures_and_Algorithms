package dev.brunoliveiradev.arraysAndStrings.twoPointers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroes {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the lenght of the array: ");
        int lenght = Integer.parseInt(sc.next().trim());

        int[] array = new int[lenght];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter the " + i + "th element: ");
            array[i] = Integer.parseInt(sc.next().trim());
        }
        moveZeroes(array);
        System.out.println("Moved Zeroes to the last position: " + Arrays.toString(array));
    }

    /**
     * Moves the zeroes to the last positions in the array
     *
     * @param nums int array
     * @apiNote Time Complexity: O(n) - where n is the length of the input array nums
     * | Space Complexity: O(1)
     * @implNote This approach is also known as "Dutch National Flag Algorithm"
     * a well-known algorithm for sorting an array of 0s, 1s, and 2s.
     * It was originally designed by Edsger Dijkstra, a Dutch computer scientist, in the 1970s.
     */
    public static void moveZeroes(int[] nums) {
        if (nums.length == 1) return;

        int snowBallSize = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // if wee meet 0, the size increase;
                snowBallSize++;
            }
            // swap with the most left zero
            else if (snowBallSize > 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[i - snowBallSize] = temp;
            }
        }
    }

    /**
     * Moves the zeroes to the last positions in the array
     *
     * @param nums int array
     * @apiNote Time Complexity: O(n) - where n is the length of the input array nums
     * | Space Complexity: O(1)
     * @implNote Use the TwoPointers approach
     */
    public static void moveZeroesWithTwoPointers(int[] nums) {
        if (nums.length == 1) return;

        int right = 0;

        for (int left = 0; left < nums.length; left++) {
            if (nums[left] != 0) {
                swap(nums, left, right);
                right++;
            }
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
