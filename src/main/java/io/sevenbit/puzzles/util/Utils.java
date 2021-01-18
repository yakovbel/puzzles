package io.sevenbit.puzzles.util;

import java.util.Random;

public class Utils {

    private static final int DEFAULT_BOUND = 100;
    private static final Random r = new Random();

    public static int[] generateRandomArray(int size) {
        return generateRandomArray(size, DEFAULT_BOUND);
    }

    public static int[] generateRandomArray(int size, int bound) {

        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = r.nextInt(bound);
        }
        return result;
    }

}
