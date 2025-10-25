package dev.brunoliveiradev.maps;

import java.util.ArrayList;
import java.util.List;

public class MergeTwo2DArrays {

    /**
     * Merges two 2D arrays by combining rows with the same key and summing their values.
     * If a key exists in only one of the arrays, its corresponding row will be included as is.
     *
     * @param nums1 the first 2D array where each row contains a key-value pair, order by ASC
     * @param nums2 the second 2D array where each row contains a key-value pair, order by ASC
     * @return a new 2D array containing merged rows sorted by key, with summed values for matching keys
     * @apiNote time: O(n+m)
     */
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0;
        List<int[]> mergedResult = new ArrayList<>(nums1.length + nums2.length);

        // Merge elements while both arrays have remaining elements
        while (i < nums1.length && j < nums2.length) {
            int key1 = nums1[i][0], value1 = nums1[i][1];
            int key2 = nums2[j][0], value2 = nums2[j][1];

            if (key1 == key2) {
                mergedResult.add(new int[]{key1, value1 + value2});
                i++;
                j++;
            } else if (key1 < key2) {
                mergedResult.add(new int[]{key1, value1});
                i++;
            } else {
                mergedResult.add(new int[]{key2, value2});
                j++;
            }
        }

        // Add remaining elements from both arrays
        addRemainingElements(nums1, i, mergedResult);
        addRemainingElements(nums2, j, mergedResult);

        return mergedResult.toArray(int[][]::new);
    }

    /**
     * Adds the remaining elements from the specified 2D array to the result list, starting
     * from a given index.
     *
     * @param array      the 2D array containing elements to add
     * @param startIndex the starting index in the array from which to add elements
     * @param result     the list to which the remaining elements will be added
     */
    private void addRemainingElements(int[][] array, int startIndex, List<int[]> result) {
        while (startIndex < array.length) {
            int key = array[startIndex][0];
            int value = array[startIndex][1];
            result.add(new int[]{key, value});
            startIndex++;
        }
    }


}
