package io.sevenbit.puzzles;

import java.util.PriorityQueue;

/**
 * Leetcode 23. Merge k Sorted Lists
 */
public class MergeKLists {
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

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        ListNode head = null;

        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>((n1, n2) -> {
            return n1.val - n2.val;
        });

        for (ListNode n : lists) {
            if (n != null) {
                q.add(n);
            }
        }

        while (q.size() > 0) {
            ListNode cur = q.poll();

            if (result == null) {
                result = cur;
                head = cur;
            } else {
                result.next = cur;
                result = cur;
            }

            if (cur.next != null) {
                q.add(cur.next);
            }
        }
        if (result != null) {
            result.next = null;
        }

        return head;
    }
}
