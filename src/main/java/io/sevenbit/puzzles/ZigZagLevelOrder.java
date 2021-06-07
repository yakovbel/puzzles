package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 103. Binary Tree Zigzag Level Order Traversal
 */
public class ZigZagLevelOrder {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>(0);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> result = new ArrayList<>();
        boolean even = true;
        while(!q.isEmpty()) {
            List<TreeNode> levelList = new ArrayList<>();
            do {
                TreeNode n = q.poll();
                levelList.add(n);
            } while(!q.isEmpty());

            if(levelList.isEmpty()) return result;
            List<Integer> levelResult = new ArrayList<>(levelList.size());

            for(int i = 0; i < levelList.size(); i++) {
                TreeNode n = levelList.get(i);
                if(n.left != null) {
                    q.add(n.left);
                }
                if(n.right != null) {
                    q.add(n.right);
                }
                if(even) {
                    levelResult.add(n.val);
                } else {
                    levelResult.add(levelList.get(levelList.size()-1-i).val);
                }
            }
            even = !even;
            result.add(levelResult);

        }
        return result;

    }
}
