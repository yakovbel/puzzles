package io.sevenbit.puzzles;

public class ReverseLinkedList2 {
    public class ListNode {
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

    //(1->2->3->4->5, 2,4) - ok
    //(3->5, 1, 1)
    //3->5, 1,2
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode cur = head;
        ListNode prev = head;
        for (int i = 1; i < left; i++) {
            if (cur == null) return head;
            prev = cur;
            cur = cur.next;
        }
        ListNode tail = reverseList(cur, right + 1 - left);
        if (head != cur) {
            prev.next = tail;
            return head;
        } else {
            return tail;
        }

    }

    public ListNode reverseList(ListNode head, int max) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode cur = head;
        ListNode next = null;
        ListNode prev = null;
        ListNode newTail = null;

        for (int i = 0; i < max; i++) {
            if (cur == null) return prev; // if list has fewer than max items, prev points to the head of reversed list
            if (i == 0) {
                newTail = cur;
            }
            next = cur.next; //save pointer to what we will do on the next step
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        //next points to the next non-reversed element
        newTail.next = next;

        return prev;
    }
}
