package benchmark;

import java.util.Random;

public class QuickSortHoare {

    static <T extends Comparable<T>> void sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        T pivot = arr[pivotIndex];
        swap(arr, pivotIndex, highIndex);

        int leftPointer = hoarePartition(arr, lowIndex, highIndex, pivot);

        quickSort(arr, lowIndex, leftPointer - 1);
        quickSort(arr, leftPointer + 1, highIndex);
    }

    private static <T extends Comparable<T>> int hoarePartition(T[] arr, int lowIndex, int highIndex, T pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {
            while (arr[leftPointer].compareTo(pivot) <= 0 && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (arr[rightPointer].compareTo(pivot) >= 0 && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(arr, leftPointer, rightPointer);
        }

        swap(arr, leftPointer, highIndex);
        return leftPointer;
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
