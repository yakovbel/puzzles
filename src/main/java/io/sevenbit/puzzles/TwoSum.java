package io.sevenbit.puzzles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

   public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> reverse = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) { // O(n)
            Integer value = reverse.get(target - nums[i]);
            if (value != null && value != i) {
                return new int[]{i, value};
            }
            reverse.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int[] expected = new int[]{1, 2};
        int[] actual = twoSum(nums, 6);
        check(actual, expected);

        nums = new int[]{3, 3};
        expected = new int[]{0, 1};
        actual = twoSum(nums, 6);
        check(expected, actual);

        nums = new int[]{3,2,95,4,-3};
        expected = new int[]{2,4};
        actual = twoSum(nums, 92);
        check(expected, actual);
    }

    static void check(int[] expected, int[] actual) {
        Arrays.sort(expected);
        Arrays.sort(actual);
        if (!Arrays.equals(expected, actual)) {
            throw new RuntimeException("wrong answer: " + Arrays.toString(expected) + " " + Arrays.toString(actual));
        }
    }


}
