package dev.brunoliveiradev.arraysAndStrings.slidingWindow.medium;

import java.util.Scanner;

public class MaxCostWithEqualSubstring {

    /**
     * You are given two strings s and t of the same length and an integer maxCost.
     * You want to change s to t.
     * Changing the ith character of s to ith character of t costs |s[i] - t[i]| (i.e., the absolute difference between the ASCII values of the characters).
     * Return the maximum length of a substring of s that can be changed to be the same
     * as the corresponding substring of t with a cost less than or equal to maxCost.
     * If there is no substring from s that can be changed to its corresponding substring from t,
     * return 0.
     *
     * @param s       string argument
     * @param t       string argument
     * @param maxCost integer argument
     * @return int - maximum length of a substring
     * @apiNote Time Complexity: O(n) - n is the length of strings s and t | Space Complexity: O(n) - created auxiliar array.
     * O(1) would be achieved if we get the values on the fly
     * @implNote This problem can be reduced to finding the longest subarray such that
     * the sum of the elements in that subarray is less than maxCost
     */
    public static int equalSubstring(String s, String t, int maxCost) {
        int[] costToChange = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int valueOfS = s.charAt(i);
            int valueOfT = t.charAt(i);

            costToChange[i] = Math.abs(valueOfS - valueOfT);
        }

        // Now find the longest subarray <= maxCost, all costToChange[i] >= 0 (non-negative).
        int maxChanges = 0;
        int currentCostToChange = 0;
        int start = 0;

        // At each number, will add the number to the current window's sum
        for (int end = 0; end < costToChange.length; end++) {
            currentCostToChange += costToChange[end];

            // While the constraint is broken, remove the elements from the start (left) and increment the start
            while (currentCostToChange > maxCost) {
                currentCostToChange -= costToChange[start];
                start++;
            }
            // Given a subarray starting at left and ending at right, the length is right - left + 1
            maxChanges = Math.max(maxChanges, end - start + 1);
        }
        return maxChanges;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input values from the console
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int maxCost = scanner.nextInt();

        // Call the equalSubstring function and print the result
        int result = equalSubstring(s, t, maxCost);
        System.out.println(result);
    }
}
