package dev.brunoliveiradev.arraysAndStrings.twoPointers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SortedSquares {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the lenght of the array: ");
        int lenght = Integer.parseInt(scanner.next().trim());

        int[] array = new int[lenght];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter the " + i + "th element : ");
            array[i] = Integer.parseInt(scanner.next().trim());
        }
        scanner.close();

        int[] results = sortedSquares(array);
        System.out.println(Arrays.toString(results));
    }

    /**
     * Given a sorted int array as input, return the squared sorted array.
     *
     * @param nums int[]
     * @return squared and sorted int[]
     * @apiNote Time and Space complexity: O(n) - where n is the lenght of the input array
     * @see <a href="https://leetcode.com/problems/squares-of-a-sorted-array/solutions/3117877/java-clean-solution-using-two-pointers/">Solution</a>
     * @see SortedSquaredArray
     */
    public static int[] sortedSquares(int[] nums) {
        int smallIdx = 0;
        int maxIdx = nums.length - 1;

        int[] squared = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int smallest = nums[smallIdx];
            int largest = nums[maxIdx];

            if (Math.abs(smallest) > Math.abs(largest)) {
                squared[i] = smallest * smallest;
                smallIdx++;
            } else {
                squared[i] = largest * largest;
                maxIdx--;
            }
        }

        return squared;
    }
}