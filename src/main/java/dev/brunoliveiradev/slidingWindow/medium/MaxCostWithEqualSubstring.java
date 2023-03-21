package dev.brunoliveiradev.slidingWindow.medium;

public class MaxCostWithEqualSubstring {

    public static int equalSubstring(String s, String t, int maxCost) {
        int costToChange = 0;
        int currentCost = 0;
        int maxChange = 0;

        //Since s.length == t.length doesn't matter wich one I choose
        for (int i = 0; i < s.length(); i++) {
            costToChange = Math.abs(s.charAt(i) - t.charAt(i));

            if (costToChange <= maxCost) {
                currentCost = maxCost - costToChange;
            } else {
                currentCost--;
            }
            maxChange = Math.max(currentCost, maxChange);
        }
        return maxChange;
    }


    public static void main(String[] args) {

    }
}
