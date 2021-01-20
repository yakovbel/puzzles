package io.sevenbit.puzzles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Leetcode #3
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacter {
    //2N solution
    public static int lengthOfLongestSubstring(String s) {
        int best = 0;
        Set<Character> w = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            char ch = s.charAt(j);
            if (!w.contains(ch)) {
                w.add(ch);
                j++;
                best = Math.max(best, j - i);
            } else {
                char firstCh = s.charAt(i);
                w.remove(firstCh);
                i++;
            }
        }
        return best;
    }


    //N solution
    public static int lengthOfLongestSubstring2(String s) {
        int best = 0;
        Map<Character, Integer> w = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (w.containsKey(ch)) {
                i = Math.max(w.get(ch), i); //move to first occurrence of repeated character+1
            }
            best = Math.max(best, j + 1 - i);
            w.put(ch, j + 1);
        }
        return best;
    }

    public static int lengthOfLongestSubstringOptimized(String s) {
        int best = 0;
        int[] map = new int[128];
        Arrays.fill(map, -1);
        for (int i = 0, j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (map[(int) ch] != -1) {
                i = Math.max(i, map[(int) ch]);
            }
            best = Math.max(best, j + 1 - i);
            map[(int) ch] = j + 1;
        }
        return best;
    }

    public static void main(String args[]) {
        String str = "pwwkew";
        int result = lengthOfLongestSubstring2(str);
        if (result != 3) {
            throw new RuntimeException("wrong answer");
        }
        str = "aab";
        result = lengthOfLongestSubstring2(str);
        if (result != 2) {
            throw new RuntimeException("wrong answer");
        }
        str = "abcabcbb";
        result = lengthOfLongestSubstring2(str);
        if (result != 3) {
            throw new RuntimeException("wrong answer");
        }
        str = "dvdf";
        result = lengthOfLongestSubstring2(str);
        if (result != 3) {
            throw new RuntimeException("wrong answer");
        }
        str = "abba";
        result = lengthOfLongestSubstring2(str);
        if (result != 2) {
            throw new RuntimeException("wrong answer");
        }
    }
}
