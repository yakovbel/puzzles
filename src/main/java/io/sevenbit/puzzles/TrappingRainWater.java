package io.sevenbit.puzzles;

/**
 * Leetcode 42 trapping rain water
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height.length < 3) return 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        max_left[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i-1], height[i]);
        }
        max_right[height.length-1] = height[height.length-1];
        for(int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(height[i],max_right[i+1]);
        }
        int size = 0;
        for(int i = 0; i < height.length; i++) {
            int left = max_left[i];
            int right = max_right[i];
            int vol = Math.min(left, right);
            if(height[i] < vol) {
                size += vol - height[i];
            }
        }
        return size;
    }
}
