package com.acmicpc.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main19 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        int userInput = s.nextInt();
        ArrayList<String> checkStr = new ArrayList<>();

        while (true) {
            String temp =  s.nextLine();
            if(temp.equals("EOI")){
                break;
            }
            checkStr.add(temp);
        }

        int size =checkStr.size();
        for (int i = 0; i < size; i++) {
//            System.out.println(checkStr.get(i).matches("(?i)nemo"));    // true
            Pattern patrn = Pattern.compile("(?i)nemo");

            // All metched patrn from str case
            // insensitive or case sensitive
            Matcher match = patrn.matcher(checkStr.get(i));
            if(match.find()){
                System.out.println("Found");
            }else{
                System.out.println("Missing");

            }
//            while (match.find()) {
//                // Print matched Patterns
////                System.out.println(match.group());
//
//            }

        }
    }
}
