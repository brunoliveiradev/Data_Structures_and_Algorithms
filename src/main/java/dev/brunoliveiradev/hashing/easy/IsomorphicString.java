package dev.brunoliveiradev.hashing.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    /**
     * Given two strings s and t, determine if they are isomorphic.
     * <p>
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
     * <p>
     * All occurrences of a character must be replaced with another character while preserving the order of characters.
     * <p>
     * No two characters may map to the same character, but a character may map to itself.
     *
     * @param s string, 1 <= s.length <= 5 * 104
     * @param t string, t.length == s.length
     * @return return true if they are isomorphic, false otherwise.
     * @apiNote Time and Space Complexity: O(n) - where n is the length of the string.
     */
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapStoT = new HashMap<>();
        Map<Character, Character> mapTtoS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char wordS = s.charAt(i);
            char wordT = t.charAt(i);

            if (mapStoT.containsKey(wordS)) {
                if (!mapStoT.get(wordS).equals(wordT)) {
                    return false;
                }
            } else {
                mapStoT.put(wordS, wordT);
            }

            if (mapTtoS.containsKey(wordT)) {
                if (!mapTtoS.get(wordT).equals(wordS)) {
                    return false;
                }
            } else {
                mapTtoS.put(wordT, wordS);
            }

        }

        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        System.out.println(isIsomorphic(s, t));

        s = "egg";
        t = "add";
        System.out.println(isIsomorphic(s, t));

        s = "foo";
        t = "bar";
        System.out.println(isIsomorphic(s, t));

        s = "paper";
        t = "title";
        System.out.println(isIsomorphic(s, t));

    }

}
