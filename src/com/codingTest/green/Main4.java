package com.codingTest.green;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        String[] lines = getStdin();
        boolean isSqare = false;
        for (int i = 0, l = lines.length; i < l; i++) {
            String output = String.format("line[%s]: %s", i, lines[i]);

            if (i == 1) {
                String[] outputs = output.split(" ");

                for (int j = 0; j < outputs.length; j++) {
                    hashMap.put(outputs[j], hashMap.getOrDefault(outputs[j], 0) + 1);
                    if (hashMap.get(outputs[j]) == 4) {
                        isSqare = true;
                    }
                }

                if (isSqare) {
                    break;
                }
            }
        }

        String result = "NO";
        if (isSqare) {
            result = "YES";
        }
        System.out.println(result);
    }

    private static String[] getStdin() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines.toArray(new String[lines.size()]);
    }


}
