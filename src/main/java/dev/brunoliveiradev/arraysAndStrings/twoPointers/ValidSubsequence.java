package dev.brunoliveiradev.arraysAndStrings.twoPointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Time Complexity: O(n) | Space: O(1) -- where n is the length of the array
public class ValidSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> array = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();

        System.out.println("Enter elements of the array, separated by spaces:");
        String[] arrayElements = scanner.nextLine().split(" ");
        for (String element : arrayElements) {
            array.add(Integer.parseInt(element));
        }

        System.out.println("Enter elements of the sequence, separated by spaces:");
        String[] sequenceElements = scanner.nextLine().split(" ");
        for (String element : sequenceElements) {
            sequence.add(Integer.parseInt(element));
        }

        if (isValidSubsequence(array, sequence)) {
            System.out.println("The sequence is a valid subsequence of the array.");
        } else {
            System.out.println("The sequence is not a valid subsequence of the array.");
        }
    }

    /**
     * Given two non-empty arrays of integers, return true if the second array is a subsequence of the first one.
     *
     * @param array    List of Integers
     * @param sequence List of Integers
     * @return boolean - true or false
     */
    private static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arrayCurrentIndex = 0;
        int sequenceCurrentIndex = 0;

        while (arrayCurrentIndex < array.size() && sequenceCurrentIndex < sequence.size()) {
            if (sequence.get(sequenceCurrentIndex).equals(array.get(arrayCurrentIndex))) {
                sequenceCurrentIndex++;
            }
            arrayCurrentIndex++;
        }
        return sequenceCurrentIndex == sequence.size();
    }

    private static boolean isValidSubsequenceV2(List<Integer> array, List<Integer> sequence) {
        int sequenceCurrentIndex = 0;

        for (int arrayCurrentElement : array) {
            if (sequenceCurrentIndex == sequence.size()) {
                break;
            }
            if (sequence.get(sequenceCurrentIndex).equals(arrayCurrentElement)) {
                sequenceCurrentIndex++;
            }
        }
        return sequenceCurrentIndex == sequence.size();
    }
}
