package dev.brunoliveiradev.prefixSum.easy;

public class KRadiusSubarrayAverages {

    /**
     * You are given a 0-indexed array nums of n integers, and an integer k.
     * <p>
     * The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i, then the k-radius average is -1.
     * <p>
     * Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
     *
     * @param nums 0-indexed array nums
     * @param k    integer k, radius average parameter
     * @return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
     * @apiNote Time and Space compelxity: O(n) - where n is the number of elements in the nums array
     */
    public static int[] getAverages(int[] nums, int k) {
        // If k is 0, each number is its own average
        if (k == 0) return nums;

        long[] prefixSum = calculatePrefixSum(nums);
        int[] averages = calculateAveragesFromPrefixSum(nums, k, prefixSum);

        return averages;
    }

    private static long[] calculatePrefixSum(int[] nums) {
        long[] prefixSum = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = nums[i] + prefixSum[i];
        }
        return prefixSum;
    }

    private static int[] calculateAveragesFromPrefixSum(int[] nums, int k, long[] prefixSum) {
        int[] averages = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (canCalculateAverage(nums, i, k)) {
                averages[i] = calculateAverageForIndex(i, k, prefixSum);
            } else {
                averages[i] = -1;
            }
        }
        return averages;
    }

    private static boolean canCalculateAverage(int[] nums, int index, int radius) {
        return index >= radius && index < nums.length - radius;
    }

    private static int calculateAverageForIndex(int index, int radius, long[] prefixSum) {
        long sumOfElementsInRadius = prefixSum[index + radius + 1] - prefixSum[index - radius];
        int totalElementsInRadius = 2 * radius + 1;
        return (int) (sumOfElementsInRadius / totalElementsInRadius);
    }


    public static void main(String[] args) {
        testGetAverages();
    }

    private static void testGetAverages() {
        testWithInput(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3);
        testWithInput(new int[]{100000}, 0);
        testWithInput(new int[]{8}, 100000);
        testWithInput(new int[]{3, 6, 2, 8, 1, 4, 1, 5}, 2);
    }

    private static void testWithInput(int[] nums, int k) {
        int[] averages = getAverages(nums, k);
        printArray(averages);
        System.out.println();
    }

    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }

}
