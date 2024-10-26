package dev.brunoliveiradev.arraysAndStrings.twoPointers;

public class MinimumCommonValue {

    // GetCommon is a function where given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.
    //
    // This has solved using two pointers technique
    //
    // Space complexity: O(1) - since no new structure is created
    // Time Complexity: O(n + m), where 'n' is the length of nums1 and 'm' is the length of nums2.
    public int GetCommon(int[] nums1, int[] nums2) {
        int a = 0, b = 0;

        while (a < nums1.length && b < nums2.length) {
            if (nums1[a] == nums2[b]) {
                return nums1[a];
            } else if (nums1[a] > nums2[b]) {
                b++;
            } else if (nums2[b] > nums1[a]) {
                a++;
            }
        }
        return -1;
    }
}
