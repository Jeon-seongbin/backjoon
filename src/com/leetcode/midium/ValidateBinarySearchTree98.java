package com.leetcode.midium;

import java.util.Stack;

public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {

    }

    public static boolean isValidBST(TreeNode98 root) {
        Stack<TreeNode98> stack = new Stack<>();
        double left_child_val = -Double.MAX_VALUE;

        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.val <= left_child_val) {
                return false;
            }
            left_child_val = root.val;
            root = root.right;
        }
        return true;
    }
}

class TreeNode98 {
    int val;
    TreeNode98 left;
    TreeNode98 right;

    TreeNode98() {
    }

    TreeNode98(int val) {
        this.val = val;
    }

    TreeNode98(int val, TreeNode98 left, TreeNode98 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}