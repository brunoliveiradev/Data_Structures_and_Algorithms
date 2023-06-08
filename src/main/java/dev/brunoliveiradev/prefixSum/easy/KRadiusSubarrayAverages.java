package dev.brunoliveiradev.prefixSum.easy;

public class KRadiusSubarrayAverages {

    public static int[] getAverages(int[] nums, int k) {
        if (k == 0) return nums;

        long[] prefixSum = runningSum(nums);
        int[] averages = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i >= k && i < nums.length - k) {
                long sum = prefixSum[i + k + 1] - prefixSum[i - k];
                int totalElements = (2 * k + 1);

                averages[i] = (int) (sum / totalElements);

            } else {
                averages[i] = -1;
            }
        }

        return averages;
    }

    private static long[] runningSum(int[] nums) {
        long[] prefixSum = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = nums[i] + prefixSum[i];
        }
        return prefixSum;
    }


    public static void main(String[] args) {
        int[] nums1 = {7, 4, 3, 9, 1, 8, 5, 2, 6};
        int[] nums2 = {100000};
        int[] nums3 = {8};

        int[] avgs1 = getAverages(nums1, 3);
        int[] avgs2 = getAverages(nums2, 0);
        int[] avgs3 = getAverages(nums3, 100000);

        // Print the arrays
        printArray(avgs1);
        System.out.println();
        printArray(avgs2);
        System.out.println();
        printArray(avgs3);
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
