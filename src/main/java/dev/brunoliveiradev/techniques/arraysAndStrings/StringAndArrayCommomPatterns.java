package dev.brunoliveiradev.techniques.arraysAndStrings;

import java.util.ArrayList;

public class StringAndArrayCommomPatterns {


    /**
     * STRINGS ARE IMMUTABLE.
     * This means concatenating a single character to a string
     * is a O(n) operation. If you have a string that is 1 million characters long,
     * and you want to add one more character, all 1 million characters need to be
     * copied over to another string.
     */
    static class StringCommomPattern {


        /**
         * Many problems will ask you to return a string, and usually, this string will be built
         * during the algorithm. Simple concatenation will result in an O(n²) time complexity.
         * To build a string in O(n) time in java we follow some steps.
         *
         * @return sb.toString();
         * @implNote 1 - Use the @StringBuilder class;
         * 2 - When builing, add the characters to the list - This is O(1) per operation;
         * 3 - Once finished, convert the list to a string using, StringBuilder.toString() - this is O(n)
         */
        public static String builindString(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }

        /**
         * @apiNote If a problem has explicit constraits such as:
         * > Sum greater than or less than k
         * > Limits on what is contained, such as the maximum of k unique elements
         * or no duplicates allowed
         * <p>
         * AND/OR asks for:
         * > minimum or maximum length
         * > Number of subarrays/substrings
         * > Max or minimum sum
         * @implNote Think about use sliding window - general speaking,
         * because not all window problems have these characteristics and vice versa.
         * @see SlidingWindow
         */
        private static void SlidingWindow(String s, Integer k) {
            int sum = s.length();

            if (sum >= k) {
                // do some logical code here
                int min = Math.min(sum, k);
                int max = Math.max(sum, k);
                // return min or max length values
            }
        }

        /**
         * @apiNote If a problem's input is an integer array, and you find yourself
         * needing to calculate multiple subarray sums, consider builing a prefix sum.
         * @implNote The size of a subarray between: i and j (inclusive) is j - i + 1.
         * This is also the number of subarrays that end at j, starting from i or later.
         * @see PrefixSum
         */
        private static void PrefixSum(ArrayList<Integer> multipleArray) {
            System.out.println("Just added this to enable java doc");
        }
    }
}
