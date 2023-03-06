package com.codingTest.cocone;


import java.util.*;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {


//        System.out.println(gIndex);  // 출력 결과: 5
//        solution(new int[]{3, 0, 0, 1, 1});
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
