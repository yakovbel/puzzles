package io.sevenbit.puzzles;

import java.util.Random;

/**
 * 215. Kth Largest Element in an Array
 */
public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) {
            return nums[0];
        }
        int start = 0;
        int end = nums.length - 1;  //1
        int goal = nums.length - k; //1
        while(start < end) { // 0 < 1
            int idx = partition(nums, start, end);
            if(idx == goal) {
                return nums[idx];
            } else if(idx < goal) {
                start = idx + 1;
            } else if(idx > goal) {
                end = idx - 1;
            }
        }
        return nums[start];
    }


    Random r = new Random();
    int partition(int[] nums, int start, int end) {
        //get random pivot to avoid worst case scenario
        int randomIdx = r.nextInt(end+1-start)+start;
        swap(randomIdx, end, nums);
        int pivot = nums[end];

        int border = start; //first element greater or equal then pivot // 0,1,1
        for(int i = start; i < end; i++) {
            if(nums[i] < pivot) {  // 1 < 3, 5 > 3,
                swap(i, border, nums);
                border++; //1,1,2
            }
        }
        swap(end, border, nums);
        return border;
    }

    void swap(int i, int j, int[] nums) {
        if(i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
