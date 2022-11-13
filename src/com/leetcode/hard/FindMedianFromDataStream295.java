package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
//        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(88);
//        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(77);
//        System.out.println(medianFinder.findMedian());


    }
}

class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if (maxHeap.isEmpty() || maxHeap.peek() < num) {
            System.out.println(maxHeap.peek());
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }


    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }

        return maxHeap.peek();
    }
}
