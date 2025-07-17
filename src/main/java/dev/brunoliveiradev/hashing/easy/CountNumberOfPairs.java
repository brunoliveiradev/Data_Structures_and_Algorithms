package dev.brunoliveiradev.hashing.easy;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountNumberOfPairs {

    /**
     * countPairs counts how many pairs of socks (same color) exist in the list.
     *
     * @param n  int - the number of socks in the list.
     * @param ar List<Integer> - the list of sock colors, where each color is represented by an integer.
     *           <p>
     *           Time Complexity: O(n) - where n is the number of socks.
     *           Space Complexity: O(n) - for storing the frequency of each sock color.
     */
    public static int countPairs(int n, List<Integer> ar) {

        // create a map to store the frequency of each sock color
        Map<Integer, Integer> sockets = new HashMap<>();

        // count the occurrences of each color in the socks array
        for (int i = 0; i < n; i++) {
            int currentSock = ar.get(i);
            sockets.put(currentSock, sockets.getOrDefault(currentSock, 0) + 1);
        }

        // count the number of pairs
        int pairsCount = 0;
        for (int freq : sockets.values()) {
            pairsCount += freq / 2;
        }

        return pairsCount;
    }

    // Main method to read input and call the countPairs function reading from standard input
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = countPairs(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
