package io.sevenbit.puzzles.algo;

import java.util.ArrayList;
import java.util.List;

public class LowerBound {

    /**
     * [[],[40],[],[12],[],[16],[],[14],[],[35],[],[19],[],[34],[],[35],[],[28],[],[35],[],[26],[],[6],[],[8],[],[2],[],[14],[],[25],[],[25],[],[4],[],[33],[],[18],[],[10],[],[14],[],[27],[],[3],[],[35],[],[13],[],[24],[],[27],[],[14],[],[5],[],[0],[],[38],[],[19],[],[25],[],[11],[],[14],[],[31],[],[30],[],[11],[],[31],[],[0],[]]
     *
     * @param args
     */

    public static void main(String args[]) {
        var items = new ArrayList<Integer>();
        insert(items, 40);
        System.out.println(findMedian(items));
        insert(items, 12);
        System.out.println(findMedian(items));
        insert(items, 16);
        System.out.println(findMedian(items));
        insert(items, 14);
        System.out.println(findMedian(items));
        insert(items, 35);
        System.out.println(findMedian(items));
        insert(items, 19);
        System.out.println(findMedian(items));
        insert(items, 34);
        System.out.println(findMedian(items));
        insert(items, 35);

        insert(items, 28);
        System.out.println(findMedian(items));

    }

    //0
    //returns last index lower than num
    public static int lowerBound(List<Integer> items, int num) {
        if (items.isEmpty()) return -1;
        int left = 0;
        int right = items.size() - 1;
        int lower = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int middleVal = items.get(middle);
            if(middleVal < num) {
                lower = middle;
                left = middle + 1;
            } else if(middleVal > num) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return lower;
    }

    public static void insert(List<Integer> items, int num) {
        int idx = lowerBound(items, num);
        if (idx == items.size()) {
            items.add(num);
        } else {
            items.add(idx + 1, num);
        }
        StringBuilder sb = new StringBuilder();
        for (int val : items) {
            sb.append(val).append(",");
        }
        System.out.println(sb.toString());
    }

    public static double findMedian(List<Integer> items) {
        int len = items.size();
        if (len % 2 == 1) {
            return items.get(len / 2);
        } else {
            //len = 2: 0 1, 1,2
            //len = 4: 0 1 2 3, 2
            return (items.get((len - 1) / 2) + items.get((len + 1) / 2)) / 2.;
        }
    }
}
