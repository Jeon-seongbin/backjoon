package com.leetcode.midium;

import java.util.HashMap;
import java.util.List;

public class FindLargestValueinEachTreeRow515 {
    public static void main(String[] args) {
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

    public static HashMap<Integer, Integer> hashMap;

    public static List<Integer> largestValues(TreeNode root) {
        hashMap = new HashMap<>();
        dfs(root, Integer.MIN_VALUE, hashMap);
        return hashMap.values().stream().toList();
    }

    public static void dfs(TreeNode root, int depth, HashMap<Integer, Integer> hashMap) {

        if (root == null) {
            return;
        }

        int val = hashMap.getOrDefault(depth, Integer.MIN_VALUE);

        if (val <= root.val) {
            hashMap.put(depth, root.val);
        }

        dfs(root.left, depth + 1, hashMap);
        dfs(root.right, depth + 1, hashMap);
    }
}
