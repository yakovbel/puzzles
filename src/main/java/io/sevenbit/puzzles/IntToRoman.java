package io.sevenbit.puzzles;

/**
 * Leetcode 12. Integer to Roman
 */
public class IntToRoman {
    public String intToRoman(int num) {
        int[] nums =
                new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman =
                new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        StringBuilder sb = new StringBuilder();

        for(int i = nums.length - 1; i >= 0; i--) {
            while(num >= nums[i]) {
                num = num - nums[i];
                sb.append(roman[i]);
            }

        }
        return sb.toString();
    }
}
