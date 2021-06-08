package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 51. N-Queens
 */
public class NQueens {
    List<List<String>> allSolutions = null;

    public List<List<String>> solveNQueens(int n) {
        allSolutions = new ArrayList<>();
        backtrack(0, n, new ArrayList<>());
        return allSolutions;
    }

    public void print(List<int[]> positions, int col, int row, int n) {
        List<String> result = generateResult(positions, n);
        int i = 0;

        System.out.println("\n");

        for(String str : result) {
            if(i == row) {
                System.out.println(str.substring(0, col) + "@" + str.substring(col+1));
            } else {
                System.out.println(str);
            }
            i++;
        }
    }

    public void backtrack(int row, int n, List<int[]> positions) {
        for(int col = 0; col < n; col++) {
            //print(positions, col, row, n);

            if(!canPlace(col, row, positions)) continue;

            positions.add(new int[]{col, row});

            if(row + 1== n) {
                List<String> result = generateResult(positions, n);
                allSolutions.add(result);
            } else {
                backtrack(row+1, n, positions);
            }

            positions.remove(positions.size() - 1);

        }
    }

    private static List<String> generateResult(List<int[]> solution, int n) {
        List<String> result = new ArrayList<>();
        List<char[]> rows = generateEmptyField(n);
        for(int[] pos : solution) {
            int x = pos[0];
            int y = pos[1];
            rows.get(y)[x] = 'Q';
        }
        for(char[] row : rows) {
            result.add(new String(row));
        }
        return result;
    }

    private static List<char[]> generateEmptyField(int n) {
        List<char[]> result = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            char[] row = new char[n];
            for(int j = 0; j < n; j++) {
                row[j] = '.';
            }
            result.add(row);
        }
        return result;
    }

    private static boolean canPlace(int col, int row, List<int[]> positions) {

        for(int i = 0; i < positions.size(); i++) {
            int x = positions.get(i)[0];
            int y = positions.get(i)[1];
            int b2= x + y; // for diag 1
            int b1 = y - x; // for diag 2
            if(col == x || row == y || row - col == b1 || row + col == b2) {
                return false;
            }
        }
        return true;
    }
}
