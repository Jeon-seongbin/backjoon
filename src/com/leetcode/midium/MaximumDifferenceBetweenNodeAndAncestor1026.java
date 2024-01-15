package com.leetcode.midium;

public class MaximumDifferenceBetweenNodeAndAncestor1026 {
    public static void main(String[] args) {

    }

    int diff = 0;

    public int maxAncestorDiff(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int min = 0;
        int max = 0;
        diff(root,min,max);
        return diff;
    }

    public void diff(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }

        diff = Math.max(diff, Math.max(Math.abs(max - root.val), Math.abs(min - root.val)));

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        diff(root.right, min, max);
        diff(root.left, min, max);

    }
}
