package dev.brunoliveiradev.arraysAndStrings.prefixSum.medium;

/**
 * This class provides a method to calculate the k-radius averages of a given array.
 */
public class KRadiusSubarrayAverages {

    /**
     * Calculates the k-radius averages for a given array using the prefix sum technique.
     * <p>
     * A k-radius average is the average of the elements within a subarray centered at index i,
     * spanning from index i-k to i+k (inclusive). If there are fewer than k elements before
     * or after the index i, the result for that index is set to -1.
     * <p>
     * The function uses a prefix sum array to efficiently calculate the sum of each subarray
     * in constant time, avoiding the need to repeatedly sum overlapping subarrays.
     * <p>
     * Time complexity: O(n), where n is the length of the array. We compute the prefix sum in O(n)
     * and use it to calculate each k-radius average in constant time.
     * <p>
     * Space complexity: O(n), as we store the prefix sum array of size n+1 and the result array of size n.
     *
     * @param nums the input array of integers
     * @param k    the radius for the subarray around each index
     * @return an array of k-radius averages, or -1 where the average cannot be calculated
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

        // Calculate the prefix sum array where prefix[i] is the sum of elements from index 0 to i-1
        long[] prefixSum = new long[n + 1];  // n+1 to handle the 0-based index
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Now, calculate the averages using the prefix sum array
        for (int i = k; i < n - k; i++) {
            long sum = prefixSum[i + k + 1] - prefixSum[i - k];  // sum of subarray from (i-k) to (i+k)
            averages[i] = (int) (sum / (2 * k + 1));  // Calculate the average
        }

        // Set the boundaries where the average cannot be calculated to -1
        for (int i = 0; i < k; i++) {
            averages[i] = -1;
        }
        for (int i = n - k; i < n; i++) {
            averages[i] = -1;
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
