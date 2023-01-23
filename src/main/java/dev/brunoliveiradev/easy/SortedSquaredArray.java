package dev.brunoliveiradev.easy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SortedSquaredArray {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next().trim());

        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(scanner.next().trim());
        }
        scanner.close();

        int[] results = sortedSquaredArray(array);
        System.out.println(Arrays.toString(results));
    }

    // Is not the optimal solution: Time complexity: O(n log n) | Space Complexity: O(n) - where n is lenght of the input array
    public static int[] sortedSquaredArray(int[] array) {

        int[] tempArray = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            tempArray[i] = array[i] * array[i];
        }

        Arrays.sort(tempArray);
        return tempArray;
    }

}
