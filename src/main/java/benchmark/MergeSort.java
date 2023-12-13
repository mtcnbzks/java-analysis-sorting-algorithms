package benchmark;

import java.util.Arrays;

public class MergeSort {
    static <T extends Comparable<T>> void sort(T[] arr) {
        int length = arr.length;

        if (length < 2) {
            return;
        }

        int mid = length / 2;

        T[] leftArray = Arrays.copyOfRange(arr, 0, mid);
        T[] rightArray = Arrays.copyOfRange(arr, mid, length);

        sort(leftArray);
        sort(rightArray);

        merge(arr, leftArray, rightArray);
    }

    private static <T extends Comparable<T>> void merge(T[] arr, T[] leftArray, T[] rightArray) {
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].compareTo(rightArray[j]) < 0) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }
    }
}
