package com.leetcode.midium;

public class KnightDialer935 {
    public static void main(String[] args) {

    }

    int n;
    int[][] memo;

    int squre = 10;
    int mod = (int) 1e9 + 7;

    int[][] jump = {
            {4, 6},
            {6, 8},
            {7, 9},
            {4, 8},
            {3, 9, 0},
            {},
            {1, 7, 0},
            {2, 6},
            {1, 3},
            {2, 4},
    };

    public int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }

        this.n = n;


        memo = new int[n + 1][squre];
        int ans = 0;

        for (int s = 0; s < squre; s++) {
            ans = (ans + dp(n - 1, s)) % mod;
        }

        return ans;
    }

    public int dp(int nowRemain ,int nowSqure){
        if (nowRemain== 0){
            return 1;
        }


        if(memo[nowRemain][nowSqure] != 0){
            return memo[nowRemain][nowSqure];
        }

        int answer = 0;

        for(int nextSqure: jump[nowSqure]){
            answer= (answer+ dp(nowRemain - 1, nextSqure)) % mod;
        }

        memo[nowRemain][nowSqure] = answer;

        return answer;

    }

}
