package com.leetcode.midium;

import java.util.ArrayList;

public class SumRootToLeafNumbers129 {

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

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();

        treeNode.val = 1;


        treeNode.left = new TreeNode();
        treeNode.left.val = 2;


        treeNode.right = new TreeNode();
        treeNode.right.val = 3;

        int a = sumNumbers(treeNode);
        System.out.println(a);
    }

    public static int sumNumbers(TreeNode root) {

        ArrayList<String> a = dfs(root, ""+ root.val, new ArrayList<>());
        int sum = a.stream().map(obj -> Integer.parseInt(obj)).mapToInt(aa -> aa).sum();
        return sum;
    }

    public static ArrayList<String> dfs(TreeNode treeNode, String element, ArrayList<String> arrayList) {


        if (treeNode.left == null && treeNode.right == null) {
            arrayList.add(element);
            return arrayList;
        }

        if (treeNode.left != null) {
            String left = element + treeNode.left.val;
            dfs(treeNode.left, left, arrayList);
        }

        if (treeNode.right != null) {
            String right = element + treeNode.right.val;
            dfs(treeNode.right, right, arrayList);
        }
        return arrayList;
    }


}
