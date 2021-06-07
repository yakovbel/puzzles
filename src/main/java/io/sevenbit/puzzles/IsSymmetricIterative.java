package io.sevenbit.puzzles;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 101. Symmetric Tree
 */
public class IsSymmetricIterative {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(root);
        q2.add(root);
        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            if(n2 == null && n1 == null) continue;
            if((n1 == null && n2 != null) || (n1 != null && n2 == null)) return false;
            if(n1.val != n2.val) return false;
            q1.add(n1.left);
            q2.add(n2.right);
            q1.add(n1.right);
            q2.add(n2.left);

        }
        return q1.size() == q2.size();
    }
}
