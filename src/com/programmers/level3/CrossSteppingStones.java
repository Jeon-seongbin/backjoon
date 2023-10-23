package com.programmers.level3;

import java.util.Arrays;

public class CrossSteppingStones {
    public static void main(String[] args) {
        solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
    }

    public static int solution(int[] stones, int k) {
        int answer = 0;

        int left = 1;
        int right = Arrays.stream(stones).max().getAsInt();
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (!isPossible(stones, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }

    public static boolean isPossible(int[] stones, int k, int mid) {

        int cnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - mid < 0) {
                cnt++;
                if (k <= cnt) {
                    return false;
                }
            } else {
                cnt = 0;
            }
        }
        return true;
    }
}
