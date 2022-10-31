package com.leetcode.easy;

public class MaximumDepthOfBinaryTree104 {
    public int result = 1;

    public int maxDepth(TreeNode104 root) {
        if (root == null) {
            return 0;
        }

        dfs(root, result);
        return result;
    }

    public void dfs(TreeNode104 node, int depth) {
        if (node.left != null) {
            dfs(node.left, depth + 1);
        }
        if (node.right != null) {
            dfs(node.right, depth + 1);
        }
        result = Math.max(depth, result);
    }
}

class TreeNode104 {
    int val;
    TreeNode104 left;
    TreeNode104 right;

    TreeNode104() {
    }

    TreeNode104(int val) {
        this.val = val;
    }

    TreeNode104(int val, TreeNode104 left, TreeNode104 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}