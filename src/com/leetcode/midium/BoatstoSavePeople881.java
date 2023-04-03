package com.leetcode.midium;

import java.util.Arrays;

public class BoatstoSavePeople881 {
    public static void main(String[] args) {
        numRescueBoats(new int[]{3, 5, 3, 4}, 5);
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int start = 0;
        int end = people.length - 1;
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
                end--;
            } else {
                end--;
            }
            answer++;
        }
        return answer;
    }
}
