package dev.brunoliveiradev.arraysAndStrings.strings;

public class RepeatedString {

   /**
    * Calculates the number of occurrences of the character 'a' in the first
    * 'n' characters of string 's' repeated infinitely.
    *
    * @param s the input string which will be repeated infinitely
    * @param n the number of characters to consider from the infinite repetition of 's'
    * @return the total number of occurrences of 'a' in the first 'n' characters of the repeated string
    * @throws IllegalArgumentException if the input string 's' is null or empty
    * @apiNote O(n) time, O(1) space
    */
    public static long repeatedString(String s, long n) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("s must be non-empty");
        }
        int len = s.length();
        long fullRepeats = n / len;         // How many full copies of s fit into the first n characters
        int remainder = (int)(n % len);     // How many extra characters we need from the next (partial) copy of s


        long countInS = 0;
        long countInRemainder = 0;

        // Single pass over s:
        // - Count all 'a's in s
        // - Additionally, for indices within the remainder prefix, count 'a's for the partial block
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'a') {
                countInS++;

                // If this index is within the remainder prefix, it contributes to the tail/leftovers part
                if (i < remainder) countInRemainder++;
            }
        }

        return fullRepeats * countInS + countInRemainder;
    }
}
