package dev.brunoliveiradev.techniques;

public class StringAndArrayCommomPatterns {


    /**
     * STRINGS ARE IMMUTABLE.
     * This means concatenating a single character to a string
     * is a O(n) operation. If you have a string that is 1 million characters long,
     * and you want to add one more character, all 1 million characters need to be
     * copied over to another string.
     */
    static class StringCommomPattern {


        /** Many problems will ask you to return a string, and usually, this string will be built
         * during the algorithm. Simple concatenation will result in an O(n²) time complexity.
         * To build a string in O(n) time in java we follow some steps.
         * @implNote
         * 1 - Use the @StringBuilder class;
         * 2 - When builing, add the characters to the list - This is O(1) per operation;
         * 3 - Once finished, convert the list to a string using, StringBuilder.toString() - this is O(n)
         *
         * @return sb.toString();
         */
        public static String builindString(String s) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }


    }
}
