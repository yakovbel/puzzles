package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 56. Merge Intervals
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int size = intervals.length;
        if(size == 0) return intervals;

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> {
            return i1[0] - i2[0];
        });

        result.add(intervals[0]);
        //a two intervals not intersects with each other
        //b one interval inside second one
        //c regular interection
        //d same interval
        for(int i = 1; i < size; i++) {
            int[] prev = result.get(result.size() - 1);
            int[] cur = intervals[i];
            if(cur[0] > prev[1]) {
                result.add(cur);
            } else if(cur[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], cur[1]);
            }
        }

        int[][] arr = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

}
