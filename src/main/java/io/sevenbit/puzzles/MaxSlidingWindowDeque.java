package io.sevenbit.puzzles;

import java.util.ArrayDeque;

/*
239. Sliding Window Maximum
 */
public class MaxSlidingWindowDeque {

    //O(n) solution with deque. each time element added we perform clean operation:
    //removing indexes that not in current window rom the begginging and indexes lower than current value
    //from the end.
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len == 0 || k == 0) return new int[0];
        if(k == 1) return nums;

        int[] result = new int[len - k + 1];
        var deque = new ArrayDeque<Integer>(k);

        for(int i = 0; i < k; i++) {
            clean(deque, nums, i, k);
            deque.addLast(i);
        }

        result[0] = nums[deque.getFirst()];

        for(int i = k; i < len; i++) {
            clean(deque, nums, i , k);
            deque.addLast(i);
            result[i-k+1] = nums[deque.getFirst()];
        }
        return result;

    }

    //clean operation will produce deque with index of highest element for current window in first position
    public void clean(ArrayDeque<Integer> deque, int[] nums, int i, int k) {
        //remove obsolete element from the beginning
        if(!deque.isEmpty() && deque.getFirst() == i - k) {
            deque.removeFirst();
        }
        //remove indexes with smaller values than current
        while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
            deque.removeLast();
        }
    }
}
