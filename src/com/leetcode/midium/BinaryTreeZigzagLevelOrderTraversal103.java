package com.leetcode.midium;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public static void main(String[] args) {
        TreeNode103 t = new TreeNode103();
        t.val = 3;
        t.left = new TreeNode103();
        t.left.val = 9;
        t.right = new TreeNode103();
        t.right.val = 20;

        t.right.left = new TreeNode103();
        t.right.left.val = 15;
        t.right.right = new TreeNode103();
        t.right.right.val = 7;

        zigzagLevelOrder(t);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode103 root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        boolean isRightToLeft = true;
        Queue<TreeNode103> queue = new LinkedList<>();
        queue.add(root);


        while(!queue.isEmpty()){
            int currentDepthOfSize = queue.size();
            ArrayList<Integer> innerList= new ArrayList<>();

            for(int i = 0 ; i < currentDepthOfSize; i++){
                TreeNode103 now = queue.poll();
                if(now.left != null){
                    queue.add(now.left);
                }
                if(now.right != null){
                    queue.add(now.right);
                }
                innerList.add(now.val);
            }
            if(isRightToLeft){
                Collections.reverse(innerList);
            }
            result.add(innerList);
            isRightToLeft = !isRightToLeft;
        }

        return result;
    }
}

class TreeNode103 {
    int val;
    TreeNode103 left;
    TreeNode103 right;

    TreeNode103() {
    }

    TreeNode103(int val) {
        this.val = val;
    }

    TreeNode103(int val, TreeNode103 left, TreeNode103 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}