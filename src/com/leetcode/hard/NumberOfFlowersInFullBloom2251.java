package com.leetcode.hard;

import java.util.HashMap;
import java.util.TreeMap;

public class NumberOfFlowersInFullBloom2251 {
    public static void main(String[] args) {

        fullBloomFlowers(new int[][]{
                        {1, 10},
                        {3, 3}
                },
                new int[]{3, 3, 2});


        fullBloomFlowers2(new int[][]{
                        {1, 10},
                        {3, 3}
                },
                new int[]{3, 3, 2});

    }

    public static int[] fullBloomFlowers2(int[][] flowers, int[] people) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int[] f : flowers) {
            hashMap.put(f[0], hashMap.getOrDefault(f[0], 0) + 1);
            hashMap.put(f[1] + 1, hashMap.getOrDefault(f[1] + 1, 0) - 1);
        }

        int sum = 0;
        TreeMap<Integer, Integer> blossomed = new TreeMap<>();
        for (int time : hashMap.keySet()) {
            sum += hashMap.get(time);
            blossomed.put(time, sum);
        }

        int[] result = new int[people.length];

        for(int i = 0 ; i < people.length; i++){
            Integer time = blossomed.floorKey(people[i]);
            if(time == null){
                continue;
            }
            result[i] = blossomed.get(time);
        }

        return result;
    }

    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int[] flower : flowers) {
            hashMap.put(flower[0], hashMap.getOrDefault(flower[0], 0) + 1);
            hashMap.put(flower[1] + 1, hashMap.getOrDefault(flower[1] + 1, 0) - 1);
        }

        int sum = 0;

        HashMap<Integer, Integer> blossomed = new HashMap<>();

        for (int time : hashMap.keySet()) {
            sum += hashMap.get(time);
            blossomed.put(time, sum);
        }

        int[] result = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            Integer time = blossomed.get(people[i]);

            if (time == null) {
                continue;
            }

            result[i] = time.intValue();
        }

        return result;

    }

    public static int[] fullBloomFlowers１(int[][] flowers, int[] people) {

        int[] tempFlowers = new int[50001];


        for (int[] flower : flowers) {

            for (int i = flower[0]; i <= flower[1]; i++) {
                tempFlowers[i]++;
            }
        }

        int[] result = new int[people.length];
        int index = 0;
        for (int p : people) {
            result[index++] = tempFlowers[p];
        }

        return result;
    }


}
