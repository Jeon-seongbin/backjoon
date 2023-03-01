package com.programmers.level2;

import java.util.Arrays;

public class Boat {
    public static void main(String[] args) {
        solution(new int[]{80}, 100);
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (left == right) {
                answer++;
                break;
            }
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                answer++;
            } else {
                answer++;
                right--;
            }
        }
        return answer;
    }
}
