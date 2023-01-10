package com.acmicpc.season1.company29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String userInput = br.readLine();
        long userInputLong = Long.parseLong(userInput);
        long start = 1;
        long mid = 0;
        long answer = 0;
        BigDecimal temp = new BigDecimal(userInputLong);
        long end = userInputLong;

        while (start <= end) {
            mid = start + (end - start) / 2;
            BigDecimal midmid = new BigDecimal(mid).multiply(new BigDecimal(mid));
            if (midmid.compareTo(temp) == 0) {
                answer = mid;
                break;
            }
            if (midmid.compareTo(temp) > 0) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
