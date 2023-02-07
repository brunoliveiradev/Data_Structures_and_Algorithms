package dev.brunoliveiradev.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TournamentWinner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of competitions:");
        int numberOfCompetitions = scanner.nextInt();
        ArrayList<ArrayList<String>> competitions = new ArrayList<>(numberOfCompetitions);

        ArrayList<Integer> results = new ArrayList<>(numberOfCompetitions);
        System.out.println("Enter the teams and results:");

        for (int i = 0; i < numberOfCompetitions; i++) {
            ArrayList<String> competition = new ArrayList<>(2);
            System.out.println("Enter the home team:");
            competition.add(scanner.next());

            System.out.println("Enter the away team:");
            competition.add(scanner.next());

            System.out.println("Enter the result (0 for home team win, 1 for away team win):");
            int result = scanner.nextInt();

            competitions.add(competition);
            results.add(result);
        }

        String winner = TournamentWinner.tournamentWinner(competitions, results);
        System.out.println("The winner of the tournament is: " + winner);
    }

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
