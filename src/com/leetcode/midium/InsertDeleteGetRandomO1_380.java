package com.leetcode.midium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomO1_380 {
    public static void main(String[] args) {
    }
}

class RandomizedSet {
    public ArrayList<Integer> arrayList;
    public Set<Integer> set;
    public Random rm;

    public RandomizedSet() {
        arrayList = new ArrayList<>();
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        arrayList.add(val);
        set.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!set.contains(val)) {
            return false;
        }

        set.remove(val);
        arrayList.remove(new Integer(val));

        return true;
    }

    public int getRandom() {
        int idx = rm.nextInt(set.size());
        ;
        return arrayList.get(idx);
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 * <p>
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [           [],        [1],    [2],      [2],       [],        [1],       [2],          []]
 * Output
 * [         null,      true,     false,    true,      2,         true,       false,     2]
 */
