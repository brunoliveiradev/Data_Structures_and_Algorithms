package dev.brunoliveiradev.hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {

    /**
     * We were given a 2D grid (a square matrix), and we needed to find out how many rows in this grid are exactly the same as some column.
     * @param grid 2D integer array matrix
     * @return how many rows in this grid are exactly the same as some column
     * @apiNote Time Compelxity: O(n^2) | Space Compelxity: O(n)
     */
    public static int equalPairs(int[][] grid) {
        Map<String, Integer> frequencyRow = new HashMap<>();
        Map<String, Integer> frequencyColumn = new HashMap<>();
        int answer = 0;

        // Convert each row to a key and count the frequency of each key
        for (int[] row : grid) {
            String key = convertToKey(row);
            frequencyRow.put(key, frequencyRow.getOrDefault(key, 0) + 1);
        }

        // Convert each column to a key and count the frequency of each key
        for (int col = 0; col < grid[0].length; col++) {
            int[] currentCol = new int[grid.length];

            for (int row = 0; row < currentCol.length; row++) {
                currentCol[row] = grid[row][col];
            }

            String key = convertToKey(currentCol);
            frequencyColumn.put(key, frequencyColumn.getOrDefault(key, 0) + 1);
        }

        // For each key in frequencyRow, find the corresponding key in frequencyColumn and multiply the frequencies
        for (String key : frequencyRow.keySet()) {
            answer += frequencyRow.get(key) * frequencyColumn.getOrDefault(key, 0);
        }

        return answer;
    }

    private static String convertToKey(int[] array) {
        StringBuilder sb = new StringBuilder();

        for (int j : array) {
            sb.append(j);
            sb.append(",");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {3, 2, 1},
                {1, 7, 6},
                {2, 7, 7}
        };
        System.out.println(equalPairs(grid1));  // Output: 1

        int[][] grid2 = {
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        };
        System.out.println(equalPairs(grid2));  // Output: 3
    }


}
