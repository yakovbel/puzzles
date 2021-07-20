package io.sevenbit.puzzles;

import java.util.Random;

public class TryBinSearch {

    public static void main(String[] args) {

        int[] nums = new int[]{2,3, 10};
        check(2, 10, nums);
        check(1, 3, nums);
        nums = new int[]{-53,-1,2,3,3,4, 100};
        check(5,4, nums);
    }

    public static void check(int expected, int value, int nums[]) {
        int real = binarySearchFind(value, nums);
        if(real != expected) {
            throw new RuntimeException("real: " + real);
        }
    }

    public static int binarySearchFind(int value, int[] nums) {
       return binarySearchFind(value, nums, 0, nums.length - 1);
    }

    final static Random r = new Random();
    //[] = ok
    //[1], 1: ok
    //[1], -1: ok
    //[1,2]
    //10,3,2

    public static int binarySearchFind(int value, int[] nums, int start, int end) {
        if(nums.length == 0) return 0;
        while(start <= end) {
            int pivot = r.nextInt(end - start + 1) + start; //2, nums[2] = 2
            if(nums[pivot] < value) { //2<10
                start = pivot + 1;
            } else if(nums[pivot] > value) {
                end = pivot - 1;
            } else {
                return pivot;
            }
        }
        return -1;
    }
}
