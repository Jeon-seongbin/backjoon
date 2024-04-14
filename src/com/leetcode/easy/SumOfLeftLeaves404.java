package com.leetcode.easy;

public class SumOfLeftLeaves404 {
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

    public static void main(String... args) {
        TreeNode treeNode = new TreeNode();

        treeNode.val = 3;

        treeNode.left = new TreeNode();
        treeNode.left.val = 9;

        treeNode.left.left = new TreeNode();
        treeNode.left.left.val = 1;

        treeNode.right = new TreeNode();
        treeNode.right.val = 20;

        treeNode.right.left = new TreeNode();
        treeNode.right.left.val = 15;

        treeNode.right.right = new TreeNode();
        treeNode.right.right.val = 7;

        int result = sumOfLeftLeaves(treeNode);
        System.out.println(result);
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        int result = helper(root, 0, false);
        return result;
    }

    public static int helper(TreeNode root, int sum, boolean isLeft) {
        if (isLeft) {
            if (root.left == null && root.right == null) {
                sum += root.val;
            }

        }

        if (root.left != null) {
            sum = helper(root.left, sum, true);
        }

        if (root.right != null) {
            sum = helper(root.right, sum, false);
        }

        return sum;
    }

}
