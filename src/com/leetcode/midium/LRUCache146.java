package com.leetcode.midium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {

}

class LRUCache {

    static class CacheItem {
        int key;
        int value;
        CacheItem prev;
        CacheItem next;

        public CacheItem(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    CacheItem head;
    CacheItem tail;

    int capacity;

    Map<Integer, CacheItem> map;

    public LRUCache(int capacity) {
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        CacheItem cur = map.get(key);

        if (cur != head) {
            // move cur to head

            if (tail == cur) {
                // move tail to one in front
                tail = tail.prev;
            }

            if (cur.prev != null) {
                cur.prev.next = cur.next;
            }

            if (cur.next != null) {
                cur.next.prev = cur.prev;
            }

            cur.next = head;
            head.prev = cur;
            cur.prev = null;
            head = cur;
        }

        return cur.value;
    }

    public void put(int key, int value) {
        if (get(key) == -1) {
            // insert

            CacheItem cur = new CacheItem(key, value);
            if (head == null) {
                head = cur;
                tail = cur;

            } else {
                cur.next = head;
                head.prev = cur;
                head = cur;
            }
            map.put(key, cur);

            if (capacity < map.size()) {
                map.remove(tail.key);
                tail.prev.next = null;
                tail = tail.prev;
            }

            return;
        }

        // update
        map.get(key).value = value;
    }
}
