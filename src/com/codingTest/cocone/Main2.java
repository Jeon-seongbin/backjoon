package com.codingTest.cocone;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
    }

    public static int solution(int[] paper) {
        Arrays.sort(paper);

        int paperLength = paper.length;
        int answer = 0;
        for (int i = paperLength - 1; i >= 0; i--) {
            if (paper[i] >= paperLength - i) {
                answer = paperLength - i;
            } else {
                break;
            }
        }
        return answer;
    }
}
