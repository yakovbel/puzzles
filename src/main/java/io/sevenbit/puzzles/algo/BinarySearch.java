package io.sevenbit.puzzles.algo;

import java.util.Arrays;

import static io.sevenbit.puzzles.util.Utils.generateRandomArray;

public class BinarySearch {

    public static int binarySearch(int value, int[] sortedArray) {
        return binarySearch(value, sortedArray, 0, sortedArray.length - 1);
    }

    public static int binarySearch(int value, int[] sortedArray, int beginIdx, int endIdx) {
        while (true) {
            if (endIdx < beginIdx) {
                return -1;
            }
            int middle = beginIdx + (endIdx - beginIdx) / 2;
            int middleValue = sortedArray[middle];
            if (middleValue == value) {
                return middle;
            }
            if (value < middleValue) {
                endIdx = middle - 1;
            } else {
                beginIdx = middle + 1;
            }
        }
    }


    public static int recursiveBinarySearch(int value, int[] sortedArray) {
        return recursiveBinarySearch(value, sortedArray, 0, sortedArray.length - 1);
    }

    public static int recursiveBinarySearch(int value, int[] sortedArray, int beginIdx, int endIdx) {
        if (endIdx < beginIdx) {
            return -1;
        }
        int middle = beginIdx + (endIdx - beginIdx) / 2;
        int middleValue = sortedArray[middle];
        if (middleValue == value) {
            return middle;
        }
        if (value < middleValue) {
            return recursiveBinarySearch(value, sortedArray, beginIdx, middle - 1);
        } else {
            return recursiveBinarySearch(value, sortedArray, middle + 1, endIdx);
        }
    }

    /**
     * Checks binary search correctness
     *
     * @param args
     */
    public static void main(String[] args) {
        int size = 100;
        int[] array = generateRandomArray(size);
        Arrays.sort(array);

        for (int i = 0; i < size; i++) {
            int expectedIdx = Math.max(-1, Arrays.binarySearch(array, i));
            int actualIdx = binarySearch(i, array);
            if (expectedIdx != actualIdx) {
                throw new RuntimeException("binary search error:\nexpected: " + expectedIdx
                        + "\nactual: " + actualIdx
                        + "\nvalue: " + i
                        + "\narray: " + Arrays.toString(array));
            }
        }
    }

}
