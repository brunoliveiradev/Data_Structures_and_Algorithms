package dev.brunoliveiradev.hashing.easy;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    /**
     * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
     * Each character in stones is a type of stone you have.
     *
     * @param jewels String representing the types of stones that are jewels
     * @param stones String representing the stones you have
     * @return how many of the stones you have are also jewels.
     * @apiNote Time and Space complexity: O(n)
     */
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        int totalOfJewels = 0;

        for (char jewel : jewels.toCharArray()) {
            jewelSet.add(jewel);
        }

        for (char stone : stones.toCharArray()) {
            if (jewelSet.contains(stone)) {
                totalOfJewels++;
            }
        }

        return totalOfJewels;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));  // should print 3
        System.out.println(numJewelsInStones("z", "ZZ"));        // should print 0
        System.out.println(numJewelsInStones("aA", "AAaa"));     // should print 4
        System.out.println(numJewelsInStones("abc", "def"));     // should print 0
    }

}
