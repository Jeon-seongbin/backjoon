package com.programmers.level2;

public class Hotel {
    public static void main(String[] args) {

    }
cce
    public static int CLEAN_TIME = 10;
    public static int HOUR = 60;
    public static int maxTime = 1_450;


    public static int solution(String[][] book_time) {
        int[] timeTable = new int[maxTime];
        for (int i = 0; i < book_time.length; i++) {
            timeTable[calTime(book_time[i][0])] += 1;
            timeTable[calTime(book_time[i][1]) + CLEAN_TIME] -= 1;
        }
        int answer = 0;
        for (int i = 1; i < maxTime; i++) {
            timeTable[i] += timeTable[i - 1];
            answer = Math.max(timeTable[i], answer);
        }
        return answer;

    }

    public static int calTime(String time) {
        String[] temp = time.split(":");

        String hour = temp[0];
        String min = temp[1];

        return Integer.parseInt(hour) * HOUR + Integer.parseInt(min);
    }
}
