package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal144 {
    public static void main(String[] args) {
    }

    public static List<Integer> preorderTraversal(TreeNode144 root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.add(root.val);
        if (root.left != null) {
            List<Integer> tempLeft = preorderTraversal(root.left);
            for (int i = 0; i < tempLeft.size(); i++) {
                result.add(tempLeft.get(i));
            }

        }
        if (root.right != null) {
            List<Integer> tempRight = preorderTraversal(root.right);
            for (int i = 0; i < tempRight.size(); i++) {
                result.add(tempRight.get(i));
            }
        }


        return result;

    }
}

class TreeNode144 {
    int val;
    TreeNode144 left;
    TreeNode144 right;

    TreeNode144() {
    }

    TreeNode144(int val) {
        this.val = val;
    }

    TreeNode144(int val, TreeNode144 left, TreeNode144 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}