package io.sevenbit.puzzles;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Leetcode 297. Serialize and Deserialize Binary Tree, use InOrder traversal with special symbols for nool children
 */
public class SerializeBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

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

    public class Codec {

        public void pre(TreeNode node, StringBuilder sb) {
            if(node == null) {
                sb.append("#,");
            } else {
                sb.append(node.val + ",");
                pre(node.left, sb);
                pre(node.right, sb);
            }
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            pre(root, sb);
            String result = sb.toString();
            System.out.println(result);
            return result.substring(0, result.length() - 1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arr = data.split(",");

            return restoreTree(arr, new AtomicInteger());
        }


        public TreeNode restoreTree(String[] arr, AtomicInteger counter) {
            if(counter.get() == arr.length) return null;
            String str = arr[counter.get()];
            counter.incrementAndGet();

            if(str.equals("#")) return null;
            int value = Integer.parseInt(str);
            TreeNode root = new TreeNode(value);
            root.left = restoreTree(arr,  counter);
            root.right = restoreTree(arr, counter);

            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
