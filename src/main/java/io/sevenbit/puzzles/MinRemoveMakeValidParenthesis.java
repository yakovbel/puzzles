package io.sevenbit.puzzles;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Leetcode 1249. Minimum Remove to Make Valid Parentheses
 */
public class MinRemoveMakeValidParenthesis {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> toRemove = new HashSet<>();
        LinkedList<Integer> stack = new LinkedList<Integer>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.add(i);
            } else if( ch == ')') {
                if(stack.isEmpty()) {
                    toRemove.add(i);
                } else {
                    stack.removeFirst();
                }
            } else {
                continue;
            }
        }
        toRemove.addAll(stack);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!toRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
