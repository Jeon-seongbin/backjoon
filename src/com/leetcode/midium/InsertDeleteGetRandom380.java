package com.leetcode.midium;

import java.util.*;

public class InsertDeleteGetRandom380 {

    class RandomizedSet {
        HashMap<Integer, Integer> a;
        ArrayList<Integer> b;

        Random rm;

        public RandomizedSet() {
            a = new HashMap<>();
            b = new ArrayList<>();
            rm = new Random();
        }

        public boolean insert(int val) {
            if (b.contains(val)) {
                return false;
            }
            a.put(val, b.size());
            b.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!b.contains(val)) {
                return false;
            }

            int index = a.get(val);

            int lastValue = b.get(b.size() -1);

            b.set(index,lastValue);
            a.put(lastValue, index);

            b.remove(b.size() - 1);
            a.remove(val);
            return true;


        }

        public int getRandom() {

            int index = rm.nextInt(b.size());
            return b.get(index);
        }
    }

    public static void main(String[] args) {

    }
}
