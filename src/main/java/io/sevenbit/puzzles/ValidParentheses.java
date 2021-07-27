package io.sevenbit.puzzles;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode 20. Valid Parentheses
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                char prev = stack.peek();
                if ((ch == ')' && prev == '(') || (ch == ']' && prev == '[') || (ch == '}' && prev == '{')) {
                    stack.pop();
                } else return false;
            }
        }
        return stack.isEmpty();

    }
}
