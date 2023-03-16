package dev.brunoliveiradev.slidingWindow.medium;

public class MaxVowelsInSubString {

    public static int maxVowels(String s, int k) {
        int vowel = 0;
        int maxVowels = 0;

        for (int i = 0; i < s.length(); i++) {
            //vowel is like the size of the window
            if (isVowel(s.charAt(i))) {
                vowel++;
            }
            // if constraint is broken, delete the char of the previous window
            if (i >= k && isVowel(s.charAt(i - k))) {
                vowel--;
            }
            maxVowels = Math.max(maxVowels, vowel);
        }
        return maxVowels;
    }

    private static boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {

    }
}
