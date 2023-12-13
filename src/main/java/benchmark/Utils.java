package benchmark;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;

public class Utils {
    static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    static <T> void printArray(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static Integer[] generateRandomIntegerArray(int size) {
        Integer[] arr = new Integer[size];
        // create random integer bounded by Integer.MAX_VALUE and Integer.MIN_VALUE

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            // arr[i] = random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            arr[i] = random.nextInt(size);
        }

        return arr;
    }

    static Integer[] generateSortedIntegerArray(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }

        return arr;
    }

    static Integer[] generateReverseSortedIntegerArray(int size) {
        Integer[] arr = new Integer[size];
        for (int i = size - 1; i >= 0; i--) {
            arr[i] = i;
        }

        return arr;
    }

    private static BufferedReader getBufferedReader(String fileName) {
        return new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(Utils.class.getResourceAsStream(fileName))));
    }

    static Character[] fileToCharacterArray(String fileName) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader bufferedReader = getBufferedReader("../input_files/" + fileName)) {
            for (int c = bufferedReader.read(); c != -1; c = bufferedReader.read()) {
                content.append((char) c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Character[] arr = new Character[content.length()];

        for (int i = 0; i < content.length(); i++) {
            arr[i] = content.charAt(i);
        }

        return arr;
    }
}
