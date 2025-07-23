package dev.brunoliveiradev.techniques;

/**
 * A class that implements the Merge Sort algorithm for sorting arrays of long integers.
 * Includes a helper method to generate random arrays for testing purposes.
 */
public class MergeSortAlgorithm {

    /**
     * Generates a random array of long integers within a specified size and value range.
     *
     * @param sizeOfArray The size of the array to generate.
     * @param minValue The minimum value for the random numbers.
     * @param maxValue The maximum value for the random numbers.
     * @return A long[] array containing random numbers within the specified range.
     * @throws IllegalArgumentException if maxValue is less than or equal to minValue, or if sizeOfArray is less than 1.
     */
    public static long[] generateRandomArray(int sizeOfArray, int minValue, int maxValue) {
        if (maxValue < minValue) {
            throw new IllegalArgumentException("maxValue must be greater than minValue");
        } else if (maxValue == minValue) {
            throw new IllegalArgumentException("maxValue must be greater than minValue");
        } else if (sizeOfArray < 1) {
            return new long[]{};
        }

        long[] numbers = new long[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            numbers[i] = minValue + (long) (Math.random() * (maxValue - minValue + 1));
        }

        return numbers;
    }


    /**
     * Sorts a given array of long integers using the Merge Sort algorithm.
     *
     * @param inputArray The array to be sorted.
     *
     * @apiNote  Time Complexity: O(n log n), where n is the size of the array.
     * Space Complexity: O(n), due to the creation of temporary arrays.
     */
    public static void mergeSort(long[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return; // Base case: array is already sorted
        }

        // Divide the array into two new arrays using the middle index as reference
        int midIndex = inputLength / 2;
        long[] leftHalf = new long[midIndex];
        long[] rightHalf = new long[inputLength - midIndex];

        // Copy the elements between 0 and midIndex from inputArray to the leftHalf array
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }

        // Copy the elements from midIndex till the last element of the inputArray to the rightHalf
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        }

        // Recursively divide both halves
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // Merge sorted halves back into the original array
        merge(inputArray, leftHalf, rightHalf);
    }

    // helper function that merges two sorted arrays into a single sorted array.
    private static void merge(long[] inputArray, long[]leftHalf, long[] rightHalf) {
        int leftLength = leftHalf.length;
        int rightLength = rightHalf.length;

        // "i" is for leftHalf, "j" is for rightHalf, "k" is for inputArray
        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k++] = leftHalf[i++]; // Insert and increment after insertion
            } else {
                inputArray[k++] = rightHalf[j++];
            }
        }

        // Copy remaining elements from leftHalf
        while (i < leftLength) {
            inputArray[k++] = leftHalf[i++];
        }

        // Copy remaining elements from rightHalf
        while (j < rightLength) {
            inputArray[k++] = rightHalf[j++];
        }
    }

}
