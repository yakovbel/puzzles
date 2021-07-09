package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.List;

/*
    295. Find Median from Data Stream
 */
public class StreamMedianLog {

    List<Integer> items = new ArrayList<>();
    public StreamMedianLog() {

    }

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

    public void addNum(int num) {
        int idx = lowerBound(items, num);
        if(idx == items.size()) {
            items.add(num);
        } else {
            items.add(idx+1, num);
        }
    }


    public double findMedian() {
        int len = items.size();
        if(len % 2 == 1) {
            return items.get(len/2);
        } else {
            //len = 2: 0 1, 1,2
            //len = 4: 0 1 2 3, 2
            return (items.get((len-1)/2) + items.get((len+1)/2))/2.;
        }
    }

}
