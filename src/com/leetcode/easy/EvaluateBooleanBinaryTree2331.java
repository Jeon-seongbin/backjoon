package com.leetcode.easy;

public class EvaluateBooleanBinaryTree2331 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 2;

        treeNode.left = new TreeNode();
        treeNode.left.val = 1;

        treeNode.right = new TreeNode();
        treeNode.right.val = 3;

        treeNode.right.left = new TreeNode();
        treeNode.right.left.val = 0;

        treeNode.right.right = new TreeNode();
        treeNode.right.right.val = 1;

        boolean result = evaluateTree(treeNode);
        System.out.println(result);
    }

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

    public static boolean evaluateTree(TreeNode root) {
        int result = dfs(root);
        if (result == 1) {
            return true;
        }
        return false;
    }

    public static int dfs(TreeNode root) {

        int left = 0;
        int right = 0;
        if (root.left == null && root.right == null) {
            return root.val;
        }

        if (root.left != null) {
            left = dfs(root.left);
        }

        if (root.right != null) {
            right = dfs(root.right);
        }

        //2 represents the boolean OR
        if (root.val == 2) {

            if (left == 0 && right == 0) {
                return 0;
            }
            return 1;
        }

        // 3 represents the boolean AND.
        if (left == 1 && right == 1) {
            return 1;
        }
        return 0;
    }


}
