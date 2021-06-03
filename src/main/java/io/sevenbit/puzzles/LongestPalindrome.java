package io.sevenbit.puzzles;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] table = new boolean[len][len];

        int iMax = 0;
        int maxLen = 1;
        // fill result for all substrings with len = 1
        for(int i = 0; i < len; i++) {
            table[i][i] = true;
        }
        // fill result for all substring with len = 2
        for(int i = 0; i < len -1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                table[i][i+1] = true;
                iMax = i;
                maxLen = 2;
            }
        }
        //for len > 3 calculate answer recursively: table[i][j] = table[i+1][j-1] ? str[i] == str[j] : false
        for(int k = 3; k <= len; k++) {
            for(int i = 0; i < len - k + 1; i++) {
                int j = i + k - 1;
                if(table[i+1][j-1] == true) {
                    if(s.charAt(i) == s.charAt(j)) {
                        if(k > maxLen) {
                            maxLen = k;
                            iMax = i;
                        }
                        table[i][j] = true;
                    }
                }

            }
        }
        return s.substring(iMax, iMax + maxLen);
    }

    public void printTable(boolean[][] arr) {
        int len = arr.length;
        for(int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < len; j++) {
                sb.append(arr[i][j] == true ? "1" : "0");
            }
            System.out.println(sb.toString());
        }
    }
}
