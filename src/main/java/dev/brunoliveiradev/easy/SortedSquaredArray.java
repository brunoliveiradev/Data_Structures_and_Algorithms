package dev.brunoliveiradev.easy;

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

        int[] results = sortedSquaredArray(array);
        System.out.println(Arrays.toString(results));
    }

    // Time complexity: O(n log n) | Space Complexity: O(n) - where n is lenght of the input array

    /**
     * Return the sorted squared array
     * @param array int[]
     * @return sortedSquaredArray
     */
    public static int[] sortedSquaredArray(int[] array) {

        int[] tempArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i] * array[i];
        }

        Arrays.sort(tempArray);
        return tempArray;
    }

    // O(n) time | O(n) space - where n is the length of the input array
    // Note: this only works if the input array is ordered
    public static int[] sortedSquaredArrayV2(int[] array) {
        int[] sortedSquares = new int[array.length];

        int smallestValueIndex = 0;
        int largestValueIndex = array.length - 1;

        for (int i = array.length - 1; i >= 0; i--) {
            int smallerValue = array[smallestValueIndex];
            int largestValue = array[largestValueIndex];

            if (Math.abs(smallerValue) > Math.abs(largestValue)) {
                sortedSquares[i] = smallerValue * smallerValue;
                smallestValueIndex++;
            } else {
                sortedSquares[i] = largestValue * largestValue;
                largestValueIndex--;
            }
        }
        return sortedSquares;
    }
}