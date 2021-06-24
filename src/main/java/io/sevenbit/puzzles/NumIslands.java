package io.sevenbit.puzzles;

import java.util.LinkedList;

/**
 * Leetcode 200. Number of Islands
 */
public class NumIslands {
    class Pair<K,V> {
        K key;
        V value;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public int numIslands(char[][] grid) {
        int len1 = grid.length;
        int len2 = grid[0].length;
        int result = 0;
        for(int i = 0; i < len1; i++) {
            for(int j = 0; j < len2; j++) {
                if(grid[i][j] == '0') {
                    continue;
                } else {
                    result++;
                    visitAllIsland(i,j, grid);
                }

            }
        }
        return result;
    }
    /*
    1 1 1
    0 1 0
    1 1 1
    */

    public void visitAllIsland(int iStart, int jStart,char[][] grid) {
        LinkedList<Pair<Integer,Integer>> q = new LinkedList<>();
        q.addFirst(new Pair<>(iStart,jStart));
        while(!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.poll();
            int i = cur.getKey();
            int j = cur.getValue();
            grid[i][j] = '0';
            if(i < grid.length - 1 && grid[i+1][j] == '1') {
                q.addFirst(new Pair<>(i+1,j)); //right
            }
            if(i > 0 && grid[i-1][j] == '1') {
                q.addFirst(new Pair(i-1, j)); //left
            }
            if(j < grid[0].length - 1 && grid[i][j+1] == '1') {
                q.addFirst(new Pair<>(i, j+1)); //down
            }
            if(j > 0 && grid[i][j-1] == '1') {
                q.addFirst(new Pair<>(i,j-1)); //up
            }

        }
    }
}
