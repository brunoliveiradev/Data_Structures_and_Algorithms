package dev.brunoliveiradev.slidingWindow.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestAndLargestString {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine().strip().replace(" ", "");
        int k = Integer.parseInt(reader.readLine());

        String result = getSmallestAndLargestString(str, k);
        System.out.println(result);
    }

    /**
     * Given a string, str, and an integer, k, complete the function
     * so that it finds the lexicographically smallest and largest substrings of length k.
     * 'smallest' must be the lexicographically smallest substring of length 'k'
     * 'largest' must be the lexicographically largest substring of length 'k'
     */
    private static String getSmallestAndLargestString(String s, int k) {
        String smallest = s.substring(0,k);
        String largest  = "";

        String result = "";
        for(int i = 0; i < ((s.length() - k) + 1); i++) {
            String substrings = s.substring(i, i + k);

            if (substrings.compareTo(smallest) < 0) {
                smallest = substrings;
            }
            if (substrings.compareTo(largest) > 0) {
                largest = substrings;
            }

            result = smallest + "\n" + largest;
        }
        return result;
    }
}
