package com.programmers.level2;

import java.util.ArrayList;

public class PlayAlone {
    public static void main(String[] args) {
        solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4});
    }

    public static int solution(int[] cards) {

        ArrayList<ArrayList<Integer>> cardBox = new ArrayList<>();

        boolean[] isVisited = new boolean[cards.length];
        int newIndex = 0;
        for (int i = 0; i < cards.length; i++) {
            if (isVisited[i]) {
                continue;
            }

            cardBox.add(new ArrayList<>());
            newIndex = i;
            while (true) {
                int newIndexfromCards = cards[newIndex];
                newIndexfromCards--;

                if (isVisited[newIndexfromCards]) {
                    break;
                }

                cardBox.get(cardBox.size() - 1).add(newIndexfromCards);
                isVisited[newIndexfromCards] = true;
                newIndex = newIndexfromCards;
            }
        }

        if (cardBox.size() == 1) {
            return 0;
        }

        cardBox.sort((o1, o2) -> {
            return o2.size() - o1.size();
        });

        int answer = cardBox.get(0).size() * cardBox.get(1).size();
        return answer;
    }
}
