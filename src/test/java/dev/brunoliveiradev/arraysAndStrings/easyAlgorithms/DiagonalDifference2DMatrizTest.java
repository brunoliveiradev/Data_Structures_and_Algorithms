package dev.brunoliveiradev.arraysAndStrings.easyAlgorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiagonalDifference2DMatrizTest {

    @Test
    void diagonalDifferenceReturnsZeroForMatrixWithEqualDiagonals() {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 1)
        );
        assertEquals(8, DiagonalDifference2DMatriz.diagonalDifference(matrix));
    }

    @Test
    void diagonalDifferenceCalculatesCorrectlyForMatrixWithDifferentDiagonals() {
        List<List<Integer>> matrix = List.of(
                List.of(11, 2, 4),
                List.of(4, 5, 6),
                List.of(10, 8, -12)
        );
        assertEquals(15, DiagonalDifference2DMatriz.diagonalDifference(matrix));
    }

    @Test
    void diagonalDifferenceHandlesSingleElementMatrix() {
        List<List<Integer>> matrix = List.of(
                List.of(5)
        );
        assertEquals(0, DiagonalDifference2DMatriz.diagonalDifference(matrix));
    }

    @Test
    void diagonalDifferenceHandlesMatrixWithNegativeNumbers() {
        List<List<Integer>> matrix = List.of(
                List.of(-1, -2, -3),
                List.of(-4, -5, -6),
                List.of(-7, -8, -9)
        );
        assertEquals(0, DiagonalDifference2DMatriz.diagonalDifference(matrix));
    }

    @Test
    void diagonalDifferenceHandlesMatrixWithMixedPositiveAndNegativeNumbers() {
        List<List<Integer>> matrix = List.of(
                List.of(1, -2, 3),
                List.of(-4, 5, -6),
                List.of(7, -8, 9)
        );
        assertEquals(0, DiagonalDifference2DMatriz.diagonalDifference(matrix));
    }



}