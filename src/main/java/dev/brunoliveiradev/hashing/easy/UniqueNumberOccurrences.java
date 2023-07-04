package dev.brunoliveiradev.hashing.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOccurrences {

    /**
     * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
     *
     * @param arr 1 <= arr.length <= 1000 | -1000 <= arr[i] <= 1000
     * @return return true if the number of occurrences of each value in the array is unique or false otherwise.
     * @apiNote Time and Space complexity: in the worst case O(n)
     */
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Set<Integer> occurenceSet = new HashSet<>();

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : frequencyMap.values()) {
            if (!occurenceSet.add(num)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValueUniques(int[] arr) {
        // Store the frequency of elements in the unordered map.
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Store the frequency count of elements in the unordered set.
        Set<Integer> freqSet = new HashSet<>(freq.values());

        // If the set size is equal to the map size,
        // It implies frequency counts are unique.
        return freq.size() == freqSet.size();
    }


    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[] {1,2,2,1,1,3}));  // Expected output: true
        System.out.println(uniqueOccurrences(new int[] {1,2}));  // Expected output: false
        System.out.println(isValueUniques(new int[] {-3,0,1,-3,1,1,1,-3,10,0}));  // Expected output: true
    }

}
