package io.sevenbit.puzzles;

/**
 * LeetCode 104. Maximum Depth of Binary Tree
 */
public class MaximumDepthOfBinaryTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
    }

    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    public int depth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
