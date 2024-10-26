package dev.brunoliveiradev.arraysAndStrings.twoPointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumCommonValueTest {

    @Test
    void getCommon_singleCommonElement() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4};
        assertEquals(2, new MinimumCommonValue().GetCommon(nums1, nums2));
    }

    @Test
    void getCommon_multipleCommonElements() {
        int[] nums1 = {1, 2, 3, 6};
        int[] nums2 = {2, 3, 4, 5};
        assertEquals(2, new MinimumCommonValue().GetCommon(nums1, nums2));
    }

    @Test
    void getCommon_noCommonElements() {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        assertEquals(-1, new MinimumCommonValue().GetCommon(nums1, nums2));
    }

    @Test
    void getCommon_emptyFirstArray() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        assertEquals(-1, new MinimumCommonValue().GetCommon(nums1, nums2));
    }

    @Test
    void getCommon_emptySecondArray() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {};
        assertEquals(-1, new MinimumCommonValue().GetCommon(nums1, nums2));
    }

    @Test
    void getCommon_bothArraysEmpty() {
        int[] nums1 = {};
        int[] nums2 = {};
        assertEquals(-1, new MinimumCommonValue().GetCommon(nums1, nums2));
    }

    @Test
    void getCommon_identicalArrays() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3};
        assertEquals(1, new MinimumCommonValue().GetCommon(nums1, nums2));
    }

    @Test
    void getCommon_largeNumbers() {
        int[] nums1 = {1000000000};
        int[] nums2 = {1000000000};
        assertEquals(1000000000, new MinimumCommonValue().GetCommon(nums1, nums2));
    }
}