package com.acmicpc.season1.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main21 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayListTemp = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();

//        Scanner s = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
//        String s = bf.readLine(); //String


        arrayList.add(bf.readLine());
        arrayList.add(bf.readLine());
        arrayList.add(bf.readLine());
        arrayList.add(bf.readLine());
        arrayList.add(bf.readLine());

        arrayList.forEach(obj -> {
            obj = obj.replace("FBI", ")");
            arrayListTemp.add(obj);

        });

        for (int i = 0; i < 5; i++) {
            String a = arrayListTemp.get(i);
            for (int j = 0; j < a.length(); j++) {
                if (')' == a.charAt(j)) {
                    arrayList1.add(i + 1);
                    break;
                }
            }
        }
        String result = "";
        for (int i = 0; i < arrayList1.size(); i++) {
            int aa = arrayList1.get(i);
            result = result + aa + " ";
        }
        if (result.equals("")) {
            System.out.println("HE GOT AWAY!");
        } else {
            result = result.substring(0, result.length() - 1);
            System.out.println(result);
        }


    }
}