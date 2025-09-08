package dev.brunoliveiradev.hashing.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    // Complexity: O(n) time, O(1) space
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            int currVal = romanMap.get(charAt);

            if (i + 1 < s.length()) {
                char nextChar = s.charAt(i + 1);

                int nextVal = romanMap.get(nextChar);

                if (currVal < nextVal) {
                    number += (nextVal - currVal);
                    i++;
                    continue;
                }
            }

            number += currVal;
        }

        return number;
    }
}
