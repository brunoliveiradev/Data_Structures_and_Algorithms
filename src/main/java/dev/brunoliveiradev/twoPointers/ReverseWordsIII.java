package dev.brunoliveiradev.twoPointers;

import java.util.Scanner;

public class ReverseWordsIII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Reversed string: " + reverseWords(input));
    }

    public static String reverseWords(String s) {
        if (s.length() == 1) return s;

        char[] chArray = s.toCharArray();
        int lastSpaceIndex = -1;
        int len = s.length();

        for (int i = 0; i <= len; i++) {
            if (i == len || chArray[i] == ' ') {
                int startIndex = lastSpaceIndex + 1;
                int endIndex = i - 1;
                reverse(chArray, startIndex, endIndex);
                lastSpaceIndex = i;
            }
        }
        return new String(chArray);
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
