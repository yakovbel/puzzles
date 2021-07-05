package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetode 210. Course Schedule II
 */
public class CourseSchedule2 {
    static int white = 0;
    static int grey = 1;
    static int black = 2;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //build all mappings
        Map<Integer, List<Integer>> prevs = new HashMap<>();
        for (int[] item : prerequisites) {  // 0 -> 1
            prevs.putIfAbsent(item[0], new ArrayList<>(1));
            prevs.get(item[0]).add(item[1]);
        }
        //track visited nodes
        int[] colors = new int[numCourses];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) { //0, 1
            if (colors[i] == white) {
                boolean noCycle = dfs(i, result, colors, prevs);
                if (!noCycle) return new int[0];
            }
        }
        int[] arr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    private boolean dfs(int i, List<Integer> result, int[] colors, Map<Integer, List<Integer>> adj) {
        colors[i] = grey; //colors[0] = 1
        List<Integer> prevs = adj.get(i);
        if (prevs != null) {
            for (int prev : prevs) {
                if (colors[prev] == white) {
                    colors[prev] = grey;
                    boolean withoutCycle = dfs(prev, result, colors, adj);
                    if (!withoutCycle) return false;
                } else if (colors[prev] == grey) {
                    return false;
                }
            }
        }
        colors[i] = black;
        result.add(i);
        return true;
    }
}
