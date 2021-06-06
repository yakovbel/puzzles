package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 57. Insert Interval
 */
public class InsertInterval {
    /**
     Solution:
     find all elements that fully before new interval (use binary search)
     find all elements that fully after new interval (use binary search)
     carefully merge intersecting intervals
     **/
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        if(len == 0) {
            return new int[][]{newInterval};
        }

        int lowerEndIdx = lowerEndIdx(newInterval[0], intervals);
        int higherBeginIdx = higherBeginIdx(newInterval[1], intervals);


        List<int[]> result = new ArrayList<>(len+1);

        for(int i = 0; i <= lowerEndIdx; i++) {
            result.add(intervals[i]);
        }

        if(lowerEndIdx == -1 && higherBeginIdx == -1) {
            newInterval[0] = Math.min(newInterval[0], intervals[0][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[len-1][1]);
            result.add(newInterval);
        } else {
            if(lowerEndIdx == -1 && higherBeginIdx != -1) {
                if(higherBeginIdx == 0) {
                    result.add(newInterval);
                } else {
                    newInterval[0] = Math.min(newInterval[0], intervals[0][0]);
                    newInterval[1] = Math.max(newInterval[1], intervals[higherBeginIdx-1][1]);
                    result.add(newInterval);
                }
            } else if(lowerEndIdx != -1 && higherBeginIdx == -1) {
                if(lowerEndIdx == len - 1) {
                    result.add(newInterval);
                } else {
                    newInterval[0] = Math.min(newInterval[0], intervals[lowerEndIdx+1][0]);
                    newInterval[1] = Math.max(newInterval[1], intervals[len-1][1]);
                    result.add(newInterval);
                }
            } else if(lowerEndIdx != -1 && higherBeginIdx != -1) {
                if(lowerEndIdx + 1 == lowerEndIdx) {
                    result.add(newInterval);
                } else {
                    newInterval[0] = Math.min(newInterval[0], intervals[lowerEndIdx+1][0]);
                    newInterval[1] = Math.max(newInterval[1], intervals[higherBeginIdx-1][1]);
                    result.add(newInterval);
                }
            }

        }

        if(higherBeginIdx != -1) {
            for(int i = higherBeginIdx; i < len; i++) {
                result.add(intervals[i]);
            }
        }


        return result.toArray(new int[result.size()][2]);

    }

    // find interval with biggest end value that lower than passed value
    // using binary search
    int lowerEndIdx(int value, int[][] intervals) {
        int len = intervals.length;

        int from = 0;
        int to = len - 1;

        int result = -1;

        for(;from <= to;) {
            int middle = (from + to) / 2;

            int middleValue = intervals[middle][1];

            if(middleValue >= value) {
                to = middle - 1;
            } else if(middleValue < value) {
                result = middle;
                from = middle + 1;
            }
        }
        return result;
    }

    //index of interval with smallest begin value that greater then end of new interval
    int higherBeginIdx(int value, int[][] intervals) {
        int len = intervals.length;

        int from = 0;
        int to = len - 1;

        int result = -1;

        for(;from <= to;) {
            int middle = (from + to) / 2;

            int middleValue = intervals[middle][0];
            if(middleValue > value) {
                result = middle;
                to = middle - 1;
            } else if(middleValue <= value) {
                from = middle + 1;
            }
        }
        return result;
    }
}
