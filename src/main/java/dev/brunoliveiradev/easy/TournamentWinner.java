package dev.brunoliveiradev.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class TournamentWinner {

    /**
     * Returns the winner of the tournament, the winner of the tournament
     * is the team that receveis the most amount of points.
     *
     * @param competitions an array of pairs representing the teams
     * @param results      array containing the results of each competition
     * @return name of the winner of the tournament
     * @apiNote Time complexity: O(n) | Space complexity: O(k) - where n is the number of competition and k is the number of teams
     */
    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions,
                                          ArrayList<Integer> results) {

        int homeTeamWon = 1;
        String currentWinner = "";

        HashMap<String, Integer> tournamentResults = new HashMap<>(competitions.size());
        tournamentResults.put(currentWinner, 0);

        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> team = competitions.get(i);
            int result = results.get(i);

            String homeTeam = team.get(0);
            String awayTeam = team.get(1);

            String winnerOfTheMatch = (result == homeTeamWon) ? homeTeam : awayTeam;

            updateScores(tournamentResults, winnerOfTheMatch, 3);

            if (tournamentResults.get(winnerOfTheMatch) > tournamentResults.get(currentWinner)) {
                currentWinner = winnerOfTheMatch;
            }
        }

        return currentWinner;
    }

    private static void updateScores(HashMap<String, Integer> scores, String team, int points) {
        if (!scores.containsKey(team)) {
            scores.put(team, 0);
        }
        scores.put(team, scores.get(team) + points);
    }
}
