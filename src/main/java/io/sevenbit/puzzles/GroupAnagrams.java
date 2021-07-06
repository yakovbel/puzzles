package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
LeetCode 49. Group Anagrams
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<>();
        for(String str : strs) {
            String hash = calculateHash(str);
            List<String> group = result.getOrDefault(hash, new ArrayList<>());
            group.add(str);
            result.put(hash, group);
        }
        return new ArrayList<>(result.values());
    }

    String calculateHash(String s) {
        char[] result = new char[26];
        char[] iter = s.toCharArray();
        for(char ch : iter) {
            result[ch-'a']++;
        }
        return new String(result);
    }
}
