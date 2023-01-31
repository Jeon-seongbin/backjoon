package com.leetcode.midium;

import java.util.Arrays;

public class BestTeamWithNoConflicts1626 {
    public static void main(String[] args) {
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        Player1626[] players = new Player1626[scores.length];

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player1626(ages[i], scores[i]);
        }

        Arrays.sort(players, (player1, player2) ->
                player1.age == player2.age ? player1.score - player2.score : player1.age - player2.age
        );

        for (Player1626 p : players) {
            System.out.println("--");
            System.out.println(p.age);
            System.out.println(p.score);
            System.out.println("--");
        }

        int dp[] = new int[ages.length];

        int max = players[0].score;
        dp[0] = players[0].score;

        for (int i = 1; i < players.length; i++) {
            dp[i] = players[i].score;
            for (int j = 0; j < i; j++) {
                if (players[j].score <= players[i].score) {
                    dp[i] = Math.max(dp[i], dp[j] + players[i].score);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

class Player1626 {
    int age;
    int score;

    Player1626(int age, int score) {
        this.age = age;
        this.score = score;
    }
}
