package dev.brunoliveiradev.arraysAndStrings.twoPointers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CanPlaceFlowersTest {
    // Helper para evitar efeitos colaterais entre testes (a implementação modifica o array).
    private boolean callOnCopy(int[] flowerbed, int n) {
        int[] copy = Arrays.copyOf(flowerbed, flowerbed.length);
        return new CanPlaceFlowers().canPlaceFlowers(copy, n);
    }

    @Test
    void example1_basicTrue() {
        assertTrue(callOnCopy(new int[]{1, 0, 0, 0, 1}, 1));
    }

    @Test
    void example2_basicFalse() {
        assertFalse(callOnCopy(new int[]{1, 0, 0, 0, 1}, 2));
    }

    @Test
    void nZeroAlwaysTrue() {
        assertTrue(callOnCopy(new int[]{1, 0, 1, 0, 1}, 0));
        assertTrue(callOnCopy(new int[]{}, 0)); // caso limite: array vazio (se aplicável no seu projeto)
    }

    @Test
    void singlePlot() {
        assertTrue(callOnCopy(new int[]{0}, 1));
        assertFalse(callOnCopy(new int[]{1}, 1));
    }

    @Test
    void twoPlots() {
        assertTrue(callOnCopy(new int[]{0, 0}, 1));
        assertFalse(callOnCopy(new int[]{0, 0}, 2));
        assertFalse(callOnCopy(new int[]{1, 0}, 1));
        assertFalse(callOnCopy(new int[]{0, 1}, 1));
    }

    @Test
    void threeZerosMiddlePlanting() {
        assertTrue(callOnCopy(new int[]{0, 0, 0}, 2));  // planta nos índices 0 e 2
        assertFalse(callOnCopy(new int[]{0, 0, 0}, 3));
    }

    @Test
    void edgesAvailable() {
        assertTrue(callOnCopy(new int[]{0, 0, 1, 0, 0}, 2)); // planta em 0 e 4
        assertTrue(callOnCopy(new int[]{0, 0, 1, 0, 0, 0}, 2)); // 0 e 5
        assertFalse(callOnCopy(new int[]{0, 0, 1, 0, 0}, 3));
    }

    @Test
    void alternatingPattern() {
        assertFalse(callOnCopy(new int[]{0, 1, 0, 1, 0}, 1));
        assertFalse(callOnCopy(new int[]{0, 1, 0, 1, 0}, 2));
    }

    @Test
    void fullZerosMaxCapacity() {
        // Para tamanho ímpar 5, capacidade máxima é 3 (índices 0,2,4)
        assertTrue(callOnCopy(new int[]{0, 0, 0, 0, 0}, 3));
        assertFalse(callOnCopy(new int[]{0, 0, 0, 0, 0}, 4));
        // Para tamanho par 6, capacidade máxima é 3 (0,2,4)
        assertTrue(callOnCopy(new int[]{0, 0, 0, 0, 0, 0}, 3));
        assertFalse(callOnCopy(new int[]{0, 0, 0, 0, 0, 0}, 4));
    }

    @Test
    void alreadyPackedNoSpace() {
        assertFalse(callOnCopy(new int[]{1, 0, 1, 0, 1, 0, 1}, 1));
    }

    @Test
    void longGapThenOne() {
        assertTrue(callOnCopy(new int[]{0, 0, 0, 0, 1}, 2)); // planta 0 e 2
        assertFalse(callOnCopy(new int[]{0, 0, 0, 0, 1}, 3));
    }

    @Test
    void mutationShapeEarlyExit() {
        // Este teste verifica a MUTAÇÃO do array e um cenário de early-exit prático.
        int[] bed = new int[]{0, 0, 0, 0, 0};
        boolean ok = new CanPlaceFlowers().canPlaceFlowers(bed, 2);
        assertTrue(ok);
        // Com a estratégia gananciosa, após plantar 2 flores, o array deve estar [1,0,1,0,0] (e pode sair mais cedo).
        assertArrayEquals(new int[]{1, 0, 1, 0, 0}, bed);
    }

    @Test
    void noMutationLeakBetweenTests() {
        // Garante que o helper está isolando mutação entre execuções.
        int[] original = new int[]{0, 0, 0};
        assertTrue(callOnCopy(original, 2));  // possível
        // O array "original" não deve ter sido alterado pelo teste anterior.
        assertArrayEquals(new int[]{0, 0, 0}, original);
    }

}