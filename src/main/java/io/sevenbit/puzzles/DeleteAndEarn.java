package io.sevenbit.puzzles;

/**
 * Leetcode 740. Delete and Earn
 */
public class DeleteAndEarn {


    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        int[] ord = new int[10_001];
        for(int n : nums) {
            ord[n]++;
        }

        int avoid = 0;
        int using = 0;
        int prev = -1;
        for(int i = 0; i < ord.length; i++) {
            int max = Math.max(avoid, using);
            if(i - 1 != prev) {
                using = i*ord[i] + max; //using means we take i-th element(we have prev points + )
                avoid = max; //avoid meaning we don't take i-th element (we have points like in prev)
            } else {
                using = i*ord[i] + avoid;
                avoid = max;
            }
            prev = i;
        }
        return Math.max(avoid, using);
    }

}
