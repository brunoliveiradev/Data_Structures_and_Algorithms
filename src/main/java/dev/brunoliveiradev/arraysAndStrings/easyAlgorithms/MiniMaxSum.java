package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MiniMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
        long totalSum = 0, minValue = arr.get(0), maxValue = arr.get(0);

        for (Integer value : arr) {
            totalSum += value;
            if (value < minValue) minValue = value;
            if (value > maxValue) maxValue = value;
        }

        System.out.println((totalSum - maxValue)+ " " + (totalSum - minValue));
    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            MiniMaxSum.miniMaxSum(arr);

            bufferedReader.close();
        }
    }
}
