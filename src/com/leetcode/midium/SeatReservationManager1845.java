package com.leetcode.midium;

import java.util.PriorityQueue;

class SeatManager {
    PriorityQueue<Integer> pq;

    public SeatManager(int n) {
        this.pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            this.pq.add(i);
        }
    }

    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}
public class SeatReservationManager1845 {
    public static void main(String[] args) {
        SeatManager s = new SeatManager(5);
        int a = 0;
        a = s.reserve();
        System.out.println(a);

        a = s.reserve();
        System.out.println(a);

        s.unreserve(2);

        a = s.reserve();
        System.out.println(a);


        a = s.reserve();
        System.out.println(a);

        a = s.reserve();
        System.out.println(a);

        a = s.reserve();
        System.out.println(a);


        s.unreserve(5);


    }



/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
}
