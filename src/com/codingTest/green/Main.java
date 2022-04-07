package com.rine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
문제 1
다음과같은 조작을 행하는것이 가능한 데이터 구성을 코딩하세요
———————————————
Void add(k key, v value); //데이터 구성에 key value가 되는 요소를 추가한다
Key에 대응하는 값이 이미 있을 경우 새로운 값으로 덮어쓴다
V get (k key) //key 에 해당하는 요소를 찾아 그 요소(키)의 value를 반환한다
요소가 없을시 예외 발생한다
 V remove(K key) // key에 해당하는 요소를 찾아 그 value를 반환하고 요소(키)를 삭제한다
요소가 없을시 예외 발생한다
Void evict() // 전 요소에서 add나 get이 되어진 것 에서 경과시간이 가장 긴 요소를 삭제한다
(추가설명 :가장 사용 안된 요소 지우란뜻)
———————————————
이 문제에서는 KV를 2^20이하의 자연수를 가정해도 상관없습니다(범위 이야기인듯)
입력
입력 각행은 데이터를 조작하는 메소드 를 가리킵니다
각메소드에 파라메터가 있는 경우 뒤에 공백문자가 1개씩구분된 파라메터가 주어집니다
(정의되어지지 않은 메소드가 입력되었을경우 무시하고 다음 행을 처리합니다)
Evict evic메소드를 실행합니다
Add add 메소드를 실행합니다. 파라메터의 첫번째는 key ２번째는 value입니다
Get get 조작을 실행합니다. 파라메터의 첫번째는 key입니다 이 실행의 갑(value)를 출력합니다. 결과가 없고 예외가 발생한 경우 -1을 출력합니다
Remove remove 조작을 실행합니다. 파라메터의 첫번째는 key입니다 이 실행의 갑(value)를 출력합니다. 결과가 없고 예외가 발생한 경우 -1을 출력합니다
exit 입력처리를 종료합니다
입력예는 밑에 처럼 됩니다
[“add 5 3”, “add 1 2",“evict”, “get 1", “remove 1”, “exit”]
출력
메소드의 처리결과를 출력합니다 결과가 있ㅅ는 메소드는 1행에 그 결과를 표시합니다
상기 입력예의 결과는 아래와 같이 됩니다
[3, -1, 3]
 */
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
