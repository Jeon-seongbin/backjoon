package com.leetcode.midium;

import java.util.*;


public class ValidateBinaryTreeNodes1361 {
    public static void main(String[] args) {
        boolean result = validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1});
        System.out.println(result);
    }

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                indegree[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                indegree[rightChild[i]]++;
            }
        }

        int root = -1;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0 && root == -1) {
                root = i;
            }
        }

        if (root == -1) {
            return false;
        }


        boolean[] isVisited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int nowPoint = q.poll();

            if (isVisited[nowPoint]) {
                return false;
            }
            isVisited[nowPoint] = true;


            if (leftChild[nowPoint] != -1) {
                q.add(leftChild[nowPoint]);
            }

            if (rightChild[nowPoint] != -1) {
                q.add(rightChild[nowPoint]);
            }
        }

        int count = 0;
        for (boolean v : isVisited) {
            if (v) {
                count++;
            }
        }

        return count == n;
    }

    public static boolean validateBinaryTreeNodes1(int n, int[] leftChild, int[] rightChild) {
        boolean[] isVisited = new boolean[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                graph.get(i).add(leftChild[i]);
            }
            if (rightChild[i] != -1) {
                graph.get(i).add(rightChild[i]);
            }
        }

        Queue<Integer> q = new LinkedList<>();


        q.add(0);
        isVisited[0] = true;

        while (!q.isEmpty()) {
            int nowPoint = q.poll();

            int nextPointLeft = leftChild[nowPoint];
            int nextPointRight = rightChild[nowPoint];

            if (nextPointLeft != -1) {
                if (isVisited[nextPointLeft]) {
                    return false;
                }

                q.add(nextPointLeft);
                isVisited[nextPointLeft] = true;
            }

            if (nextPointRight != -1) {
                if (isVisited[nextPointRight]) {
                    return false;
                }

                q.add(nextPointRight);
                isVisited[nextPointRight] = true;
            }

        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                if (leftChild[i] == -1 && rightChild[i] == -1) {

                    return false;
                }
            }
        }

        return true;

    }
}
