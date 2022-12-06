package com.leetcode.easy;

public class OddEvenLinkedList328 {
    public static void main(String[] args) {

    }

    public ListNode328 oddEvenList(ListNode328 head) {
        if (head == null) {
            return head;
        }
        ListNode328 odd = head;
        ListNode328 even = head.next;
        ListNode328 evenHead = even;

        while (even != null && odd != null) {
            even.next = even.next.next;
            odd.next = odd.next.next;
            even = even.next;
            odd = odd.next;
        }
        odd.next = evenHead;
        return head;
    }
}

class ListNode328 {
    int val;
    ListNode328 next;

    ListNode328() {
    }

    ListNode328(int val) {
        this.val = val;
    }

    ListNode328(int val, ListNode328 next) {
        this.val = val;
        this.next = next;
    }
}