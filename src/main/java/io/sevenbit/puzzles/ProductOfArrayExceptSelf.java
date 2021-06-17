package io.sevenbit.puzzles;

/** Leetcode 238. Product of Array Except Self **/
public class ProductOfArrayExceptSelf {
    /*

   x1 x2 x3 x4 x5 x6

   x1 x1x2 x1x2x3 x1x2x3x4 x1x2x3x4x5  x

   x6 x6x5 x6x5x4 x6x5x4x3 x6x5x4x3x2  x

   x2x3x4x5x6

   */
    /*
    [1,2]
    [2,1]

    result[0] = 1
    len = 2
    result[1] = 1 * 2 = 2
    result:  1,2
    nums:    2,2
    nums[0] = 2
    nums[1] = 1 - ok

    [-1,1,0,-3,3]
    result:
    result: -1 -1 0 0 0
    nums:    0  0 0-9 3
    nums[0] = 0
    nums[1] = 0
    nums[2] = 9
    nums[3] = 0
    nums[4] = 0 - ok

    */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        result[0] = nums[0];



        //x1 x1x2 x1x2x3 x1x2x3x4 x1x2x3x4x5  x

        for(int i = 1; i < len; i++) {
            result[i] = result[i-1] * nums[i];
        }

        //len-1                               0
        //x6 x6x5 x6x5x4 x6x5x4x3 x6x5x4x3x2  x

        for(int i = len - 2; i >= 0; i--) {
            nums[i] = nums[i+1] * nums[i];
        }

        nums[0] = nums[1];
        for(int i = 1; i < len - 1; i++) {
            nums[i] = nums[i+1] * result[i-1];
        }
        nums[len-1] = result[len-2];
        return nums;

    }
    /*
    Input: nums = [1,2,3,4]
    result[0] = 1
    len = 4
    result: 1 2 6 24
    nums:  24 24 12 4

    nums[0] = 24
    nums[1] = 12 * 1 = 12
    nums[2] = 4 * 2 = 8
    nums[3] = 6


    */

}
