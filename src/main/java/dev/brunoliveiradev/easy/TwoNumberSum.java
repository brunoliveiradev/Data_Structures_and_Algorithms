package dev.brunoliveiradev.easy;

import java.util.ArrayList;
import java.util.List;

public class TwoNumberSum {

    /**
     * Essentially this algorithm is trying to find a corresponding number Y
     * such that X + Y = targetSum. If no two numbers sum up to the target sum,
     * the function should return an empty array.
     * @param array int
     * @param targetSum int
     * @return result
     */

    public static int[] twoNumberSum(int[] array, int targetSum) {
        List<Integer> result = new ArrayList<>(array.length);

        for(int currentElement : array) {
            if(result.contains(targetSum - currentElement)) {
                return new int[] {targetSum-currentElement, currentElement};
            } else {
                result.add(currentElement);
            }
        }
        return new int[0];
    }
}