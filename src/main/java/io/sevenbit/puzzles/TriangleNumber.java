package io.sevenbit.puzzles;

import java.util.Arrays;

/**
 * Leetcode 611. Valid Triangle Number
 */
public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int result = 0;
        for(int first = 0; first < len - 2; first++) {
            int minThird = first + 2;
            for(int second = first + 1; second < len - 1; second++) {
                minThird = Math.max(minThird, second+1);
                int third = maxLowerValueIdx(nums[first]+nums[second], nums, minThird, len - 1);
                if(third != -1) {
                    result += third - second;
                    minThird = third;
                }
            }
        }
        return result;
    }

    public int maxLowerValueIdx(int value, int[] nums, int start, int end) {
        int result = -1;
        while(start <= end) {
            int middle = (start + end) / 2;
            if(nums[middle] < value) {
                result = middle;
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return result;
    }

}
