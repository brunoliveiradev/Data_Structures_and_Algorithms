package dev.brunoliveiradev.prefixSum.medium;

/**
 * This class provides a method to calculate the k-radius averages of a given array.
 */
public class KRadiusSubarrayAverages {

    /**
     * Calculates the k-radius averages for a given array.
     *
     * @param nums 0-indexed array of integers
     * @param k    integer k, radius average parameter
     * @return an array of integers where each element is the k-radius average for the corresponding subarray centered at that index
     * @apiNote Time and Space complexity: O(n) - where n is the number of elements in the nums array
     */
    public static int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] averages = new int[n];

        // If k is 0, return the original array as the result
        if (k == 0) return nums;

        // If it's not possible to calculate the average for any index, which means if K is too large
        if (2 * k + 1 > n) {
            // Then all elements will be set to -1
            for (int i = 0; i < n; i++) {
                averages[i] = -1;
            }
            return averages;
        }

        // Calculate the prefix sum efficiently (sliding window sum)
        long prefixSum = 0;
        // Initially, set all elements to -1 where the average cannot be calculated
        for (int i = 0; i < n; i++) {
            averages[i] = -1;
        }

        // Sum the first (2*k + 1) elements that can form an average
        for (int i = 0; i < 2 * k + 1; i++) {
            prefixSum += nums[i];
        }

        // Now, process from index k to n - k - 1
        for (int i = k; i < n - k; i++) {
            if (i != k) {
                // Update the sliding window sum by removing the oldest value and adding the new one
                prefixSum = prefixSum - nums[i - k - 1] + nums[i + k];
            }
            averages[i] = (int) (prefixSum / (2 * k + 1));
        }

        return averages;
    }

    /**
     * Main method to run test cases.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        testGetAverages();
    }

    /**
     * Runs test cases for the getAverages method.
     */
    private static void testGetAverages() {
        testWithInput(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3);
        testWithInput(new int[]{100000}, 0);
        testWithInput(new int[]{8}, 100000);
        testWithInput(new int[]{3, 6, 2, 8, 1, 4, 1, 5}, 2);
    }

    /**
     * Tests the getAverages method with the given input and prints the result.
     *
     * @param nums the input array of integers
     * @param k    the radius
     */
    private static void testWithInput(int[] nums, int k) {
        int[] averages = getAverages(nums, k);
        printArray(averages);
        System.out.println();
    }

    /**
     * Prints the given array.
     *
     * @param arr the array to print
     */
    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }

}
