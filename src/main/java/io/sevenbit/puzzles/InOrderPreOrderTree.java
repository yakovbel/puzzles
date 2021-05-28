package io.sevenbit.puzzles;

/**
 * LeetCode 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class InOrderPreOrderTree {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        return buildTree(preorder, inorder, 0, preorder.length);
    }

    static int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (preIdx == preorder.length) return null;
        if (inStart >= inEnd) return null;

        int value = preorder[preIdx++];

        TreeNode node = new TreeNode(value);

        int inIdx = search(inorder, value, inStart, inEnd);
        node.left = buildTree(preorder, inorder, inStart, inIdx);
        node.right = buildTree(preorder, inorder, inIdx + 1, inEnd);

        return node;
    }

    public int search(int[] arr, int value, int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }
}
