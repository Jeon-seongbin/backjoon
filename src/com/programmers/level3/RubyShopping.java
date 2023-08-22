package com.programmers.level3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class RubyShopping {
    public static void main(String[] args) {
        solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];

        int gemsKind = new HashSet<>(Arrays.asList(gems)).size();
        int legnth = Integer.MAX_VALUE;
        HashMap<String, Integer> hashMap = new HashMap<>();


        int left = 0;
        for (int right = 0; right < gems.length; right++) {
            hashMap.put(gems[right], hashMap.getOrDefault(gems[right], 0) + 1);

            while (hashMap.get(gems[left]) > 1) {
                hashMap.put(gems[left], hashMap.get(gems[left]) - 1);
                left++;
            }
            if (hashMap.size() == gemsKind && legnth > (right - left)) {
                legnth = right - left;
                answer[0] = left + 1;
                answer[1] = right + 1;
            }
        }

        return answer;
    }
}
