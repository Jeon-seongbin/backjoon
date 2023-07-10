package com.leetcode.easy;

public class MinimumDepthOfBinaryTree111 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();

        treeNode.val = 3;
        treeNode.left = new TreeNode();
        treeNode.left.val = 9;


        treeNode.right = new TreeNode();
        treeNode.right.val = 20;


        treeNode.right.left = new TreeNode();
        treeNode.right.left.val = 15;

        treeNode.right.right = new TreeNode();
        treeNode.right.right.val = 15;

        minDepth(treeNode);
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return 1 + Math.min(minDepth(root.right), minDepth(root.left));
        }
    }

    static class TreeNode {
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
}
