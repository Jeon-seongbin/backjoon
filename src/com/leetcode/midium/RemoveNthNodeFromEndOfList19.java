package com.leetcode.midium;

public class RemoveNthNodeFromEndOfList19 {
    public static void main(String[] args) {
        ListNode input = new ListNode();
        input.val = 1;

        input.next = new ListNode();
        input.next.val = 2;

        input.next.next = new ListNode();
        input.next.next.val = 3;

        input.next.next.next = new ListNode();
        input.next.next.next.val = 4;

        input.next.next.next.next = new ListNode();
        input.next.next.next.next.val = 5;
        removeNthFromEnd(input, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head;
        int size = 0;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        temp = head;
        size -= n;

        if (size == 0) {
            return head.next;
        }
        int i = 0;
        for( ; i < size - 1;  i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}


class ListNode {
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