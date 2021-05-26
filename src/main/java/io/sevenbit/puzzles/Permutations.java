package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.List;


/**
 * Leetcode 46. Permutations
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 */
public class Permutations {


    public List<List<Integer>> permute(int[] nums) {
        return permuteInner(nums.length-1, nums);
    }

    public List<List<Integer>> permuteInner(int i, int[] nums) {
        if(i == 0) {
            List<Integer> permutationResult = new ArrayList<>(1);
            List<List<Integer>> totalResult = new ArrayList<>(1);
            permutationResult.add(nums[0]);
            totalResult.add(permutationResult);
            return totalResult;
        } else {
            List<List<Integer>> subResult = permuteInner(i-1, nums);
            List<List<Integer>> totalResult = new ArrayList<>();
            for(List<Integer> subPermutation : subResult) {
                for(int pos = 0; pos <= subPermutation.size(); pos++) {
                    List<Integer> copy = new ArrayList<>(subPermutation);
                    copy.add(pos, nums[i]);
                    totalResult.add(copy);
                }
            }
            return totalResult;

        }

    }
}
