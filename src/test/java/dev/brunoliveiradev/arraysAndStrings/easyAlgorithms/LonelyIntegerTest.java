package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LonelyIntegerTest {

    @Test
    void lonelyIntegerReturnsSingleElementForArrayWithOneElement() {
        int[] array = {7};
        assertEquals(7, LonelyInteger.lonelyInteger(array));
    }

    @Test
    void lonelyIntegerFindsLonelyIntegerInArrayWithMultipleElements() {
        int[] array = {1, 2, 3, 2, 1};
        assertEquals(3, LonelyInteger.lonelyInteger(array));
    }

    @Test
    void lonelyIntegerHandlesArrayWithNegativeNumbers() {
        int[] array = {-1, -2, -3, -2, -1};
        assertEquals(-3, LonelyInteger.lonelyInteger(array));
    }

    @Test
    void lonelyIntegerHandlesArrayWithMixedPositiveAndNegativeNumbers() {
        int[] array = {4, -3, 4, -3, 5};
        assertEquals(5, LonelyInteger.lonelyInteger(array));
    }

    @Test
    void lonelyIntegerThrowsExceptionForEmptyArray() {
        int[] array = {};
        assertThrows(IllegalArgumentException.class, () -> LonelyInteger.lonelyInteger(array));
    }

    @Test
    void lonelyIntegerThrowsExceptionForNullArray() {
        int[] array = null;
        assertThrows(IllegalArgumentException.class, () -> LonelyInteger.lonelyInteger(array));
    }

}