package com.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SocialDistance {
    public static void main(String[] args) {

        solution(new String[][]
                {
                        {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
                }
        );
    }

    static class Spot {
        int x;
        int y;
        int distance;

        Spot(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        Arrays.fill(answer, -1);
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int placeCase = 0; placeCase < places.length; placeCase++) {

            String[] pCase = places[placeCase];


            for (int i = 0; i < pCase.length; i++) {

                Queue<Spot> q = new LinkedList<>();
                boolean[][] isVisited = new boolean[5][5];

                for (int j = 0; j < pCase[i].length(); j++) {

                    char check = pCase[i].charAt(j);

                    if (check == 'X') {
                        continue;
                    }
                    if (check == 'P') {
                        q.add(new Spot(i, j, 0));
                        isVisited[i][j] = true;
                    }


                    while (!q.isEmpty()) {

                        Spot now = q.poll();

                        for (int checkFourSide = 0; checkFourSide < 4; checkFourSide++) {
                            int newX = now.x + dx[checkFourSide];
                            int newY = now.y + dy[checkFourSide];

                            if (newX < 0 || 5 <= newX || newY < 0 || 5 <= newY) {
                                continue;
                            }


                            if (pCase[newX].charAt(newY) == 'X') {
                                continue;
                            }

                            if (2 <= now.distance) {
                                continue;
                            }


                            if (isVisited[newX][newY]) {
                                continue;
                            }

                            char temp = pCase[newX].charAt(newY);
                            if (temp == 'P') {
                                answer[placeCase] = 0;
                                break;
                            }

                            isVisited[newX][newY] = true;
                            q.add(new Spot(newX, newY, now.distance + 1));

                        }
                    }

                }


            }
            if (answer[placeCase] != 0) {
                answer[placeCase] = 1;
            }

        }

        return answer;
    }
}
