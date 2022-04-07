package com.acmicpc.company3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App3 {
    public static void main(String[] args) {
        try {
            File file = new File("./00_sample_.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = "";
            while((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
