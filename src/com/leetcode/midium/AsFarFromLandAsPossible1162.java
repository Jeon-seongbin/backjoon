package com.leetcode.midium;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Queue;

public class AsFarFromLandAsPossible1162 {
    public static void main(String[] args) {
        int [][]testData = new int[][]{
                {1,0,1},{0,0,0},{1,0,1}

        };
        maxDistance(testData);
    }

    public static int[] dx;
    public static int[] dy;
    public static boolean[][] isVisited;
    public static ArrayList<SavedPoint1162> savedPoints;
    public static Queue<Point1162> queue;
    public static int result = -1;

    public static int maxDistance(int[][] grid) {
        isVisited = new boolean[grid.length][grid[0].length];

        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        queue = new LinkedList<>();
        savedPoints = new ArrayList<>();


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    result = 0;
                    savedPoints.add(new SavedPoint1162(i,j));

//                    queue.add(new Point1162(i, j, 0));
//                    bfs(grid, i , j);

                    result = -3;
                } else if (grid[i][j] == 0) {
                    if (result == 0) {
                        result = 0;
                    }
                }

            }
        }


        for(SavedPoint1162 saved : savedPoints){
            queue.add(new Point1162(saved.x, saved.y, 0));
            isVisited = new boolean[grid.length][grid.length];

            isVisited[saved.x][saved.y] = true;
            bfs(grid);
        }



        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                System.out.print(grid[i][j]);
                result = Math.max (grid[i][j], result);
            }
            System.out.println();
        }




        return result;


    }

    public  static void bfs(int[][] grid){

        while(!queue.isEmpty()){
            Point1162 p =  queue.poll();


            for(int i = 0; i < 4 ; i++){
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if( nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length ){
                    continue;
                }
                if(isVisited[nextX][nextY]){
                    continue;
                }

                boolean isSaved = false;
                for(SavedPoint1162 saved : savedPoints){
                    if(nextX == saved.x &&nextY == saved.y ){
                        isSaved = true;
                        break;
                    }

                }
                if(isSaved){
                    continue;
                }

                if(grid[nextX][nextY] == 0){
                    grid[nextX][nextY] =Math.max( p.count + 1 ,grid[nextX][nextY] + 1);
                }else{
                    grid[nextX][nextY] =Math.min( p.count + 1 ,grid[nextX][nextY] + 1);
                }

                isVisited[nextX][nextY] = true;
                queue.add( new Point1162(nextX, nextY , p.count + 1) );

            }

        }



    }


}

class SavedPoint1162{
    int x;
    int y;
    SavedPoint1162(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Point1162 {
    int x;
    int y;

    int count;

    Point1162(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
