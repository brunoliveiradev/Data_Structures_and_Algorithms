package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class NonConstructibleChange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array 'coins': ");
        int n = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter the value for element %d: ", i + 1);
            int coin = sc.nextInt();

            while (coin < 0) {
                System.out.println("The value must be positive. Please enter a positive integer: ");
                coin = sc.nextInt();
            }
            coins[i] = coin;
        }

        int result = nonConstructibleChange(coins);
        System.out.println("The minimum amount of change that you cannot create is: " + result);
    }

    /**
     * Return the minimum amount of change that you cannot create based on the given int[] coins.
     * @param coins array of positive integers representing the values of coins
     * @return the minimum amount of change that you CANNOT create
     * @apiNote Time Complexity: O(n log(n)) | Space Complexity: O(1) - n is the number of coins
     */
    private static int nonConstructibleChange(int[] coins) {
        int amountChange = 1;
        Arrays.sort(coins);

        for (int coin : coins) {
            if (coin > amountChange) {
                return amountChange;
            }
            amountChange += coin;
        }

        return amountChange;
    }
}
