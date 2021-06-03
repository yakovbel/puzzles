package io.sevenbit.puzzles;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
    }
    class LevelNode {
        int level;
        TreeNode node;

        public LevelNode(TreeNode node, int level) {
            this.level = level;
            this.node = node;
        }
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<LevelNode> queue = new LinkedList<>();
        queue.add(new LevelNode(root, 1));
        while(!queue.isEmpty()) {
            LevelNode l = queue.remove();
            TreeNode node = l.node;
            if(node.left == null && node.right == null)
                return l.level;
            if(node.left != null) {
                queue.add(new LevelNode(node.left, l.level+1));
            }
            if(node.right != null) {
                queue.add(new LevelNode(node.right, l.level+1));
            }

        }
        return -1;
    }

    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return 1;
        }
        if(root.left == null) {
            return minDepth(root.right) + 1;
        } else if(root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
