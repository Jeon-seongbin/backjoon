package com.leetcode.easy;

import java.util.HashMap;

public class ReformatDate1507 {
    public static void main(String[] args) {

    }

    public String reformatDate(String date) {
        String[] dates = date.split(" ");

        HashMap<String, String> month = new HashMap<>();

        month.put("Jan", "01");
        month.put("Feb", "02");
        month.put("Mar", "03");
        month.put("Apr", "04");
        month.put("May", "05");
        month.put("Jun", "06");
        month.put("Jul", "07");
        month.put("Aug", "08");
        month.put("Sep", "09");
        month.put("Oct", "10");
        month.put("Nov", "11");
        month.put("Dec", "12");

        String day = "";
        if (dates[0].length() == 4) {
            day = dates[0].substring(0, 2);
        }
        if (dates[0].length() == 3) {
            day = dates[0].substring(0, 1);
            day = "0" + day;
        }
        return dates[2] + "-" + month.get(dates[1]) + "-" + day;
    }
}
