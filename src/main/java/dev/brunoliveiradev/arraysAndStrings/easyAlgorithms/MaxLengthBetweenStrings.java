package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import java.util.Scanner;

public class MaxLengthBetweenStrings {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first string: ");
            String str1 = scanner.nextLine();

            if (isNullOrBlank(str1)) {
                System.out.println("The first input is null or empty");
                return;
            }

            System.out.print("Enter second string: ");
            String str2 = scanner.nextLine();

            if (isNullOrBlank(str2)) {
                System.out.println("The second input is null or empty");
                return;
            }

            int maxLengthCombined = getMaxLengthCombined(str1, str2);
            System.out.println("Maximum length of the combined string is: " + maxLengthCombined);

            int maxLength = getMaxLengthBetween(str1, str2);
            System.out.println("Maximum length between the two strings is: " + maxLength);
        }
    }

    /**
     * Return the max length combined between two Strings
     * @param str1 String input
     * @param str2 String input
     * @return maxLengthCombined
     */
    static int getMaxLengthCombined(String str1, String str2) {
        String combined = str1 + str2;
        System.out.println("Maximum length of the combined string is: " + combined.length());
        return combined.length();
    }


    /**
     * Return the max length between two Strings
     * @param str1 String
     * @param str2 String
     * @return maxLength - int
     */
    static int getMaxLengthBetween(String str1, String str2) {
        int lengthStr1 = str1.length();
        int lengthStr2 = str2.length();
        System.out.println("Maximum length between the two strings is: " + Math.max(lengthStr1, lengthStr2));
        return Math.max(lengthStr1, lengthStr2);
    }

    /**
     * Verify if the String input isNullOrBlank
     * @param str String input
     * @return false - if is not null or blank; true - if is null or blank
     */
    public static boolean isNullOrBlank(String str) {
        System.out.println("The input is null or empty");
        return str == null || str.trim().isEmpty();
    }
}
