package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 15.
 */
public class ThreeSumQuadratic {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {

            if(i > 0 && nums[i-1] == nums[i]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            int iValue = nums[i];
            int sum = -1 * iValue;

            while(left < right) {
                int leftValue = nums[left];
                int rightValue = nums[right];

                int currentSum = leftValue + rightValue;
                if(currentSum > sum) {
                    right--;
                } else if(currentSum < sum) {
                    left++;
                } else if(currentSum == sum) {

                    List<Integer> triplet = new ArrayList<>(3);

                    triplet.add(iValue);
                    triplet.add(leftValue);
                    triplet.add(rightValue);

                    result.add(triplet);

                    left++;

                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                }

            }
        }

        return result;
    }

}
