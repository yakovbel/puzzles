package io.sevenbit.puzzles;

import java.util.ArrayDeque;

/**
 * Leetcode 42 trapping rain water
 */
public class TrappingRainWater {
    //O(n) time O(n) space
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        max_left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i]);
        }
        max_right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(height[i], max_right[i + 1]);
        }
        int size = 0;
        for (int i = 0; i < height.length; i++) {
            int left = max_left[i];
            int right = max_right[i];
            int vol = Math.min(left, right);
            if (height[i] < vol) {
                size += vol - height[i];
            }
        }
        return size;
    }


    public int trapMax(int[] height) {
        int result = 0;
        int len = height.length;
        //find max
        int maxIdx = 0;
        for (int i = 1; i < len; i++) {
            if (height[i] >= height[maxIdx]) {
                maxIdx = i;
            }
        }
        int leftMaxIdx = 0;
        for (int i = 1; i < len; i++) {
            if (height[i] > height[leftMaxIdx]) {
                leftMaxIdx = i;
            } else {
                int vol = leftMaxIdx - height[i];
                if (vol > 0) {
                    result += vol;
                }
            }
        }

        return result;
    }

    //O(n) time O(1) space
    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left++;

            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right--;

            }
        }
        return result;
    }

    public int trapMonotonicStack(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        int len = height.length;
        int result = 0;
        int i = 0;
        while(i < len) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {//element on top of stack is bounded between current element and previous element
                int curIdx = stack.pop();
                if(stack.isEmpty()) break; //no left border
                int distance = i - stack.peek() - 1;
                int add = Math.min(height[i], height[stack.peek()]) - height[curIdx];
                result += add * distance;
            }
            stack.addFirst(i);
            i++;
        }
        return result;
    }
}
