package dev.brunoliveiradev.techniques.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class Counting {
    /**
     * Counting is the most common hash map pattern and is arguably the most common interview pattern.
     * Counting is a technique that consists of counting
     * the number of occurrences of each element in an array.
     * <p>
     * i.e, we are referring to tracking the frequency of each element in the array.
     * <p>
     * This means our hash map will be mapping keys to integers.
     * <br> Anytime you need to count anything, you should think about using a hash map.
     */
    public static void main(String[] args) {
        System.out.println("Counting a hash map technique");
        System.out.println("Given a string s and an integer k, return the length of the longest substring that contains at most k distinct characters.");
        System.out.println("Example 1 - given s: 'eceba', k: 2, the expceted answer is: 3. Got answer: " + findLongestSubstring("eceba", 2));
    }


    /**
     * Find the number of subarrays that have a sum exactly equal to k
     *
     * @param nums only has positive numbers
     * @param k    sum of the subarray
     * @return the number of subarrays that have a sum exactly equal to k
     */
    public static int countingNumbersOfSubarraysWithExactConstraint(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        int currSum = 0; // track whatever the constraint metric is, in this case is the sum of the subarray
        int answer = 0;

        // iterate over the input
        // check the hash map for curr minus the constraint. Add this frequency to the answer
        // increment the frequency of the current value in the hash map
        // update the curr
        for (int num : nums) {
            currSum += num;
            if (currSum == k) {
                answer++;
            }

            if (counts.containsKey(currSum - k)) {
                answer += counts.get(currSum - k);
            }

            counts.put(currSum, counts.getOrDefault(currSum, 0) + 1);
        }
        return answer;
    }


    /**
     * Given a string s and an integer k, return the length of the longest substring that
     * contains at most k distinct characters.
     *
     * @param s String
     * @param k number of distinct characters
     * @return int - the length of the longest substring that contains at most k distinct characters
     * @apiNote Time Complexity: O(n) | Space Complexity: O(k) - where n is the length of the input string. where m is the size of the character set in the input string "s" (i.e., the number of distinct characters in "s"), and k is the maximum number of distinct characters allowed in the substring.
     * @implNote Solved using Counting, looking up items in a HashMap has a cost of O(1)
     */
    public static int findLongestSubstring(String s, int k) {
        // HashMap to store the frequency of each character in the current window
        Map<Character, Integer> counts = new HashMap<>();
        int left = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {
            updateCharacterCount(s, counts, right);

            while (counts.size() > k) {
                removeCharacter(s, counts, left);
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }

    /**
     * Update the character count in the map and increment the count
     *
     * @param s      String to be counted
     * @param counts Map<Character, Integer> - map of characters and their counts
     * @param index  int - index of the character to be counted
     * @implNote if the character is not in the map, add it and set the count to 1
     * <p>
     * if the character is already in the map, increment the count by 1
     */
    private static void updateCharacterCount(String s, Map<Character, Integer> counts, int index) {
        char current = s.charAt(index);

        // counts.getOrDefault(current, 0) + 1 is the same as: counts.get(current) != null ? counts.get(current) + 1 : 1
        counts.put(current, counts.getOrDefault(current, 0) + 1);
    }

    /**
     * Remove the character from the map and decrement the count
     *
     * @param s      String to be counted
     * @param counts Map<Character, Integer> - map of characters and their counts
     * @param index  int - index of the character to be counted
     * @implNote if the character is already in the map, decrement the count by 1.
     * <p>
     * if the count is 0, remove the character from the map
     */
    private static void removeCharacter(String s, Map<Character, Integer> counts, int index) {
        char remove = s.charAt(index);

        // counts.getOrDefault(remove, 0) - 1 is the same as: counts.get(remove) != null ? counts.get(remove) - 1 : 0
        counts.put(remove, counts.getOrDefault(remove, 0) - 1);

        if (counts.get(remove) == 0) {
            counts.remove(remove);
        }
    }
}
