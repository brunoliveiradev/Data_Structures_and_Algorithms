package dev.brunoliveiradev.arraysAndStrings.strings;

public class GreatestCommomDivisor {

    // Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
    // Overall complexity: O(n + m).
    public static String gcdOfStrings(String str1, String str2) {
        // if they are not equal, means that they don't share a common divisor
        if (!(str1+str2).equals(str2+str1)) {
            return "";
        }
        int a = str1.length();
        int b = str2.length();

        // Euclidean algorithm
        while (b != 0) {
            int remain = a % b;
            a = b;
            b = remain;
        }

        // The largest common divisor string must be the prefix of str1 with length equal to that GCD
        return str1.substring(0, a);
    }
}
