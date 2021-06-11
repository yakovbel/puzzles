package io.sevenbit.puzzles;

/**
 * Leetcode 108. Convert Sorted Array to Binary Search Tree
 */
public class SortedArrayToBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return toBST(0, nums.length - 1, nums);
    }

    TreeNode toBST(int start,int end,int nums[]) {
        if(start > end) return null;
        int middle = (start + end) / 2;
        int middleValue = nums[middle];
        TreeNode node = new TreeNode(middleValue);
        node.left = toBST(start, middle - 1, nums);
        node.right = toBST(middle + 1, end, nums);

        return node;
    }

}
