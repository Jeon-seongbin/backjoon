package com.company;

import java.io.*;

public class Main13 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());  // Read user input
        int y = Integer.parseInt(br.readLine());  // Read user input

        if (0 < x) {
            if (0 < y) {
                System.out.println(1);
            } else {

                System.out.println(4);
            }
        } else {
            if (0 < y) {

            System.out.println(2);
            } else {

                System.out.println(3);
            }
        }
    }
}
