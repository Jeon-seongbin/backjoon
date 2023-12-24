package com.leetcode.easy;

public class MaximumScoreAfterSplittingAString1422 {
    public static void main(String[] args) {

    }

    public static int maxScore(String s) {

        int answer = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int cnt = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') {
                    cnt++;
                }
            }


            for (int j = i + 1; j <= s.length(); j++) {
                if (s.charAt(j) == '1') {
                    cnt++;
                }
            }

            answer = Math.max(cnt, answer);

        }
        return answer;
    }
}
