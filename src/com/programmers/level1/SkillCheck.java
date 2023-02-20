package com.programmers.level1;

public class SkillCheck {
    public static void main(String[] args) {
        solution("aBz", 4);
    }

    public static String solution(String s, int n) {

        char[] tempChar = new char[s.length()];

        int count = 0;
        for (char ss : s.toCharArray()) {

            if ('a' <= ss && ss <= 'z') {
                for (int i = 0; i < n; i++) {
                    ss++;
                    if ('z' < ss) {
                        ss = 'a';

                    }

                }
            }
            if ('A' <= ss && ss <= 'Z') {
                for (int i = 0; i < n; i++) {
                    ss++;
                    if ('Z' < ss) {
                        ss = 'A';

                    }

                }
            }

            tempChar[count] = ss;
            count++;


        }
        String answer = "";

        for (char t : tempChar) {
            answer += t;
        }
        return answer;
    }
}
