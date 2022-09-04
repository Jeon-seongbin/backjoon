package com.leetcode.easy;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleNumber136 {
    public static void main(String[] args) {
        int []nums = new int[]{2,2,1};
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, false);
            } else {
                map.put(n, true);
            }
        }
        AtomicInteger result = new AtomicInteger();
        map.forEach((key, value) -> {
            if(value){
                result.set(key);
            }
        });

        System.out.println(result.get());
    }

}
