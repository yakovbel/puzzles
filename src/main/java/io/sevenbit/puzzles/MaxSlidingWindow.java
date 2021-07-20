package io.sevenbit.puzzles;

import java.util.TreeMap;

/**
 * 239. Sliding Window Maximum
 */
public class MaxSlidingWindow {

    //O(nlogk) complexity using redblack tree
    //we use treemap instead o treeset to save number of occurences for each number

    public int[] maxSlidingWindowTreeMap(int[] nums, int k) {

        TreeMap<Integer,Integer> map = new TreeMap<>();

        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
        }
        for(int i = 0; i < result.length; i++) {
            int maxKey = map.lastKey();
            result[i] = maxKey;
            if(i+k < nums.length) {
                //remove/decreaase count for first element in sliding window
                int count = map.get(nums[i]);
                if(count == 1) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], count - 1);
                }
                //add new element to sliding window
                count = map.getOrDefault(nums[i+k], 0);
                map.put(nums[i+k], count + 1);
            } else {
                break;
            }
        }
        return result;
    }
}
