package dev.brunoliveiradev.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RunningSum {

    /**
     * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i])
     * @param nums
     * @return int - the running sum of num
     */
    private static int[] runningSum(int[] nums) {
        int[] results =  new int[nums.length];
        results[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            results[i] = nums[i] + results[i -1];
        }
        return results;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());

        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine().trim());
        }
        reader.close();

        int[] results = runningSum(array);

        System.out.println(Arrays.toString(results));
    }
}
