package dev.brunoliveiradev.hashing.medium;

import java.util.*;

public class GroupAnagrams {

    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     * @param sources string array of strings
     * @return group of anagrams
     * @apiNote The overall time complexity is approximately O(n*mlogm), where n is the number of strings and m is the average length of a string.
     */
    public static List<List<String>> groupAnagrams(String[] sources) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String str : sources) {
            char [] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            List<String> groupAnagram = anagrams.getOrDefault(key, new ArrayList<>());
            groupAnagram.add(str);

            anagrams.put(key, groupAnagram);
        }

        return new ArrayList<>(anagrams.values());
    }


    public static void main(String[] args) {
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(test1));

        String[] test2 = {""};
        System.out.println(groupAnagrams(test2));

        String[] test3 = {"a"};
        System.out.println(groupAnagrams(test3));
    }


}
