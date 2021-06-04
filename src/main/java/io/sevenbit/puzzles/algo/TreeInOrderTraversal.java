package io.sevenbit.puzzles.algo;

import com.sun.source.tree.Tree;

import java.util.Stack;

/**
 * Harry He. Question 18. Given a node in a binary tree, please implement a function to retrieve its next node in the in - order traversal sequence. There is a pointer to the parent node in each tree node.
 * <p>
 * IN ORDER: left - root - right
 * <p>
 * SOLUTION:
 * If a node has a right child, its next node is the most left child of the right subtree
 * If node doesn't have a right child, its next node is its parent if it is the left child of its parent.
 * If node doen't have a right child and its the left node of it's parent:
 * go up to the parent until reaches the node that is the left child of its parent. the parent is the next node if such node exists
 */
public class TreeInOrderTraversal {

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int key) {
            value = key;
        }
    }


    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        //traverse the tree
        while (current != null || stack.size() > 0) {
            //reach the left most node of the currnt node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            //current must be null at (before) this point
            current = stack.pop();
            System.out.println(current.value);
            //we have visited the node and its left subtree
            current = current.right;
        }
    }

    static TreeNode insert(int key) {
        TreeNode root = insertRec(null, key);
        return root;

    }

    static TreeNode insertRec(TreeNode root, int key) {
        if(root == null) {
            root = new TreeNode(key);
            return root;
        }
        if(key < root.value) {
            root.left = insertRec(root.left, key);
        } else if(key > root.value) {
            root.right = insertRec(root.right, key);
        }
        return root;

    }


}
