package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 1762. Buildings With an Ocean View
 */
public class BuildingsWithOceanView {
    public int[] findBuildings(int[] heights) {
        int len = heights.length;
        if(len == 0) return new int[0];
        List<Integer> result = new ArrayList<>();
        int prev = heights[len-1];
        result.add(len-1);
        for(int i = len-2; i >= 0; i--) {
            if(heights[i] > prev) {
                prev = heights[i];
                result.add(i);
            }
        }

        int[] arr = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            arr[i] = result.get(result.size() - i - 1);
        }
        return arr;
    }
}
