package com.acmicpc.company21;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main5 {

    //    public static boolean isRight = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int userInputCount = Integer.parseInt(br.readLine());
        Vertex root = null;
        int sum = 0;
        for (int i = 0; i < userInputCount; i++) {
            int input = Integer.parseInt(br.readLine());
            if (i == 0) {
                root = new Vertex(input);
//                sum = root.sum;
                continue;
            }
            insert(root, input, 0);
        }

        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(root);
        int answer = 0;
        while (!queue.isEmpty()) {
            Vertex temp = queue.poll();
            if(answer < temp.sum){
                answer = temp.sum;
            }
            if (temp.left != null ) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }

        bw.write(""+answer);
        bw.flush();
        br.close();
        bw.close();

    }

    static void insert(Vertex V, int X, int sum) {

        if (X < V.getValue()) {
            // if (x < V에 저장되어 있는 수) {


            if (V.hasVertexLeft()) {
                // if (V가 왼쪽 자식이 있으면) {

                //insert(V의 왼쪽 자식, X);
                // insert(V.left, X, V.value + sum);
                insert(V.left, X, V.value);
            } else {


                // V의 왼쪽 자식을 새로 만들고, 그 곳에 X를 저장함
                V.left = new Vertex(V, null, null, X, V.sum + X);
            }

        } else {
            if (V.hasVertexRight()) {
                // if (V가 오른쪽 자식이 있으면) {


                //insert(V의 왼쪽 자식, X);
//                insert(V.right, X, V.value + sum);
                insert(V.right, X, V.value);
            } else {
                //  V의 오른쪽 자식을 새로 만들고, 그 곳에 X를 저장함
                V.right = new Vertex(V, null, null, X, V.sum + X);
            }

        }


    }
}

class Vertex {
    int sum;
    int value;

    Vertex parents;
    Vertex left;
    Vertex right;
    boolean isVisited;

    Vertex(int sum) {
        this.left = null;
        this.right = null;
        this.parents = null;
        this.value = sum;
        this.sum = sum;
        this.isVisited = false;
    }

    Vertex(Vertex parents, int value, int sum) {
        this.left = null;
        this.right = null;
        this.value = value;
        this.parents = parents;
        this.sum = sum;
        this.isVisited = false;
    }

    Vertex(Vertex parents, Vertex left, Vertex right, int value, int sum) {
        this.parents = parents;
        this.left = left;
        this.right = right;
        this.value = value;
        this.isVisited = false;
        this.sum = sum;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }


    public boolean setIsLeftVisited() {
        return left.isVisited;
    }

    public void getIsLeftVisited(boolean isVisited) {
        this.left.isVisited = isVisited;
    }

    public boolean setIsRightVisited() {
        return right.isVisited;
    }

    public void getIsRightVisited(boolean isVisited) {
        this.right.isVisited = isVisited;
    }

    public boolean hasVertexLeft() {
        if (left == null) {
            return false;
        }
        return true;
    }

    public boolean hasVertexRight() {
        if (right == null) {
            return false;
        }
        return true;
    }

}
