package ua.kiev.minaeva.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {

    MergeSort mergeSort = new MergeSort();

    @Test
    void scenario1() {
        assertArrayEquals(new int[]{1, 2, 3, 5, 7, 9},
                mergeSort.sort(new int[]{5, 3, 7, 2, 9, 1}));
    }

    @Test
    void scenario2() {
        assertArrayEquals(new int[]{1, 2, 3, 5, 7, 9, 10},
                mergeSort.sort(new int[]{5, 3, 7, 10, 2, 9, 1}));
    }

    @Test
    void scenario3() {
        assertArrayEquals(new int[]{1},
                mergeSort.sort(new int[]{1}));
    }

    @Test
    void scenario4() {
        assertArrayEquals(new int[]{2, 2, 2, 2, 2},
                mergeSort.sort(new int[]{2, 2, 2, 2, 2}));
    }

    @Test
    void scenario5() {
        assertArrayEquals(new int[]{2, 2, 3, 3, 3},
                mergeSort.sort(new int[]{3, 2, 3, 3, 2}));
    }

}
