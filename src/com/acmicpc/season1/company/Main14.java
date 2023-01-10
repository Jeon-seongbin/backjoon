package com.acmicpc.season1.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main14 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner objectct
        String userInput = myObj.nextLine();  // Read user input

        ArrayList<String> tempArray = new ArrayList<>();
        String tempAllString = "";
        String tempWord = "";
        int oneCount = 0;
        boolean kakoflag = false;
        int length = userInput.length();
        for (int i = 0; i < length; i++) {
            char temp = userInput.charAt(i);
            if (temp == '<') {
                kakoflag = true;
                if (!tempWord.equals("")) {
                    tempArray.add(tempWord);
                    tempWord = "";
                    oneCount = 0;
                }

            } else if (temp == '>') {
                kakoflag = false;
            }

            if (kakoflag) {
                tempAllString += temp;
            } else {
                if (temp == ' ') {
                    if (!tempWord.equals("")) {
                        tempArray.add(tempWord);
                        tempWord = "";
                        oneCount = 0;
                    }

                    tempAllString += temp;

                } else {
                    if (temp == '>') {
                        temp = '>';
                    } else {
                        if (temp != ' ') {
                            tempWord += temp;
                        } else {
                            tempArray.add(tempWord);
                            tempWord = "";
                            oneCount = 0;
                        }
                        if (oneCount == 0) {
                            temp = '1';
                            oneCount++;
                        } else {
                            continue;
                        }
                    }
                    tempAllString += temp;
                }
            }
        }

        tempArray.add(tempWord);
        int wordCount = 0;

        for (int i = 0; i < tempAllString.length(); i++) {
            String tempchar = "" + tempAllString.charAt(i);

            if (tempchar.equals("1")) {
                tempchar = "";

                String a = tempArray.get(wordCount);

                for (int j = a.length() - 1; j >= 0; j--) {
                    tempchar += a.charAt(j);
                }
                wordCount++;

            }
            System.out.print(tempchar);
        }
    }
}
