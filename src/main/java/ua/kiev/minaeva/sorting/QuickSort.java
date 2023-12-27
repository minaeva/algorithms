package ua.kiev.minaeva.sorting;

import java.util.Arrays;

public class QuickSort {

    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int pivotal = array[array.length - 1];
        int[] less = new int[array.length - 1];
        int lessIndex = 0;
        int[] more = new int[array.length - 1];
        int moreIndex = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < pivotal) {
                less[lessIndex++] = array[i];
            } else {
                more[moreIndex++] = array[i];
            }
        }

        less = Arrays.copyOf(less, lessIndex);
        more = Arrays.copyOf(more, moreIndex);

        less = sort(less);
        more = sort(more);

        return combine(less, pivotal, more, array.length);
    }

    private int[] combine(int[] less, int pivotal, int[] more, int size) {
        int[] result = new int[size];

        System.arraycopy(less, 0, result, 0, less.length);
        int middleIndex = less.length;
        result[middleIndex] = pivotal;

        System.arraycopy(more, 0, result, middleIndex + 1, more.length);
        return result;
    }

}
