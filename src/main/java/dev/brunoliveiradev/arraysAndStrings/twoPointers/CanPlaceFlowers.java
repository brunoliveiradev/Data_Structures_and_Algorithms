package dev.brunoliveiradev.arraysAndStrings.twoPointers;

public class CanPlaceFlowers {
    /**
     * <p>You have a long flowerbed in which some plots are planted, and some are not.
     * However, flowers cannot be planted in adjacent plots.</p>
     *
     * <p>Given an integer array {@code flowerbed} containing 0's and 1's, where 0 means empty
     * and 1 means not empty, and an integer {@code n}.</p>
     *
     * <p>Constraints:</p>
     * <ul>
     *   <li>1 <= flowerbed.length <= 2 * 10^4</li>
     *   <li>flowerbed[i] is 0 or 1</li>
     *   <li>There are no two adjacent flowers in the flowerbed</li>
     *   <li>0 <= n <= flowerbed.length</li>
     * </ul>
     *
     * @param flowerbed input flowerbed array (0 = empty, 1 = planted)
     * @param n number of new flowers to plant
     * @return true if {@code n} new flowers can be planted without violating the no-adjacent-flowers rule; otherwise false
     * @apiNote Big(O): O(n) time complexity, O(1) space complexity.
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;

        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) continue; // skip spot with a plant

            int left  = (i == 0)        ? 0 : flowerbed[i - 1];        // the left spot is "empty"
            int right = (i == len - 1)  ? 0 : flowerbed[i + 1];        // right spot is "empty"

            if (left == 0 && flowerbed[i] == 0 && right == 0) {
                flowerbed[i] = 1;  // plant at the spot
                n--;

                if (n == 0) return true; // early exit

                i++; // skip to avoid collision / adjacent
            }
        }
        return false;
    }
}
