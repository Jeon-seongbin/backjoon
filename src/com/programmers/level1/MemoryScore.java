package com.programmers.level1;

import java.util.HashMap;

public class MemoryScore {
    public static void main(String[] args) {

        String [][] temp = new String[][]
                {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, temp);
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            hashmap.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int temp = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (hashmap.containsKey(photo[i][j])) {
                    temp += hashmap.get(photo[i][j]);
                }
            }
            answer[i] = temp;
        }
        return answer;
    }
}
