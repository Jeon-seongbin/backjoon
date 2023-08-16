package com.leetcode.midium;


public class PartitionList86 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        l.val = 4;

        l.next = new ListNode();
        l.next.val = 1;


        l.next.next = new ListNode();
        l.next.next.val = 2;


        l.next.next.next = new ListNode();
        l.next.next.next.val = 3;

        partition(l, 2);
    }

    static public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();

        ListNode l = left;
        ListNode r = right;

        while (head != null) {

            if (head.val < x) {
                l.next = head;
                l = head;
            } else {
                r.next = head;
                r = head;


            }

            head = head.next;
        }

        l.next = right.next;
        r.next = null;

        return left.next;
    }

}
