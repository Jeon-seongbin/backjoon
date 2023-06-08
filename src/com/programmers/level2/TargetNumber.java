package com.programmers.level2;


public class TargetNumber {
    public static void main(String[] args) {

    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    public static int answer = 0;

    public static void dfs(int[] numbers, int depth, int sum, int target) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
        } else {
            dfs(numbers, depth + 1, sum + numbers[depth], target);
            dfs(numbers, depth + 1, sum + (numbers[depth] * -1), target);
        }
    }
}
