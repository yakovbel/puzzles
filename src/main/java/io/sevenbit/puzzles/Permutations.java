package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


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

    /**
     * Same task solved without recoursion (Heap's algorithm)
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteWithoutRecursion(int[] nums) {
        List<int[]> result = new ArrayList<>();
        List<int[]> result2 = new ArrayList<>();

        result.add(nums);

        for(int level = 0; level < nums.length; level++) {
            for(int i = level; i < nums.length; i++) {
                for(int[] prev : result) {
                    int[] perm = swap(level, i, prev);
                    result2.add(perm);
                }
            }
            result = result2;
            result2 = new ArrayList<>();
        }

        List<List<Integer>> returnResult = new ArrayList<>();
        for(int[] r : result) {
            List<Integer> subResult = new ArrayList<>(r.length);
            for(int i = 0; i < r.length; i++) {
                subResult.add(r[i]);
            }
            returnResult.add(subResult);
        }
        return returnResult;
    }

    public int[] swap(int i, int j, int[] nums) {
        int[] copy = new int[nums.length];

        for(int x = 0; x < copy.length; x++) {
            copy[x] = nums[x];
        }

        copy[i] = nums[j];
        copy[j] = nums[i];
        return copy;
    }


    public List<List<Integer>> permuteBacktracking(int[] nums) {
        result = new ArrayList<>();
        backtrack(new HashSet<Integer>(), nums, new LinkedList<>());
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    public void backtrack(Set<Integer> occupied, int[] nums, LinkedList<Integer> r) {
        if(r.size() == nums.length) {
            result.add(new ArrayList(r));
            return;
        }

        for(int i = 0; i < nums.length; i ++) {
            if(!occupied.contains(nums[i])) {
                r.add(nums[i]);
                occupied.add(nums[i]);
                backtrack(occupied, nums, r);
                r.remove(r.size() - 1);
                occupied.remove(nums[i]);
            }
        }
    }
}
