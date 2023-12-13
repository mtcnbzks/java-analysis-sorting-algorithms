package benchmark;

import java.util.Arrays;

public class ThreeWayMergeSort {

    static <T extends Comparable<T>> void sort(T[] arr) {
        if (arr == null) return;
        T[] tempArray = Arrays.copyOf(arr, arr.length);
        mergeSort3WayRec(tempArray, 0, arr.length, arr);
    }

    private static <T extends Comparable<T>> void mergeSort3WayRec(T[] sourceArray, int low, int high, T[] destArray) {
        if (high - low < 2) return;
        int mid1 = low + ((high - low) / 3);
        int mid2 = low + 2 * ((high - low) / 3) + 1;
        mergeSort3WayRec(destArray, low, mid1, sourceArray);
        mergeSort3WayRec(destArray, mid1, mid2, sourceArray);
        mergeSort3WayRec(destArray, mid2, high, sourceArray);
        merge(sourceArray, destArray, low, mid1, mid2, high);
    }

    private static <T extends Comparable<T>> void merge(T[] sourceArray, T[] destArray, int low, int mid1, int mid2, int high) {
        int i = low, j = mid1, k = mid2, l = low;

        while ((i < mid1) && (j < mid2) && (k < high)) {
            if (sourceArray[i].compareTo(sourceArray[j]) <= 0) {
                if (sourceArray[i].compareTo(sourceArray[k]) <= 0) {
                    destArray[l++] = sourceArray[i++];
                } else {
                    destArray[l++] = sourceArray[k++];
                }
            } else {
                if (sourceArray[j].compareTo(sourceArray[k]) <= 0) {
                    destArray[l++] = sourceArray[j++];
                } else {
                    destArray[l++] = sourceArray[k++];
                }
            }
        }

        while ((i < mid1) && (j < mid2)) {
            if (sourceArray[i].compareTo(sourceArray[j]) <= 0) {
                destArray[l++] = sourceArray[i++];
            } else {
                destArray[l++] = sourceArray[j++];
            }
        }

        while ((j < mid2) && (k < high)) {
            if (sourceArray[j].compareTo(sourceArray[k]) <= 0) {
                destArray[l++] = sourceArray[j++];
            } else {
                destArray[l++] = sourceArray[k++];
            }
        }

        while ((i < mid1) && (k < high)) {
            if (sourceArray[i].compareTo(sourceArray[k]) <= 0) {
                destArray[l++] = sourceArray[i++];
            } else {
                destArray[l++] = sourceArray[k++];
            }
        }

        while (i < mid1) {
            destArray[l++] = sourceArray[i++];
        }

        while (j < mid2) {
            destArray[l++] = sourceArray[j++];
        }

        while (k < high) {
            destArray[l++] = sourceArray[k++];
        }
    }

}
