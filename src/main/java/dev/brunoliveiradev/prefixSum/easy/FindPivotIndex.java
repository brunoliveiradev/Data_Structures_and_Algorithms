package dev.brunoliveiradev.prefixSum.easy;

public class FindPivotIndex {

    /**
     * Given an array of integers nums, calculate the pivot index of this array.
     * <p>
     * The pivot index is the index where the sum of all the numbers strictly to the left
     * of the index is equal to the sum of all the numbers strictly to the index's right.
     * <p>
     * If the index is on the left edge of the array, then the left sum is 0 because there are
     * no elements to the left. This also applies to the right edge of the array.
     * <p>
     * Return the leftmost pivot index. If no such index exists, return -1.
     * @param nums int array argument
     * @return Return the leftmost pivot index. If no such index exists, return -1.
     * @apiNote Time complexity: O(n) | Space Complexity: O(1) - where n is the length of the input array.
     * @implNote We can use a prefix sum array to solve this problem. But we can also use a single variable to keep track of the left sum.
     */
    public static int pivotIndex(int[] nums) {
        int pivotIdx = -1;
        int totalSum = 0;
        int leftSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            // Since we have already calculated the total sum of the array,
            // we can find the sum of the right side by subtracting the left sum
            // and the current element from the total sum.
            int rightSum = totalSum - leftSum - nums[i];

            if (rightSum == leftSum) {
                pivotIdx = i;
                break;
            } else {
                leftSum += nums[i];
            }
        }
        return pivotIdx;
    }

    public static void main(String[] args) {
        int[] firstExample = {1, 7, 3, 6, 5, 6};
        int[] secondExample = {1, 2, 3};
        int[] thirdExample = {2, 1, -1};

        System.out.println("Expect: 3, by calling the pivotIndex got: " + pivotIndex(firstExample));
        System.out.println("Expect:-1, by calling the pivotIndex got: " + pivotIndex(secondExample));
        System.out.println("Expect: 0, by calling the pivotIndex got: " + pivotIndex(thirdExample));
    }
}
