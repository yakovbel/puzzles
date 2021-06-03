package io.sevenbit.puzzles;

/**
 * Leetcode 6. ZigZag Conversion
 */
public class ZigZag {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        char[] result = new char[s.length()];
        int step = (numRows - 1) * 2;
        int k = 0;

        //vertical lines
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < s.length(); j+= step) {
                if(k >= s.length()) {
                    break;
                }
                int idx = i + j;
                if(idx >= s.length()) {
                    continue;
                }
                char ch = s.charAt(idx);
                result[k] = ch;
                if(i == 0 || i == numRows - 1) {
                    k++;
                } else {
                    //when fill vertical element in the middle, fill diag element too (with next index)
                    if(k+1 < s.length()) {
                        int diagIdx = j + step - i;
                        if(diagIdx < s.length()) {
                            result[k+1] = s.charAt(diagIdx);
                            k++;
                        }
                    }
                    k++;

                }
            }
        }


        return new String(result);
    }
}
