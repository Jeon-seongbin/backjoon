package com.company6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws Exception {
        Main m = new Main();
        String[] a = {"add 5 3", "add 1 2", "get 5", "evict", "get 1", "remove 5", "exit"};
        int[] result = m.solution(a);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static HashMap<Integer, Integer> map = new HashMap<>();
    private static HashMap<Integer, Integer> keyCount = new HashMap<>();

    public int[] solution(String[] A) {
        // write your code in Java SE 8


        ArrayList<Integer> resultPut = new ArrayList<>();
        int count = 0;
        for (String userInput : A) {
            String[] userInputs = userInput.split(" ");
            int key = 0;
            int value = 0;
            if (2 <= userInputs.length) {
                key = Integer.parseInt(userInputs[1]);
            }
            if (3 <= userInputs.length) {
                value = Integer.parseInt(userInputs[2]);
            }
            if ("add".equals(userInputs[0])) {


                // 현재것 0 설정
                keyCount.put(key, 0);

                //다른것들 키 + 1
                for (Map.Entry<Integer, Integer> entry : keyCount.entrySet()) {
                    int mapKey = entry.getKey();
                    int mapValue = entry.getValue();

                    if (mapKey != key) {
                        mapValue++;
                        keyCount.put(mapKey, mapValue);
                    }
                }

                add(key, value);


            } else if ("get".equals(userInputs[0])) {


                //처음것 키  0
                keyCount.put(key, 0);

                //다른것들  키 + 1
                for (Map.Entry<Integer, Integer> entry : keyCount.entrySet()) {
                    int mapKey = entry.getKey();
                    int mapValue = entry.getValue();

                    if (mapKey != key) {
                        mapValue++;
                        keyCount.put(mapKey, mapValue);
                    }
                }


                resultPut.add(get(key));
            } else if ("remove".equals(userInputs[0])) {
                resultPut.add(remove(key));
            } else if ("evict".equals(userInputs[0])) {
                evict();
            }

        }

        int[] result = new int[resultPut.size()];
        for (int i = 0; i < resultPut.size(); i++) {
            result[i] = resultPut.get(i);
        }
        return result;

    }

    public static void add(int key, int value) {
        map.put(key, value);

    }

    public static int get(int key) {
        int value = -1;
        try {
            value = map.get(key);

        } catch (Exception e) {
            return value;
        }

        return value;
    }

    public static int remove(int key) {
        int value = -1;
        try {

            value = map.remove(key);


        } catch (Exception e) {
            return value;
        }
        return value;
    }

    public static void evict() {
        int maxCount = 0;
        int targetKey = 0;

        //가장 높은 카운트를 가지는 키를 제거
        for (Map.Entry<Integer, Integer> entry : keyCount.entrySet()) {
            int mapKey = entry.getKey();
            int mapValue = entry.getValue();

            if (maxCount < mapValue) {
                maxCount = mapValue;
                targetKey = mapKey;
            }
        }
        remove(targetKey);
    }
}
