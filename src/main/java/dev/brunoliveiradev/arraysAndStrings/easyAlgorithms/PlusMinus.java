package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {
        int positive = 0, negative = 0, zeroes = 0;

        for (Integer number : arr) {
            if (number > 0) {
                positive++;
            } else if (number < 0) {
                negative++;
            } else {
                zeroes++;
            }
        }
        int total = arr.size();

        // Set Locale to US to ensure decimal points using dot instead of comma
        System.out.printf(Locale.US, "%.6f%n", (float) positive / total);
        System.out.printf(Locale.US, "%.6f%n", (float) negative / total);
        System.out.printf(Locale.US, "%.6f%n", (float) zeroes / total);

    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            PlusMinus.plusMinus(arr);

            bufferedReader.close();
        }
    }

}
