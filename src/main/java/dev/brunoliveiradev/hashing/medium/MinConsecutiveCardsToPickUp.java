package dev.brunoliveiradev.hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class MinConsecutiveCardsToPickUp {

    /**
     * You are given an integer array cards where cards[i] represents the value of the ith card.
     * A pair of cards are matching if the cards have the same value.
     *
     * @param cards the array of cards
     * @return Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards.
     * <br>
     * If it is impossible to have matching cards, return -1.
     * @apiNote Time and Space complexity: O(n)
     */
    private static int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> deck = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];

            if (deck.containsKey(card)) {
                minDistance = Math.min(minDistance, i - deck.get(card) + 1);

            }
            deck.put(card, i);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public static void main(String[] args) {
        // Example 1
        int[] cards1 = {3, 4, 2, 3, 4, 7};
        int result1 = minimumCardPickup(cards1);
        System.out.println("Test 1 expected output : 4");
        System.out.println("Test 1 actual output   : " + result1);

        // Example 2
        int[] cards2 = {1, 0, 5, 3};
        int result2 = minimumCardPickup(cards2);
        System.out.println("Test 2 expected output : -1");
        System.out.println("Test 2 actual output   : " + result2);

        int[] card3 = {95, 11, 8, 65, 5, 86, 30, 27, 30, 73, 15, 91, 30, 7, 37, 26, 55, 76, 60, 43, 36, 85, 47, 96, 6};
        int result3 = minimumCardPickup(card3);
        System.out.println("Test 3 expected output : 3");
        System.out.println("Test 3 actual output : " + result3);
    }

}
