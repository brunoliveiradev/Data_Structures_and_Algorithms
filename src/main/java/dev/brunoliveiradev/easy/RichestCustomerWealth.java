package dev.brunoliveiradev.easy;

import java.util.Scanner;

public class RichestCustomerWealth {

    /**
     * Given an m x n integer grid accounts where accounts[i][j] is the amount of money the i-th customer
     * has in the j-th bank. Sum the amount of money of each costumer in all their bank accounts and return
     * the maximum sum element in array.
     * @param accounts
     * @return maximum element in array after sum of each [i] in [j].
     */
    private static int maximumWealth(int[][] accounts) {


        return 0;
    }

    public static void main(String[] args) {
        int m = 0;
        int n = 0;
        int[][] array = null;
        StringBuilder results = new StringBuilder();

        // Read the values for each row
        try (Scanner scanner = new Scanner(System.in)) {
            m = scanner.nextInt();
            n = scanner.nextInt();

            // Check if the size of the array is within the specified constraints
            if (m < 1 || m > 50 || n < 1 || n > 50) {
                results.append("Invalid array size");
                return;
            }

            array = new int[m][n];

            // Read the values for each row
            for (int i = 0; i < m; i++) {
                // Read the values for the current row
                for (int j = 0; j < n; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }
        } catch (NumberFormatException e) {
            results.append("Invalid number of values in row");
            return;
        }
        results.append(maximumWealth(array));

        System.out.println(results);
    }

}
