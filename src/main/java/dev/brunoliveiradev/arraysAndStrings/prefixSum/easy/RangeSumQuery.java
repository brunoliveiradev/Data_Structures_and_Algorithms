package dev.brunoliveiradev.arraysAndStrings.prefixSum.easy;

public class RangeSumQuery {

    class NumArray {

        private int[] prefixSum;

        public NumArray(int[] nums) {
            prefixSum = new int[nums.length + 1];
            // loop through each element in nums and compute the prefix sums
            for (int i = 0; i < nums.length; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
        }
        // the sum of elements between left and right, inclusive, is equal to the prefix sum at index right+1 minus the prefix sum at index left
        public int sumRange(int left, int right) {
            return prefixSum[right + 1] - prefixSum[left];
        }
    }


    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new RangeSumQuery().new NumArray(nums);

        // Compute and print the sum of the range [0, 2]
        int sum1 = obj.sumRange(0, 2);
        System.out.println("Sum of range [0, 2]: " + sum1); // expected output: 1

        // Compute and print the sum of the range [2, 5]
        int sum2 = obj.sumRange(2, 5);
        System.out.println("Sum of range [2, 5]: " + sum2); // expected output: -1

        // Compute and print the sum of the range [0, 5]
        int sum3 = obj.sumRange(0, 5);
        System.out.println("Sum of range [0, 5]: " + sum3); // expected output: -3
    }
}
