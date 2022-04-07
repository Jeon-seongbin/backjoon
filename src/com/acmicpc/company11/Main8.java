package com.acmicpc.company11;

import java.io.*;
// https://www.hackerrank.com/challenges/one-month-preparation-kit-time-conversion/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one
public class Main8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String userInput = br.readLine();
        userInput = timeConversion(userInput);
        bw.write(userInput);
        bw.flush();

        bw.close();
        br.close();
    }

    public static String timeConversion(String s) {
        // Write your code here

        String amPm = s.substring(s.length() - 2, s.length());
        String hh = s.substring(0, 2);
        String originTime = s.substring(0, s.length() - 2);
        if (amPm.equals("PM")) {
            originTime = originTime.substring(2, originTime.length());
            int hhTime = Integer.parseInt(hh) + 12;
            originTime = hhTime + originTime;

            // 12PM  넘어줄 경우 그냥 12시로 표시
            if(12 <= Integer.parseInt(hh)) {
                originTime = originTime.substring(2, originTime.length());
                originTime = "12" +  originTime;
            }

        }else if(hh.equals("12")){
            originTime = originTime.substring(2, originTime.length());
            originTime = "00" +  originTime;
        }
        return originTime;
    }
}
