package com.leetcode.easy;

public class MiddleOfTheLinkedList876 {
    public static void main(String[] args) {

    }

    public ListNode876 middleNode(ListNode876 head) {
        ListNode876 temp = head;

        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        length /= 2;
        temp = head;

        while (0 < length) {
            temp = temp.next;
            length--;
        }
        return temp;
    }
}

class ListNode876 {
    int val;
    ListNode876 next;

    ListNode876() {
    }

    ListNode876(int val) {
        this.val = val;
    }

    ListNode876(int val, ListNode876 next) {
        this.val = val;
        this.next = next;
    }
}