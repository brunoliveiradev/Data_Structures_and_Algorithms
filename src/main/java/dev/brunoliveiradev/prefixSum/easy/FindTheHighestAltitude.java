package dev.brunoliveiradev.prefixSum.easy;

import java.util.Scanner;

public class FindTheHighestAltitude {

    /**
     * There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
     * The biker starts his trip on point 0 with altitude equal 0.
     * <p>
     * You are given an integer array gain of length n where gain[i] is the net gain in altitude
     * between points i and i + 1 for all (0 <= i < n).
     * <p>
     * Return the highest altitude of a point.
     *
     * @param gain int argument
     * @return int - the highest altitude of a point
     * @apiNote Time and Space Complexity: O(N) - where N is the length of the input array
     * @implNote The highest altitude is the maximum value of the current altitude. Used prefix sum approach to solve.
     */
    public static int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int currentAltitude = 0;

        for (int altitudeGain : gain) {
            currentAltitude += altitudeGain;
            highestAltitude = Math.max(highestAltitude, currentAltitude);
        }

        return highestAltitude;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the sequence of altitude gains separated by space: ");
        String input = scanner.nextLine();

        String[] gainStringArray = input.split(" ");
        int[] gain = new int[gainStringArray.length];
        for (int i = 0; i < gainStringArray.length; i++) {
            gain[i] = Integer.parseInt(gainStringArray[i]);
        }

        int highestAltitude = largestAltitude(gain);

        System.out.println("The highest altitude reached is" + highestAltitude);
    }
}
