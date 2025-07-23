package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import dev.brunoliveiradev.techniques.MergeSortAlgorithm;

public class FindMedian {

    /**
     * Calculates the median of an array of integers.
     *
     * The median is the central value in a sorted list of numbers. If the list has an odd number of elements,
     * the median is the middle element. If the list has an even number of elements, the median is the average
     * of the two middle elements.
     *
     * @param inputArray An unsorted array of integers.
     * @return The median value of the input array.
     * @throws IllegalArgumentException if the array is empty.
     *
     * @apiNote Time Complexity: O(n log n) due to sorting the array, where n is the length of the input array.
     * Space Complexity: O(n) for the sorting algorithm used (Merge Sort).
     */
    public static long FindMedian(long[] inputArray) {
        int length = inputArray.length;
        if (length == 0) {
            throw new IllegalArgumentException("The array cannot be empty.");
        }
        if (length == 1) {
            return inputArray[0];
        }

        // Sorts the array before calculating the median
        MergeSortAlgorithm.mergeSort(inputArray);

        int mid = length / 2;
        if (length % 2 == 0) {
            return (inputArray[mid - 1] + inputArray[mid]) / 2; // Correctly calculates the average of the two middle values
        } else {
            return inputArray[mid];
        }
    }

}
