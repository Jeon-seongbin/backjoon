package com.programmers.level1;

public class SkillCheck2 {
    public static void main(String[] args) {
        solution("banana");
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int minLength = Integer.MAX_VALUE;
            char temp = s.charAt(i);

            for (int j = 0; j < i; j++) {
               if( temp == s.charAt(j)) {
                   minLength = Math.min(minLength, i - j);
               }
            }
            if(minLength == Integer.MAX_VALUE){
                minLength = -1;
            }
            answer[i] = minLength;
        }
        return answer;
    }
}
