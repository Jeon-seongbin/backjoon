package com.leetcode.easy;

import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class MinimumAbsoluteDifferenceinBST530 {
    public static void main(String[] args) {
        TreeNode530 treeNode530 = new TreeNode530();
        treeNode530.val = 1;
        treeNode530.right = new TreeNode530();
        treeNode530.right.val = 5;
        treeNode530.right.left = new TreeNode530();
        treeNode530.right.left.val = 3;
        getMinimumDifference(treeNode530);
    }


    public static int min = Integer.MAX_VALUE;
    public static TreeNode530 prev;
    public static int getMinimumDifference(TreeNode530 root) {
        dfs(root);
        return min;
    }

    public static void dfs(TreeNode530 treeNode) {
        if(treeNode == null){
            return;
        }
        dfs(treeNode.left);

        if(prev != null){
            min = Math.min(min , treeNode.val - prev.val);
        }

        prev = treeNode;
        dfs(treeNode.right);

    }


}

class TreeNode530 {
    int val;
    TreeNode530 left;
    TreeNode530 right;

    TreeNode530() {
    }

    TreeNode530(int val) {
        this.val = val;
    }

    TreeNode530(int val, TreeNode530 left, TreeNode530 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}