package dev.brunoliveiradev.twoPointers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroes {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the lenght of the array: ");
        int lenght = Integer.parseInt(sc.next().trim());

        int[] array = new int[lenght];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter the " + i + "th element: ");
            array[i] = Integer.parseInt(sc.next().trim());
        }
        moveZeroes(array);
        System.out.println("Moved Zeroes to the last position: " + Arrays.toString(array));
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 1) return;

        int right = 0;

        for (int left = 0; left < nums.length; left++) {
            if (nums[left] != 0) {
                swap(nums, left, right);
                right++;
            }
        }
    }

    private static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
