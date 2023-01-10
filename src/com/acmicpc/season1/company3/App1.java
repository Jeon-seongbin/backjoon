package com.acmicpc.season1.company3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class App1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputCount = Integer.parseInt(br.readLine());
        String template = br.readLine();
        String[] templateArray = template.split(" ");


        int torihikishoCount = Integer.parseInt(br.readLine());
        ArrayList<HashMap> valueArrayList = new ArrayList<>();

        for (int index = 0; index < torihikishoCount; index++) {
            int koukannHituyoCount = Integer.parseInt(br.readLine());

            HashMap<String, String> valueTemp = new HashMap<>();
            for (int jIndex = 0; jIndex < koukannHituyoCount; jIndex++) {
                String value = br.readLine();
                String[] valueArray = value.split(" ");
                valueTemp.put(valueArray[0], valueArray[1]);
            }
            valueArrayList.add(valueTemp);
        }


        for (int index = 0; index < torihikishoCount; index++) {

            boolean isCorrect = true;
            String result = "";
            for (int j = 0; j < templateArray.length; j++) {
                String t = templateArray[j];

                if (t.charAt(0) == '#') {
                    HashMap<String, String> valueTemp = valueArrayList.get(index);
                    if (valueTemp.containsKey(t)) {
                        result += valueTemp.get(t);
                    } else {
                        isCorrect = false;
                        break;
                    }
                } else {
                    result += t;
                }

                if (j + 1 != templateArray.length) {
                    result += " ";
                }
            }
            if(isCorrect){
                System.out.println(result);
            }else{
                System.out.println("Error: Lack of data");
            }

        }
    }
}
