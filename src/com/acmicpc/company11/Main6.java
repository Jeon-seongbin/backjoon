package com.acmicpc.company11;

public class Main6 {
    public static void main(String[] args) {
        int[] insert = new int[7];

        insert[0] = 3;
        insert[1] = 9;
        insert[2] = 20;
//        insert[3]= 3;
//        insert[4]= 3;
        insert[5] = 15;
        insert[6] = 7;

        TreeNode treeNode = new TreeNode(3);

        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        maxDepth(treeNode);
    }

    static public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}

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

// root = [3,9,20,null,null,15,7]