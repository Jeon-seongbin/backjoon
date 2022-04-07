package com.acmicpc.company4;

import java.io.*;

public class Main {
    //    static Node[] nodeList = new Node[27];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node {
        private char data;
        Node left, right;

        Node(char data) {
            this.data = data;
        }

        public char getData() {
            return this.data;
        }
    }

    static class Tree {
        Node root;

        public void addNode(char data, char leftData, char rightData) {
            // 1번째 노드
            if (root == null) {
                root = new Node(data);
                if (leftData != '.') {
                    root.left = new Node(leftData);
                }
                if (rightData != '.') {
                    root.right = new Node(rightData);
                }
            } else {
                search(root, data, leftData, rightData);
            }
        }

        public void search(Node root, char data, char leftData, char rightData) {
            // 없을 경우에 나감
            if (root == null) {
                return;

                // 해당 데이터 일 경우
            } else if (root.data == data) {
                if (leftData != '.') {
                    root.left = new Node(leftData);
                }
                if (rightData != '.') {
                    root.right = new Node(rightData);
                }


                // 탐색할 노드가 남아 있을 경우(대상 데이터가 아닐 경우ㅜ)
            } else {
                search(root.left, data, leftData, rightData);
                search(root.right, data, leftData, rightData);
            }
        }

        // 전위순회 : 루트 -> 좌 -> 우
        public void PreOrder(Node root) throws IOException {
            bw.write(root.data); // 중
            if (root.left != null)
                PreOrder(root.left); // 왼쪽
            if (root.right != null)
                PreOrder(root.right); // 오른쪽
        }

        // 중위순회 : 좌 -> 루트 -> 우
        public void InOrder(Node root) throws IOException {
            if (root.left != null)
                InOrder(root.left); // 왼쪽
            bw.write(root.data); // 중앙
            if (root.right != null)
                InOrder(root.right); // 오른쪽
        }

        // 후위순회 : 좌 -> 우 -> 루트
        public void PostOrder(Node root) throws IOException {
            if (root.left != null)
                PostOrder(root.left); // 왼쪽
            if (root.right != null)
                PostOrder(root.right); // 오른쪽
            bw.write(root.data); // 증
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            char[] data;
            data = br.readLine().replaceAll(" ", "").toCharArray();
            tree.addNode(data[0], data[1], data[2]);
        }

        // 전위 순회
        tree.PreOrder(tree.root);
        bw.write("\n");

        // 중위 순회
        tree.InOrder(tree.root);
        bw.write("\n");

        // 후위 순회
        tree.PostOrder(tree.root);

        bw.flush();
        br.close();
        bw.close();
    }

}

