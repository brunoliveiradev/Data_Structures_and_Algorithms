package dev.brunoliveiradev.easy;

import java.util.Scanner;

/**
 * Time complexity = O(log(n)) |
 * Space complexity = O(1)
 */
public class StepsToReduceNumberToZero {

    /**
     * In one step, if the current number is even, you have to divide it by 2,
     * otherwise, you have to subtract 1 from it.
     * @param num int
     * @return numberOfSteps
     */
    private static int numberOfSteps(int num) {
        int stepsToZero = 0;

        // Constraints: 0 <= num <= 10ˆ6
        if (num < 0 || num > 1000000) {
            return -1;
        }

        // Also, the variables isEven, numDividedByTwo and numSubtractedOne are not necessary, I put only for better reading.
        while (num != 0) {
            boolean isEven = num % 2 == 0;
            int numDividedByTwo = num / 2;
            int numSubtractedOne = num - 1;

            num = isEven ? numDividedByTwo : numSubtractedOne;

            stepsToZero++;
        }
        return stepsToZero;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");

        int num = sc.nextInt();

        int steps = numberOfSteps(num);

        if (steps == -1) {
            System.out.println("Number should be between 0 and 10^6");
        } else {
            System.out.println("Number of steps to reduce " + num + " to zero: " + steps);
        }
    }

}
