package io.sevenbit.puzzles;

import java.util.LinkedList;

/**
 * Leetcode 230. Kth Smallest Element in a BST
 */
public class KthSmallestInBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    static class Context {
        boolean smallestFound = false;
        int index = 0;

    }

    public int kthSmallest(TreeNode root, int k) {
        Context context = new Context();
        TreeNode kth = inner(root, context, k);
        if (kth != null) {
            return kth.val;
        }
        return 0;
    }


    TreeNode inner(TreeNode root, Context context, int k) {
        if (root == null) return null;

        if (root.left == null) {
            if (k == 1) return root;

            context.smallestFound = true;
        }


        TreeNode node = inner(root.left, context, k);
        if (node != null) return node;

        context.index += 1;

        if (context.smallestFound && context.index == k) {
            return root;
        }

        node = inner(root.right, context, k);
        if (node != null) return node;

        return null;
    }

    public int kthSmallestItertative(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

    public int test(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }

    }

}
