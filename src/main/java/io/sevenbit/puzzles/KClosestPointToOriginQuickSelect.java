package io.sevenbit.puzzles;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 973. K Closest Points to Origin
 */
public class KClosestPointToOriginQuickSelect {

    public int[][] kClosest(int[][] points, int k) {

        if(k == points.length) return points;
        //create map points to lengths squared
        Map<int[], Integer> lens = new HashMap<>();
        for(int[] p : points) {
            lens.put(p, len2(p));
        }

        int[][] result = kthPercentile(points, lens, k);
        return result;
    }


    public int[][] kthPercentile(int[][] points, Map<int[], Integer> lens, int k) {
        int left = 0;
        int right = lens.size() - 1;
        while(left < right) {
            int kth = partition(points, lens, left, right);
            if(kth == k) {
                return subarray(points, k);
            } else if(kth < k) {
                left = kth;
            } else if(kth > k) {
                right = kth-1;
            }
        }
        return subarray(points, k);
    }

    public int[][] subarray(int[][] points, int k) {
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++) {
            result[i] = points[i];
        }
        return result;
    }



    public int partition(int[][] points, Map<int[], Integer> lens, int begin, int end) {
        int curLen = lens.get(points[end]);
        int i = begin - 1; //index of smaller elements
        for(int j = begin; j <= end - 1; j++) {
            int[] p = points[j];
            if(lens.get(p) <= curLen) {
                i++;
                swap(i,j, points);
            }
        }
        swap(i+1, end, points);
        return i+1;
    }


    public void swap(int i, int j, int[][] points) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    public int len2(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }

}
