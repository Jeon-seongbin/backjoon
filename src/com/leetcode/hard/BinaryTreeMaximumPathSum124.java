package com.leetcode.hard;

public class BinaryTreeMaximumPathSum124 {
    public static void main(String[] args) {

        TreeNode124 treeNode124 = new TreeNode124();
        treeNode124.val = 2;

        treeNode124.left = new TreeNode124();
        treeNode124.left.val = -1;
        treeNode124.right = new TreeNode124();
        treeNode124.right.val = -2;
        System.out.println(maxPathSum(treeNode124));


        treeNode124 = new TreeNode124();
        treeNode124.val = 1;

        treeNode124.left = new TreeNode124();
        treeNode124.left.val = 2;

        treeNode124.left.left = new TreeNode124();
        treeNode124.left.left.val = 3;

        treeNode124.left.left.left = new TreeNode124();
        treeNode124.left.left.left.val = 4;

        treeNode124.left.left.left.left = new TreeNode124();
        treeNode124.left.left.left.left.val = 5;
        System.out.println(maxPathSum(treeNode124));


        treeNode124 = new TreeNode124();
        treeNode124.val = -10;

        treeNode124.left = new TreeNode124();
        treeNode124.left.val = 9;
        treeNode124.right = new TreeNode124();
        treeNode124.right.val = 20;


        treeNode124.right.left = new TreeNode124();
        treeNode124.right.left.val = 15;

        treeNode124.right.right = new TreeNode124();
        treeNode124.right.right.val = 7;


        System.out.println(maxPathSum(treeNode124));

        treeNode124 = new TreeNode124();
        treeNode124.val = 1;

        treeNode124.left = new TreeNode124();
        treeNode124.left.val = 2;
        System.out.println(maxPathSum(treeNode124));

    }


    public static int max = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode124 root) {

        return dfs(root);
    }

    public static int dfs(TreeNode124 root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int temp = Math.max(Math.max(left + root.val, right + root.val), root.val);

//        max = Math.max(Math.max(temp, max), left + right + root.val);

        return temp;
    }
}


class TreeNode124 {
    int val;
    TreeNode124 left;
    TreeNode124 right;

    TreeNode124() {
    }

    TreeNode124(int val) {
        this.val = val;
    }

    TreeNode124(int val, TreeNode124 left, TreeNode124 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
