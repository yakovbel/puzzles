package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 */
public class GenerateParanthesisBacktracking {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisPart(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    public void generateParenthesisPart(List<String> result, StringBuilder sb, int left, int right, int max) {
        if (sb.length() == max * 2) {
            result.add(sb.toString());
            return;
        }

        if (left < max) {
            sb.append("(");
            generateParenthesisPart(result, sb, left + 1, right, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            generateParenthesisPart(result, sb, left, right + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
