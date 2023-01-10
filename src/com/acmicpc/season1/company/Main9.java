package com.acmicpc.season1.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner objectct
        String userInput = myObj.nextLine();  // Read user input
//        String userInput1 = myObj.nextLine();

        String[] time = userInput.split(" ");

        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
//        int second = Integer.parseInt(time[2]);
//        int  = Integer.parseInt(userInput1);

        DateFormat timeFormat = new SimpleDateFormat("HH mm ss");
        Calendar cal = Calendar.getInstance();
        cal.set(2021, 10, 16, hour, min);
        cal.add(Calendar.MINUTE, -45);

        String result = timeFormat.format(cal.getTime());

        String[] printStr = result.split(" ");

        if (printStr[0].charAt(0) == '0') {
            printStr[0] = printStr[0].substring(1);
        }

        if (printStr[1].charAt(0) == '0') {
            printStr[1] = printStr[1].substring(1);
        }

//        if (printStr[2].charAt(0) == '0') {
//            printStr[2] = printStr[2].substring(1);
//        }
        System.out.println(printStr[0] + " " + printStr[1]);
    }
}
