package com.leetcode.midium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AllNodesDistanceKInBinaryTree863 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    HashMap<TreeNode, TreeNode> hashMap;
    ArrayList<Integer> arrayList;

    HashSet<TreeNode> isVisited;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        arrayList = new ArrayList<>();
        isVisited = new HashSet<>();
        hashMap = new HashMap<>();
        createRoot(root);
        dfs(target, k);
        return arrayList;
    }

    public void createRoot(TreeNode root) {
        if (root.left != null) {
            hashMap.put(root.left, root);
            createRoot(root.left);
        }

        if (root.right != null) {
            hashMap.put(root.right, root);
            createRoot(root.right);
        }
    }

    public void dfs(TreeNode target, int k) {
        if (target == null || isVisited.contains(target)) {
            return;
        }
        if (k == 0) {
            arrayList.add(target.val);
            return;
        }

        isVisited.add(target);
        dfs(hashMap.get(target), k - 1);
        dfs(target.left, k - 1);
        dfs(target.right, k - 1);
    }
}
