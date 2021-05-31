package io.sevenbit.puzzles;

/**
 * Leetcode 124. Binary Tree Maximum Path Sum
 */
public class BinaryTreeMaximumPathSum {
    
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    
    static int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        matPathSumInner(root);
        return maxSum;

    }

    public int matPathSumInner(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sumLeft = matPathSumInner(root.left);
        int sumRight = matPathSumInner(root.right);

        if(sumLeft + root.val + sumRight > maxSum) {
            maxSum = sumLeft + root.val + sumRight;
        }

        if(sumLeft + root.val > sumRight + root.val && sumLeft + root.val > root.val) {
            if(sumLeft + root.val > maxSum) {
                maxSum = sumLeft + root.val;
            }
            return sumLeft + root.val;
        } else if(sumRight + root.val >= sumRight + root.val && sumRight + root.val >= root.val) {
            if(sumRight + root.val > maxSum) {
                maxSum = sumRight + root.val;
            }
            return sumRight + root.val;
        } else {
            if(root.val > maxSum) {
                maxSum = root.val;
            }
            return root.val;
        }
    }
}
