package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class GreatestNumberOfCandies {
    /**
     * There are n kids with candies. You are given an integer array candy, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
     * Note that multiple kids can have the greatest number of candies.
     * @param candies
     * @param extraCandies
     * @return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
     * @apiNote Big O(n): O(n) Time Complexity and O(1) Space Complexity
     */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candy : candies) {
            if (candy >= maxCandies) {
                maxCandies = candy;
            }
        }

        // needAtLeast represent how much candy a kid needs to have to be considered one of the greatest number of candies.
        int needAtLeast = maxCandies - extraCandies;
        List<Boolean> greatestAmongKids = new ArrayList<>(candies.length);

        for (int candy : candies) {
            greatestAmongKids.add(candy >= needAtLeast);
        }
        return greatestAmongKids;
    }
}
