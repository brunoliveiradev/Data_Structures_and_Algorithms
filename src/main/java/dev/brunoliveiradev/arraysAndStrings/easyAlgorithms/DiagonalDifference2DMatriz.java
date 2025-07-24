package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import java.util.List;

public class DiagonalDifference2DMatriz {

    /**
     * Calculates the absolute difference between the sums of the two diagonals
     * of a square matrix.
     *
     * @param arr A square matrix represented as a List of List of Integers (n x n).
     * @return The absolute difference between the left-to-right and right-to-left diagonal sums.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) — no extra space used except scalar accumulators.
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        int length = arr.size();
        // Index pointer for left-to-right diagonal (starts at 0,0)
        // Index pointer for right-to-left diagonal (starts at 0,n-1)
        int leftToRightDiagonal = 0, rightToLeftDiagonal = length-1, sumLeftToRightDiagonal = 0, sumRightToLeftDiagonal = 0;

        for (int row = 0; row < length; row++) {
            sumLeftToRightDiagonal += arr.get(row).get(leftToRightDiagonal++);
            sumRightToLeftDiagonal += arr.get(row).get(rightToLeftDiagonal--);
        }

        // Return absolute difference between the two sums
        return Math.abs(sumLeftToRightDiagonal - sumRightToLeftDiagonal);
    }
}
