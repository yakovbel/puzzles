package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 17. Letter Combinations of a Phone Number
 */
public class VKPhone {



    private Map<String, List<String>> mapping() {
        Map<String, List<String>> m = new HashMap<>();
        m.put("1", new ArrayList<>(0));
        m.put("2", List.of("a", "b", "c"));
        m.put("3", List.of("d", "e", "f"));
        m.put("4", List.of("g", "h", "i"));
        m.put("5", List.of("j", "k", "l"));
        m.put("6", List.of("m", "n", "o"));
        m.put("7", List.of("p", "q", "r", "s"));
        m.put("8", List.of("t", "u", "v"));
        m.put("9", List.of("w", "x", "y", "z"));

        return m;
    }

    /**
     1) a b c
     2) ad ae ac, bd be bc, cd ce cc:

     algo: first letter to queue:   с b a
     queue:  take a, for each new digit put ab ac


     **/

    public List<String> letterCombinations(String digits) {
        LinkedList<String> q = new LinkedList<>();
        Map<String, List<String>> m = mapping();

        for(int i = 0; i < digits.length(); i++) {
            Character digit = digits.charAt(i);
            List<String> characters = m.get(Character.toString(digit));
            if(i == 0) {
                for(String ch : characters) {
                    q.add(ch);
                }
            } else {
                while(true) {
                    String str = q.poll();
                    if(str == null) break;
                    for(String ch : characters) {
                        q.add(str + ch);
                    }
                }
            }
            if(i != digits.length() -1) {
                q.add(null);
            }
        }
        return q;

    }


}

