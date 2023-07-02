package com.leetcode.midium;

import java.util.*;


public class PathWithMaximumProbability1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        double[] calculatedCosts = new double[n];

        // この問題は、一般ダイクストラとは違い、コストが一番多いことを選択する必要がありますので、0を設定する必要がある
        Arrays.fill(calculatedCosts, 0.0);

        ArrayList<ArrayList<Node1514>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // 両方面移動できるので、各ノード別に移動するコストを保存する
        for (int i = 0; i < succProb.length; i++) {
            graph.get(edges[i][0]).add(new Node1514(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Node1514(edges[i][0], succProb[i]));
        }

        PriorityQueue<Node1514> pq = new PriorityQueue<>();

        // スタートポイントコストは1で初期化
        // 掛け算を行うので
        pq.add(new Node1514(start, 1));
        calculatedCosts[start] = 1;

        while (!pq.isEmpty()) {

            Node1514 nowPoint = pq.poll();
            // 現在のノードと、コストを取得する
            int currentNode = nowPoint.node;
            double currentCost = nowPoint.cost;

            // 他の場所で計算されたコスト（costs[nodNode]）が、現在のコスト（cost）より大きい場合、処理する必要がないので、Continueする
            if (currentCost < calculatedCosts[currentNode]) {
                continue;
            }


            // グラフ内部の健在のノードから、連結されているノードを確認する
            for (Node1514 nextNode : graph.get(currentNode)) {
                int nextNodeNumber = nextNode.node;

                // 現在ノードから計算されているコストと、連結されているノードのコストを計算する（問題自体が掛け算するので、掛け算を行う）
                double nextCost = calculatedCosts[currentNode] * nextNode.cost;

                // 現在ノードの計算されているコストより、上の上で新しく計算されたコストが大きい場合、保存する
                if (calculatedCosts[nextNodeNumber] < nextCost) {
                    calculatedCosts[nextNodeNumber] = nextCost;
                    pq.add(new Node1514(nextNodeNumber, nextCost));
                }
            }
        }
        return calculatedCosts[end];
    }

    public class Node1514 implements Comparable<Node1514> {
        int node;
        double cost;

        Node1514(int node, double cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        //コストを基準で降順整列する
        public int compareTo(Node1514 o) {
            if (this.cost < o.cost) {
                return 1;
            }
            return -1;
        }
    }
}
