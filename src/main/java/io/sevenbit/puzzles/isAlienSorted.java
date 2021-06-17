package io.sevenbit.puzzles;

import java.util.HashMap;
import java.util.Map;

/**Leetcode 953. Verifying an Alien Dictionary **/
public class isAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> m = new HashMap<>(order.length());
        for(int i = 0; i < order.length(); i++) {
            m.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length-1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];

            int len1 = s1.length();
            int len2 = s2.length();
            int minLen = Math.min(len1, len2);
            boolean minLenMatch = true;
            for(int j = 0; j < minLen; j++) {
                char ch1 = s1.charAt(j);
                char ch2 = s2.charAt(j);
                int pos1 = m.get(ch1);
                int pos2 = m.get(ch2);
                if(pos1 > pos2) {
                    return false;
                } else if(pos1 < pos2) {
                    minLenMatch = false;
                    break;
                }
            }
            if(minLenMatch && len1 > len2) {
                return false;
            }
        }
        return true;
    }
}
