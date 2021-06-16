package io.sevenbit.puzzles;

/**
 * Leetcode 14. Longest Common Prefix
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String first = strs[0]; // "flower"
        for(int i = 0; i < first.length(); i++) {
            char firstCh = first.charAt(i);
            for(int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if(str.length() <= i) {
                    return first.substring(0, i);
                }
                char ch = str.charAt(i);
                if(ch != firstCh) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }
}
