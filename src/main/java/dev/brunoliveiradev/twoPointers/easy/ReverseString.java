package dev.brunoliveiradev.twoPointers.easy;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        char[] s = input.toCharArray();

        reverseString(s);
        System.out.println("Reversed string: " + new String(s));
    }


    /**
     * Given a char[] return the reverse char[] at O(1) space.
     *
     * @param s char[]
     * @apiNote Time Compelxity: O(n) | Space Complexity: O(1)
     */
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];

            s[left] = s[right];
            left++;

            s[right] = temp;
            right--;
        }
        System.out.println("Reversed: " + new String(s));
    }
}
