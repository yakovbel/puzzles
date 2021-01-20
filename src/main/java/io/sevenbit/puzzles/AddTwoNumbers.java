package io.sevenbit.puzzles;

import java.util.Objects;

/**
 * Leetcode #1
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode r = new ListNode();
        ListNode head = r;
        ListNode prev = null;
        int overflow = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + overflow;
            overflow = sum >= 10 ? 1 : 0;
            if (overflow == 1) {
                r.val = sum - 10;
            } else {
                r.val = sum;
            }
            r.next = new ListNode();
            prev = r;
            r = r.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode l = l1 == null ? l2 : l1;
        while (l != null) {
            int sum = l.val + overflow;
            overflow = sum >= 10 ? 1 : 0;
            if (overflow == 1) {
                r.val = sum - 10;
            } else {
                r.val = sum;
            }
            prev = r;
            r.next = new ListNode();
            r = r.next;
            l = l.next;
        }
        if (overflow == 1) {
            r.val = 1;
            prev = r;
        }
        if (prev != null) {
            prev.next = null;
        }
        return head;
    }

    public static class ListNode {
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

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }


    public static boolean equals(ListNode l1, ListNode l2) {
        while (l1.next != null) {
            if (l2 == null) {
                return false;
            }
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2.next != null) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        ListNode l1 = create(9,9,9,9,9,9,9);
        ListNode l2 = create(9,9,9,9);
        ListNode exepcted = create(8,9,9,9,0,0,0,1);
        ListNode actual = addTwoNumbers(l1, l2);
        if (!equals(exepcted, actual)) {
            System.out.println("expected != actual");
        }
    }

    static ListNode create(int... numbers) {
        ListNode r = new ListNode();
        ListNode head = r;
        for (int i = 0; i < numbers.length; i++) {
            r.val = numbers[i];
            if (i != numbers.length - 1) {
                r.next = new ListNode();
                r = r.next;
            }
        }
        return head;
    }
}
