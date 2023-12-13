package benchmark;

public class HeapSort {
    static <T extends Comparable<T>> void sort(T[] arr) {
        buildMaxHeap(arr);

        int n = arr.length - 1;
        for (int i = n; i > 0; i--) {
            swap(arr, 0, i);
            n--;
            maxHeapify(arr, 0, n);
        }
    }

    private static <T extends Comparable<T>> void buildMaxHeap(T[] arr) {
        for (int i = (arr.length / 2) - 1; i >= 0; i--)
            maxHeapify(arr, i, arr.length - 1);
    }

    private static <T extends Comparable<T>> void maxHeapify(T[] arr, int index, int n) {
        if (isLeaf(index, n)) {
            return;
        }

        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);

        int largest = index;

        if (left <= n && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }

        if (right <= n && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }

        if (largest != index) {
            swap(arr, index, largest);
            maxHeapify(arr, largest, n);
        }
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean isLeaf(int index, int n) {
        return index >= (n / 2) && index < n;
    }

    private static int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private static int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
}
