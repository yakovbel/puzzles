package io.sevenbit.puzzles;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode  84. Largest Rectangle in Histogram
 */
public class LargestRectangleArea {

    /*
Rectangle with max width has at least one bar with lowest height.
We iterate through the all bars and find the rectangle when current bar has minimal height
To find such rectangle we need to find the bar from the left with the lower height and bar to
the right with the lower height. Desired rectangle is bounded by this to bars L and R.
To find L and R for every bar effectively we will use monotonic stack.
We add a bar to the stack if it's greater than the current stack peak. (becuase we haven't find R yet.)
*/
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len = heights.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int curHeight = heights[stack.pop()];
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int curWidth = (i - leftIndex - 1);
                result = Math.max(result, curHeight * curWidth);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pop()];
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();
            int curWidth = (len - leftIndex - 1);
            result = Math.max(result, curHeight * curWidth);
        }
        return result;
    }
}
