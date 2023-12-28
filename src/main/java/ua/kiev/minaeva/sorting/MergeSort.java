package ua.kiev.minaeva.sorting;

public class MergeSort {

    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int originalLength = array.length;
        int leftLength = originalLength / 2;
        int rightLength = originalLength - leftLength;
        int[] left = new int[leftLength];
        int[] right = new int[rightLength];

        System.arraycopy(array, 0, left, 0, leftLength);
        System.arraycopy(array, leftLength, right, 0, rightLength);

        left = sort(left);
        right = sort(right);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int resultLength = left.length + right.length;
        int[] result = new int[resultLength];
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        while ((leftIndex < left.length) && (rightIndex < right.length)) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        System.arraycopy(left, leftIndex, result, resultIndex, left.length - leftIndex);
//        for (int i = leftIndex; i < left.length; i++) {
//            result[resultIndex++] = left[i];
//        }

        System.arraycopy(right, rightIndex, result, resultIndex + left.length - leftIndex, right.length - rightIndex);
//        for (int i = rightIndex; i < right.length; i++) {
//            result[resultIndex++] = right[i];
//        }

        return result;
    }

}
