package io.sevenbit.puzzles;

public class LargestBSTSubtree {
    public static class TreeNode {
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

    static int best = 0;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        best = 0;
        preOrder(root);
        return best;
    }

    class Range {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        boolean isBST;
        int size;

        public Range(int min, int max, boolean isBST, int size) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
            this.size = size;
        }

    }


    public Range preOrder(TreeNode root) {
        if(root == null) return new Range(Integer.MAX_VALUE,Integer.MIN_VALUE, true, 0);

        Range left = preOrder(root.left);
        Range right = preOrder(root.right);
        boolean isBST = false;
        int size = left.size + right.size + 1;
        if(left.isBST && right.isBST) {
            if(left.max < root.val && right.min > root.val) {
                isBST = true;
                if(best < size) {
                    best = size;
                }
            }
        }
        int min = left.min < right.min ? left.min : right.min;
        min = root.val < min ? root.val : min;
        int max = left.max < right.max ? right.max : left.max;
        max = root.val < max ? max : root.val;
        return new Range(min, max, isBST, size);

    }


}
