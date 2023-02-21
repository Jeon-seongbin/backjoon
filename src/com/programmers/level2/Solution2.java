package com.programmers.level2;

import java.util.HashMap;

public class Solution2 {
    public static void main(String[] args) {
        solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int i = 0; i < discount.length  - 9; i++) {
            HashMap<String, Integer> hashmapTemp = new HashMap<>();

            for (int z = 0; z < want.length; z++) {
                hashmapTemp.put(want[z], number[z]);
            }

            for (int j = 0; j < 10; j++) {
                if (hashmapTemp.containsKey(discount[i + j])) {
                    hashmapTemp.put(discount[i + j], hashmapTemp.get(discount[i + j]) - 1);
                    if (hashmapTemp.get(discount[i + j]) == 0) {
                        hashmapTemp.remove(discount[i + j]);
                    }
                }
            }

            if (hashmapTemp.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
