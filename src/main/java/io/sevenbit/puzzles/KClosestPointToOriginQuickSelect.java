package io.sevenbit.puzzles;

/**
 * Leetcode 973. K Closest Points to Origin
 */
public class KClosestPointToOriginQuickSelect {

    public int[][] kClosest(int[][] points, int k) {

        if (k == points.length) return points;
        int left = 0;
        int right = points.length - 1;
        while (left < right) {
            int kth = partition(points, left, right);
            if (kth == k) {
                return subarray(points, k);
            } else if (kth < k) {
                left = kth;
            } else if (kth > k) {
                right = kth - 1;
            }
        }
        return subarray(points, k);
    }


    public int[][] subarray(int[][] points, int k) {
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }
        return result;
    }


    public int partition(int[][] points, int begin, int end) {
        int curLen = len2(points[end]);
        int i = begin - 1; //index of smaller elements
        for (int j = begin; j <= end - 1; j++) {
            int[] p = points[j];
            if (len2(p) <= curLen) {
                i++;
                swap(i, j, points);
            }
        }
        swap(i + 1, end, points);
        return i + 1;
    }


    public void swap(int i, int j, int[][] points) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    public int len2(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }


}
