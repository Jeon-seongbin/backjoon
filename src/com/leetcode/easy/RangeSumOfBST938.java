package com.leetcode.easy;

public class RangeSumOfBST938 {
    public static void main(String[] args) {

        TreeNode938 treeNode938 = new TreeNode938();
        treeNode938.val = 10;

        treeNode938.left = new TreeNode938();
        treeNode938.left.val = 5;

        treeNode938.right = new TreeNode938();
        treeNode938.right.val = 15;

        treeNode938.left.left = new TreeNode938();
        treeNode938.left.left.val = 3;

        treeNode938.left.right = new TreeNode938();
        treeNode938.left.right.val = 7;

        rangeSumBST(treeNode938, 7, 15);
    }

    public static int rangeSumBST(TreeNode938 root, int low, int high) {

        dfs(root, low, high);
        return result;
    }

    public static int result = 0;

    public static void dfs(TreeNode938 treeNode938, int low, int high) {

        if (treeNode938 == null) {
            return;
        }
        if (low <= treeNode938.val && treeNode938.val <= high) {
            result += treeNode938.val;
        }

        dfs(treeNode938.left, low, high);


        dfs(treeNode938.right, low, high);

    }
}


class TreeNode938 {
    int val;
    TreeNode938 left;
    TreeNode938 right;

    TreeNode938() {
    }

    TreeNode938(int val) {
        this.val = val;
    }

    TreeNode938(int val, TreeNode938 left, TreeNode938 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}