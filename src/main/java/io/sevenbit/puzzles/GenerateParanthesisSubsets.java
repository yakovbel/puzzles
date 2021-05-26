package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.List;

/***
 * Leet code 22 with subsets approach, see class GenerateParanthesisBacktracking for full description
 */
public class GenerateParanthesisSubsets {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
        } else {
            for (int i = 0; i < n; i++) {
                List<String> leftParts = generateParenthesis(i);
                for (String left : leftParts) {
                    List<String> rightParts = generateParenthesis(n - i - 1);
                    for(String right : rightParts) {
                        result.add("(" + left + ")" + right);
                    }
                }

            }
        }
        return result;
    }
}
