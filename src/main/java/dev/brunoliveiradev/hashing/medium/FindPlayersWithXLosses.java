package dev.brunoliveiradev.hashing.medium;

import java.util.*;

public class FindPlayersWithXLosses {

    /**
     * Given an integer array matches where matches[i] = [winneri, loseri]
     * indicates that the player winneri defeated player loseri in a match.
     * Return a list answer of size 2 where:
     * <br>
     * answer[0] is a list of all player that have not lost any matches
     * <br>
     * answer[1] is a list of all players that lost exactly one match.
     * <br>
     * Should be returned in increasing order
     *
     * @param matches array of matche
     * @return a list of players that have not lost any matches and a list of players that lost exactly one match
     * @apiNote The main time complexity comes from iterating through the matches array once (O(n))
     * and sorting the results (O(m log m)),
     * where n is the length of the matches array and m is the number of unique players.
     * In the worst case, if all players have either 0 or 1 loss, m would be equal to n,
     * and the total time complexity would be O(n log n).
     * <br>
     * The space complexity of the solution is also O(n) as in the worst case,
     * you might have to store all players in the HashMap.
     * <br>
     * Since the output needs to be sorted and every match potentially affects the output,
     * we need at least O(n log n) time complexity to solve this problem.
     * <br>
     * @implNote We use a HashMap to store the number of losses for each player.
     * <url><a href="https://leetcode.com/problems/find-players-with-zero-or-one-losses/solutions/3552128/a-simple-and-explained-java-solution/">Solution</a></url>
     */
    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> matchesOutcomes = new HashMap<>();

        int winner;
        int loser;
        List<Integer> playerWithNoLoses = new ArrayList<>();
        List<Integer> playerWithOneLoss = new ArrayList<>();

        for (int[] num : matches) {
            winner = num[0];
            matchesOutcomes.put(winner, matchesOutcomes.getOrDefault(winner, 0));

            loser = num[1];
            matchesOutcomes.put(loser, matchesOutcomes.getOrDefault(loser, 0) + 1);
        }

        matchesOutcomes.forEach((key, value) -> {
            if (value == 1) {
                playerWithOneLoss.add(key);
            } else if (value == 0) {
                playerWithNoLoses.add(key);
            }
        });

        Collections.sort(playerWithNoLoses);
        Collections.sort(playerWithOneLoss);

        return List.of(playerWithNoLoses, playerWithOneLoss);
    }


    public static void main(String[] args) {
        int[][] matches1 = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        List<List<Integer>> result1 = findWinners(matches1);
        System.out.println("Output for matches1: " + result1);

        int[][] matches2 = {{2, 3}, {1, 3}, {5, 4}, {6, 4}};
        List<List<Integer>> result2 = findWinners(matches2);
        System.out.println("Output for matches2: " + result2);
    }

}