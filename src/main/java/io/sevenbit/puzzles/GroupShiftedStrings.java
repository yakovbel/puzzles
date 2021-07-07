package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 249. Group Shifted Strings
 */
public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> result = new HashMap<>();

        for(String str : strings) {
            String hash = hash(str);
            List<String> list = result.getOrDefault(hash, new ArrayList<>());
            list.add(str);
            result.put(hash, list);
        }
        return new ArrayList<>(result.values());
    }


    private String hash(String str) {
        char[] chars = str.toCharArray();
        char first = chars[0];
        StringBuilder sb = new StringBuilder();
        for(char ch : chars) {
            sb.append((100+(ch-first)) % 26); //100 to make sure number will be positive
        }
        return sb.toString();
    }
}
