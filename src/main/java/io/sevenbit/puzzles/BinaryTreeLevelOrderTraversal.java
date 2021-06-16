package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Leetcode 102. Binary Tree Level Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {

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

        class Level {
            TreeNode node;
            int level;

            public Level(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return new ArrayList(0);
            Queue<Level> q = new LinkedList<>();
            q.add(new Level(root, 0));
            Map<Integer, List<Integer>> result = new HashMap<>();
            while (!q.isEmpty()) {
                Level levelNode = q.remove();
                TreeNode node = levelNode.node;
                int level = levelNode.level;
                if (!result.containsKey(level)) {
                    result.put(level, new ArrayList<>());
                }
                result.get(level).add(node.val);

                if (node.left != null) {
                    q.add(new Level(node.left, level + 1));
                }

                if (node.right != null) {
                    q.add(new Level(node.right, level + 1));
                }

            }
            return new ArrayList<>(result.values());
        }
    }
}
