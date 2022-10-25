package com.leetcode.midium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeLevelOrderTraversal102 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 3;

        treeNode.left = new TreeNode();
        treeNode.left.val = 9;


        treeNode.right = new TreeNode();
        treeNode.right.val = 20;


        treeNode.right = new TreeNode();
        treeNode.right.val = 20;

        treeNode.right.left = new TreeNode();
        treeNode.right.left.val = 15;

        treeNode.right.right = new TreeNode();
        treeNode.right.right.val = 7;
        levelOrder(treeNode);
    }

    public static HashMap<Integer, List<Integer>> hashMap;

    public static List<List<Integer>> levelOrder(TreeNode root) {
        hashMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        dfs(root, 1);

        for (int level = 1; level <= hashMap.size(); level++) {
            result.add(hashMap.get(level));
        }

        return result;
    }

    public static void dfs(TreeNode root, int level) {
        List<Integer> temp = new ArrayList<>();
        if (!hashMap.containsKey(level)) {
            temp.add(root.val);
            hashMap.put(level, temp);
        } else {
            temp = hashMap.get(level);
            temp.add(root.val);
            hashMap.put(level, temp);
        }


        if (root.left != null) {
            dfs(root.left, level + 1);
        }

        if (root.right != null) {
            dfs(root.right, level + 1);
        }
    }

}

//  Definition for a binary tree node.
class TreeNode {
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
