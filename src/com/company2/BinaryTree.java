package com.company2;

public class BinaryTree {
    public static void main(String[] args) {
        // 정점의 개수
        int count = 7;

        //바이너리 트리 크기 8
        // 1부터 사용하기 위해 크기를 + 1 함
        Node[] nodeList = new Node[count + 1];

        // 정점 7 개 생성
        for (int i = 1; i <= count; i++) {
            Node node = new Node(i);
            nodeList[i] = node;
        }

        //값 넣어주기
        for (int i = 1; i <= count; i++) {
            if (i * 2 <= count) {
                nodeList[i].leftNode = nodeList[i * 2];
                nodeList[i].rightNode = nodeList[(i * 2) + 1];
            }
        }

        preOrder(nodeList[1]);
        System.out.println();
        inOrder(nodeList[1]);
        System.out.println();
        postOrder(nodeList[1]);
    }

    static void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }


    static void inOrder(Node node) {
        if (node != null) {

            inOrder(node.leftNode);
            System.out.println(node.data);
            inOrder(node.rightNode);
        }
    }

    static void postOrder(Node node) {
        if (node != null) {

            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.println(node.data);
        }
    }
}
