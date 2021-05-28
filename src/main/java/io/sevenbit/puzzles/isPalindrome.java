package io.sevenbit.puzzles;

import java.util.Set;

public class isPalindrome {

    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        String str = Integer.toString(x);
        for(int i = 0; i < str.length(); i++) {
            int j = str.length() - 1 - i;
            if(j == i) return true;
            if(str.charAt(i) != str.charAt(j)) return false;
        }
        return false;



    }

    public AddTwoNumbers.ListNode reverseList(AddTwoNumbers.ListNode head) {
        AddTwoNumbers.ListNode cur = head;
        AddTwoNumbers.ListNode prev = null;
        AddTwoNumbers.ListNode next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

        }
        return prev;
    }

}
