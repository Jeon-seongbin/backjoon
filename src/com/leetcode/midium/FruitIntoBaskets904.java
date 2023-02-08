package com.leetcode.midium;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FruitIntoBaskets904 {
    public static void main(String[] args) {
//        int result = totalFruit1(new int[]{1, 2, 3, 2, 2});
//        System.out.println(result);
        int result1 = totalFruit(new int[]{1, 2, 3, 2, 2});
        System.out.println(result1);
    }

    public static int totalFruit1(int[] fruits) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for (int f : fruits) {
            treeMap.put(f, treeMap.getOrDefault(f, 0) + 1);
        }
        int result = treeMap.get(treeMap.lastKey());
        treeMap.remove(treeMap.lastKey());
        result += treeMap.get(treeMap.lastKey());

        return result;
    }

    public static int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> fruitCount = new HashMap<>();

        int i = 0;
        int j = 0;
        int ans = 0;

        while (i < fruits.length) {
            fruitCount.put(fruits[i], fruitCount.getOrDefault(fruits[i], 0) + 1);
            while (2 < fruitCount.size()) {
                int count = fruitCount.get(fruits[j]) - 1;
                fruitCount.put(fruits[j], count);
                if (count == 0) {
                    fruitCount.remove(fruits[j]);
                }
                j++;
            }
            ans = Math.max(ans, i - j + 1);

            i++;
        }
        return ans;
    }


}
